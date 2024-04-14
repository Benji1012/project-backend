package szakdoga.Balatoni_szallas.dto;

import lombok.Data;
import szakdoga.Balatoni_szallas.model.Role;

@Data
public class JwtAuthenticationResponse {
	
	private String token;
	
	private String refreshToken;
	private String userName;
	private Long id;
	private Role role;
	

}
