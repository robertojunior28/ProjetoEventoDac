package br.edu.ifpb.dac.junior.business.service.impl;

import java.awt.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import br.edu.ifpb.dac.junior.business.dto.LoginResponseDto;
import br.edu.ifpb.dac.junior.business.dto.RegisterDto;
import br.edu.ifpb.dac.junior.business.dto.UserDto;
import br.edu.ifpb.dac.junior.business.service.AuthorizationService;
import br.edu.ifpb.dac.junior.config.TokenService;
import br.edu.ifpb.dac.junior.model.entity.UserModel;
import br.edu.ifpb.dac.junior.model.enums.UserRole;
import br.edu.ifpb.dac.junior.model.repository.UserRepository;
import br.edu.ifpb.dac.junior.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class AuthorizationServiceImpl implements UserDetailsService, AuthorizationService {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }


    public LoginResponseDto login(String username, String password){
        authenticationManager = context.getBean(AuthenticationManager.class);

        var usernamePassword = new UsernamePasswordAuthenticationToken(username, password);
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((UserModel) auth.getPrincipal());

        UserDetails userDetails = this.loadUserByUsername(username);
        UserModel userModel = userRepository.findByEmail(username);

        UserDto userDto = Convert.userToDto(userModel);
        return new LoginResponseDto(token, userDto);
    }


    public UserDto register (RegisterDto registerDto){
        if (!isValidEmail(registerDto.getEmail())) {
            throw new HeadlessException("Erro, email invalido!");
        }

        if (this.userRepository.findByEmail(registerDto.getEmail()) != null) {
            throw new HeadlessException("Erro, email já cadastrado!");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.getPassword());

        UserModel newUser = new UserModel(registerDto.getEmail(), registerDto.getName(), encryptedPassword, UserRole.USER);
        this.userRepository.save(newUser);

        return Convert.userToDto(newUser);
    }

    @Override
    public boolean isValid(String token) {
        return tokenService.isValid(token);
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    @Override
    public UserDto getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Convert.userToDto((UserModel) authentication.getPrincipal());
    }


}
