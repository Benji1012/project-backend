package szakdoga.Balatoni_szallas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;
import szakdoga.Balatoni_szallas.dto.JwtAuthenticationResponse;
import szakdoga.Balatoni_szallas.dto.RefreshTokenRequest;
import szakdoga.Balatoni_szallas.dto.SignUpRequest;
import szakdoga.Balatoni_szallas.dto.SigninRequest;
import szakdoga.Balatoni_szallas.model.User;
import szakdoga.Balatoni_szallas.repository.UserRepository;
import szakdoga.Balatoni_szallas.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {

	private final AuthenticationService authenticationService ;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/signup")
	public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest){
		return ResponseEntity.ok(authenticationService.signup(signUpRequest));
	}
	
	
	@PostMapping("/signin")
	public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest){
		return ResponseEntity.ok(authenticationService.signin(signinRequest));
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<JwtAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
		return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
	}
	
	 @GetMapping("/usernames")
    public List<String> getAllUserUserNames() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(User::getUsername)
                .collect(Collectors.toList());
    }
	 
	 @GetMapping("/emails")
	    public List<String> getAllUserEmails() {
	        List<User> users = userRepository.findAll();
	        return users.stream()
	                .map(User::getEmail)
	                .collect(Collectors.toList());
	    }
	 
}
