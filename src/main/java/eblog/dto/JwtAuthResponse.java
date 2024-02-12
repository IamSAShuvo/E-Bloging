package eblog.dto;

import eblog.domain.User;
import lombok.Data;

@Data
public class JwtAuthResponse {
	private String token;
	
	private UserDto user;
}
