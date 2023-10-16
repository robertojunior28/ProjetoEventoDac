package br.edu.ifpb.dac.junior.business.service;

import br.edu.ifpb.dac.junior.business.dto.AuthetinticationDto;
import br.edu.ifpb.dac.junior.business.dto.LoginResponseDto;
import br.edu.ifpb.dac.junior.business.dto.RegisterDto;
import br.edu.ifpb.dac.junior.business.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthorizationService {
    UserDetails loadUserByUsername(String email);
    LoginResponseDto login(UserDto data);
    UserDto register(RegisterDto registerDto);

    boolean isValid(String token);
    boolean isValidEmail(String email);
}
