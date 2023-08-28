package br.edu.ifpb.dac.junior.model.repository;

import br.edu.ifpb.dac.junior.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
