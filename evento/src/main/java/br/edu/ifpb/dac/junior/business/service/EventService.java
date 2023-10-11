package br.edu.ifpb.dac.junior.business.service;

import br.edu.ifpb.dac.junior.business.dto.EventDto;

import java.util.List;
public interface EventService {
    EventDto save(EventDto eventDto);
    EventDto update(Long id, EventDto eventDto);
    EventDto findById(Long id);
    List<EventDto> findAllEvents();
    void delete(Long id);
}
