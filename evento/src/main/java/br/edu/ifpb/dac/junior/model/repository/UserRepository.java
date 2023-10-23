package br.edu.ifpb.dac.junior.model.repository;


import br.edu.ifpb.dac.junior.model.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;



public interface UserRepository extends JpaRepository<UserModel, Long> {


    UserModel findByEmail(String email);


}
