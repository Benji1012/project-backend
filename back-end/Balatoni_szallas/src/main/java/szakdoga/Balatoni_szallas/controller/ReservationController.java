package szakdoga.Balatoni_szallas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import szakdoga.Balatoni_szallas.model.Apartman;
import szakdoga.Balatoni_szallas.model.Reservation;
import szakdoga.Balatoni_szallas.model.User;
import szakdoga.Balatoni_szallas.repository.ApartmanRepository;
import szakdoga.Balatoni_szallas.repository.ReservationRepository;
import szakdoga.Balatoni_szallas.repository.UserRepository;
import szakdoga.Balatoni_szallas.service.EmailService;
import szakdoga.Balatoni_szallas.service.impl.EmailServiceImpl;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private ApartmanRepository apartmanRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private EmailService emailService;
	
	 
	@PutMapping("/new")
	Reservation newReservation(@RequestBody Reservation newReservation) {
		Optional<User> optionalUser = userRepository.findById(newReservation.getUserId());
		User user = optionalUser.get();
		 emailService.sendEmail(user.getEmail(), "Sikeres foglalás", 
				 "Ön sikeresen lefoglalta a következő szállást: "+newReservation.getApartmanName());
		return reservationRepository.save(newReservation);
	}
	@GetMapping("/{userId}")
	ResponseEntity<List<Reservation>> getReservationsByUserId(@PathVariable Long userId){
		List<Reservation> reservations = reservationRepository.findByUserId(userId);
		if(reservations.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    } else {
	        return ResponseEntity.ok(reservations);
	    }
	}
	
	@GetMapping("/apartman/{apartmanId}")
	ResponseEntity<List<Reservation>> getReservationsByApartmanId(@PathVariable Long apartmanId){
		 Optional<Apartman> optionalApartman = apartmanRepository.findById(apartmanId);
		   
		    	Apartman apartman = optionalApartman.get();
		List<Reservation> reservations = reservationRepository.findByApartman(apartman);
		if(reservations.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	    } else {
	        return ResponseEntity.ok(reservations);
	    }
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/delete/{id}")
	 public ResponseEntity deleteReservationById( @PathVariable Long id) {
		reservationRepository.deleteById(id);
		 if(!reservationRepository.findById(id).isPresent()) {
			 return ResponseEntity.ok("ok");
		 }else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		 }
			        
			}
}
