package br.edu.ifpb.dac.junior.business.service;

import br.edu.ifpb.dac.junior.business.dto.EventDto;

import java.util.List;
public interface EventService {
    EventDto save(EventDto eventDto);
    EventDto update(long id, EventDto eventDto);
    EventDto findById(long id);
    List<EventDto> findAllEvents();
    void delete(long id);
}
