package br.edu.ifpb.dac.junior.business.dto;

import br.edu.ifpb.dac.junior.model.enums.UserRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    private Long id;
    private String email;
    private String name;
    private String password;
    private UserRole userRole;


}
