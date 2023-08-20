package br.edu.ifpb.dac.junior.model.repository;

import br.edu.ifpb.dac.junior.model.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
