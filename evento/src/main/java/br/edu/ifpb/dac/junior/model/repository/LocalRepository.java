package br.edu.ifpb.dac.junior.model.repository;

import br.edu.ifpb.dac.junior.model.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalRepository extends JpaRepository<Local, Long> {
}
