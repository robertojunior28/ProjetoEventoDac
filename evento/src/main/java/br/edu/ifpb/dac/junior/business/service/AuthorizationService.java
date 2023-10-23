package br.edu.ifpb.dac.junior.business.service;

import br.edu.ifpb.dac.junior.business.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthorizationService {
    UserDetails loadUserByUsername(String email);
    LoginResponseDto login(String username, String password);
    UserDto register(RegisterDto registerDto);

    boolean isValid(String token);
    boolean isValidEmail(String email);

    UserDto getLoggedUser();
}
