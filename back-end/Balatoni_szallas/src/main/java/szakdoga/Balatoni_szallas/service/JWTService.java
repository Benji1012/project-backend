package szakdoga.Balatoni_szallas.service;

//import java.util.Date;
//import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;

//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import szakdoga.Balatoni_szallas.model.User;

public interface JWTService {
	 String generateToken(UserDetails userDetails) ;
	
	 String extractUserName(String token);
	 
	 
	 boolean isTokenValid(String token, UserDetails userDetails);

	 String generateRefreshToken(Map<String, Object> extraClaims,UserDetails userDetails);
	 
	 
}
