package szakdoga.Balatoni_szallas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PutMapping("/new")
	Review newReview(@RequestBody Review newReview) {
		
		reviewRepository.save(newReview);
		updateApartmanPoints(newReview.getApartmanId());
		updateLoyalityPoints(newReview.getUserId());
		return newReview;
	}
	
	@GetMapping("/view/{apartmanId}")
	ResponseEntity<List<Review>> getReviewsByApartmanId(@PathVariable Long apartmanId){
		List<Review> reviews = reviewRepository.findByApartmanId(apartmanId);
		if(reviews.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    } else {
	        return ResponseEntity.ok(reviews);
	    }
	}
	
	private void updateApartmanPoints(Long apartmanId) {
		List<Review> reviews = reviewRepository.findByApartmanId(apartmanId);
		 int totalPoints = 0;
		    int numberOfReviews = reviews.size();
		    
		    // Calculate the total points
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
}
