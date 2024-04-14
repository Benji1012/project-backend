package szakdoga.Balatoni_szallas.service.impl;

import java.util.HashMap;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import szakdoga.Balatoni_szallas.dto.JwtAuthenticationResponse;
import szakdoga.Balatoni_szallas.dto.RefreshTokenRequest;
import szakdoga.Balatoni_szallas.dto.SignUpRequest;
import szakdoga.Balatoni_szallas.dto.SigninRequest;
import szakdoga.Balatoni_szallas.model.Role;
import szakdoga.Balatoni_szallas.model.User;
import szakdoga.Balatoni_szallas.repository.UserRepository;
import szakdoga.Balatoni_szallas.service.AuthenticationService;
import szakdoga.Balatoni_szallas.service.JWTService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

	private final UserRepository userRepository ;
	
	
	private final PasswordEncoder passwordEncoder ;
	
	private final AuthenticationManager authenticationManager;
	
	private final JWTService jwtService;
	
	public User signup(SignUpRequest signUpRequest) {
		User user = new User();
		
		user.setEmail(signUpRequest.getEmail());
		user.setName(signUpRequest.getName());
		user.setRole(Role.USER);
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		user.setUsername(signUpRequest.getUserName());
		
		
		return userRepository.save(user);
	}
	
	public JwtAuthenticationResponse signin(SigninRequest signinRequest) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getUsername(), signinRequest.getPassword()));
		
		var user = userRepository.findByUsername(signinRequest.getUsername()).orElseThrow(() -> 
		new IllegalArgumentException("Nem megfelelő felhasználónév vagy jelszó"));
		
		var jwt = jwtService.generateToken(user);
		var refreshToken = jwtService.generateRefreshToken(new HashMap<>(),user);
		var id = user.getId();
		var userName = user.getUsername();
		var role = user.getRole();
		
		JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
		
		jwtAuthenticationResponse.setToken(jwt);
		jwtAuthenticationResponse.setRefreshToken(refreshToken);
		jwtAuthenticationResponse.setId(id);
		jwtAuthenticationResponse.setUserName(userName);
		jwtAuthenticationResponse.setRole(role);
		
		return jwtAuthenticationResponse;
	}
	
	
	
	public JwtAuthenticationResponse refreshToken (RefreshTokenRequest refreshTokenRequest) {
		
		String userName = jwtService.extractUserName(refreshTokenRequest.getToken());
		//System.out.println("Email amit keres: "+userName);
		User user = userRepository.findByUsername(userName).orElseThrow();
		if(jwtService.isTokenValid(refreshTokenRequest.getToken(), user)) {
			var jwt = jwtService.generateToken(user);
			
			JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
			
			jwtAuthenticationResponse.setToken(jwt);
			jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
			
			return jwtAuthenticationResponse;
		}
		return null;
			
	}
}
