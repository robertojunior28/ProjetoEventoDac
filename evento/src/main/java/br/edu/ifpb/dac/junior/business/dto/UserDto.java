package br.edu.ifpb.dac.junior.business.dto;

import br.edu.ifpb.dac.junior.model.entity.UserModel;
import br.edu.ifpb.dac.junior.model.enums.UserRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    private List<UserRole> userRole = new ArrayList<>();


    public void setUserRole(UserModel user) {
        if(user.getUserRole().getRole() != null) {
            if (user.getUserRole().getRole() == UserRole.ADMIN.getRole()) {
                userRole.add(UserRole.ADMIN);
                userRole.add(UserRole.USER);
            } else {
                userRole.add(UserRole.USER);
            }
        }
    }
}
