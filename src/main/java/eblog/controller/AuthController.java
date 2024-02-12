package eblog.controller;

import java.net.http.HttpRequest;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eblog.domain.User;
import eblog.dto.JwtAuthRequest;
import eblog.dto.JwtAuthResponse;
import eblog.dto.UserDto;
import eblog.exception.ApiException;
import eblog.security.JwtTokenHelper;
import eblog.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService service;

	private UserDetails userDetails;
	
	@Autowired
	private ModelMapper mapper;

	// create users
	@PostMapping("/register")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		return new ResponseEntity<>(this.service.createUser(userDto), HttpStatus.CREATED);

	}

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception {

		this.authenticate(request.getEmail(), request.getPassword());
		try {
			userDetails = this.userDetailsService.loadUserByUsername(request.getEmail());
		} catch (BadCredentialsException e) {
			System.out.println("error...");
			throw new ApiException("Invalid User name or Password");
		}
		String token = this.jwtTokenHelper.generateToken(userDetails);

		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		response.setUser(this.mapper.map((User)userDetails, UserDto.class));

		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
	}

	private void authenticate(String userName, String password) throws Exception {

		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userName, password);
		try {
			this.authenticationManager.authenticate(authToken);
		} catch (BadCredentialsException e) {

			throw new ApiException("Invalid User name or Password");
		}

	}

}
