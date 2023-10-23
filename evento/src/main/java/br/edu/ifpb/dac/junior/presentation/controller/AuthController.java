package br.edu.ifpb.dac.junior.presentation.controller;

import br.edu.ifpb.dac.junior.business.dto.LoginDto;
import br.edu.ifpb.dac.junior.business.dto.RegisterDto;
import br.edu.ifpb.dac.junior.business.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
@RequestMapping("auth")
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class AuthController {

    @Autowired
    AuthorizationService authorizationService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDto authetinticationDto){
        try {
            return new ResponseEntity(authorizationService.login(authetinticationDto.email(), authetinticationDto.password()), HttpStatus.OK);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/register")
    public ResponseEntity register (@RequestBody RegisterDto registerDto){
        try {
            return new ResponseEntity(authorizationService.register(registerDto), HttpStatus.OK);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/isTokenValid")
    public ResponseEntity isTokenValid(@RequestBody String token) {
        try {
            boolean isTokenValid = authorizationService.isValid(token);

            return new ResponseEntity(isTokenValid, HttpStatus.OK);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
