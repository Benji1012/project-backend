package szakdoga.Balatoni_szallas.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import szakdoga.Balatoni_szallas.model.User;
import szakdoga.Balatoni_szallas.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "")
public class UserController {
	
	private final UserRepository userRepository ;

	@GetMapping("")
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.ok("Hi user");
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/view/{id}")
	 public ResponseEntity<User> getUserBydId( @PathVariable Long id) {
		 return userRepository.findById(id)
			        .map(user -> ResponseEntity.ok(user))
			        .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null));
			}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/edit/{id}")
	 public ResponseEntity<User> updateUserById( @PathVariable Long id, @RequestBody User updatedUser) {
		 Optional<User> optionalUser = userRepository.findById(id);
		    if (optionalUser.isPresent()) {
		        User user = optionalUser.get();
		        user.setEmail(updatedUser.getEmail());
		        user.setName(updatedUser.getName());
		        user.setCity(updatedUser.getCity());
		        user.setAddress(updatedUser.getAddress());
		        user.setMobil(updatedUser.getMobil());
		        user.setPersonalId(updatedUser.getPersonalId());
		        user.setTaxIdNumber(updatedUser.getTaxIdNumber());
		        user.setIsPrivatePerson(updatedUser.getIsPrivatePerson());
		        userRepository.save(user);
		        return ResponseEntity.ok(user);
		    } else {
		        return ResponseEntity.notFound().build();
		    }
	}

}
