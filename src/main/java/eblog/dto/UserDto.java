package eblog.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor

@Data
public class UserDto {

	private int id;

	@NotEmpty
	@Size(min = 2, message = "Name must be minimum 2 characters")
	private String name;

	@Email(message = "Invalid email")
	@NotEmpty
	private String email;
	
	@NotBlank
	@Size(min = 2, message = "Password must be minimum 2 characters")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
	private String password;

	@NotBlank
	@Size(min = 10, max = 100)
	private String about;
	
	
	private Set<RoleDto> roles = new HashSet<RoleDto>();

}
