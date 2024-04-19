package szakdoga.Balatoni_szallas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import szakdoga.Balatoni_szallas.model.Apartman;
import szakdoga.Balatoni_szallas.model.Review;
import szakdoga.Balatoni_szallas.model.User;
import szakdoga.Balatoni_szallas.repository.ApartmanRepository;
import szakdoga.Balatoni_szallas.repository.ReviewRepository;
import szakdoga.Balatoni_szallas.repository.UserRepository;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private ApartmanRepository apartmanRepository;
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/view/{apartmanId}")
	ResponseEntity<List<Review>> getReviewsByApartmanId(@PathVariable Long apartmanId){
		List<Review> reviews = reviewRepository.findByApartmanId(apartmanId);
		if(reviews.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    } else {
	        return ResponseEntity.ok(reviews);
	    }
	}
	
	@GetMapping("/user/{userId}")
	ResponseEntity<List<Review>> getReviewsByUserId(@PathVariable Long userId){
		List<Review> reviews = reviewRepository.findByUserId(userId);
		if(reviews.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    } else {
	        return ResponseEntity.ok(reviews);
	    }
	}
	
	@PutMapping("/new")
	Review newReview(@RequestBody Review newReview) {
		
		reviewRepository.save(newReview);
		updateApartmanPoints(newReview.getApartmanId());
		updateLoyalityPoints(newReview.getUserId());
		return newReview;
	}
	
	private void updateApartmanPoints(Long apartmanId) {
		List<Review> reviews = reviewRepository.findByApartmanId(apartmanId);
		 int totalPoints = 0;
		    int numberOfReviews = reviews.size();
		    
		    for (Review review : reviews) {
		        totalPoints += review.getReviewPoint();
		    }
		    
		    double averagePoints = numberOfReviews > 0 ? (double) totalPoints / numberOfReviews : 0.0;
		    Optional<Apartman> optionalApartman = apartmanRepository.findById(apartmanId);
		    if (optionalApartman.isPresent()) {
		    	Apartman apartman = optionalApartman.get();
		    	apartman.setReviewPoints(averagePoints);
		    	apartmanRepository.save(apartman);
		    }
		    
		    
	}
	
	private void updateLoyalityPoints(Long userId) {
		System.out.println("User:id: "+userId);
		Optional<User> optionalUser = userRepository.findById(userId);
		User user = optionalUser.get();
		user.setLoyaltyPoint(user.getLoyaltyPoint()+1000);
		    userRepository.save(user);
		    
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/delete/{id}")
	 public ResponseEntity deleteReviewById( @PathVariable Long id) {
		Review review = reviewRepository.findByReviewId(id);
		System.out.println("Id: "+id);
		updateApartmanPoints(review.getApartmanId());
		reviewRepository.deleteById(id);
		 if(!reviewRepository.findById(id).isPresent()) {
			 return ResponseEntity.ok("ok");
		 }else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		 }
			        
			}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/view/one/{id}")
	public ResponseEntity getReviewByReviewId(@PathVariable Long id){
		Review review = reviewRepository.findByReviewId(id);
		if(review == null) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    } else {
	        return ResponseEntity.ok(review);
	    }
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/edit/{id}")
	 public ResponseEntity<Review> updateReviewById( @PathVariable Long id, @RequestBody Review updatedReview) {
		 Optional<Review> optionalReview = reviewRepository.findById(id);
		    if (optionalReview.isPresent()) {
		    	Review review = optionalReview.get();
		    	review.setReviewPoint(updatedReview.getReviewPoint());
		    	review.setReviewComment(updatedReview.getReviewComment());
		        
		    	reviewRepository.save(review);
		        return ResponseEntity.ok(review);
		    } else {
		        return ResponseEntity.notFound().build();
		    }
	}
	
	
}
