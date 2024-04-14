package szakdoga.Balatoni_szallas.service;

import szakdoga.Balatoni_szallas.dto.JwtAuthenticationResponse;
import szakdoga.Balatoni_szallas.dto.RefreshTokenRequest;
import szakdoga.Balatoni_szallas.dto.SignUpRequest;
import szakdoga.Balatoni_szallas.dto.SigninRequest;
import szakdoga.Balatoni_szallas.model.User;

public interface AuthenticationService {

	User signup(SignUpRequest signUpRequest);
	
	JwtAuthenticationResponse signin(SigninRequest signinRequest);
	
	JwtAuthenticationResponse refreshToken (RefreshTokenRequest refreshTokenRequest);
	
}
