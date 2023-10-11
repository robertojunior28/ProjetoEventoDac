package br.edu.ifpb.dac.junior.business.service.impl;

import br.edu.ifpb.dac.junior.model.entity.Event;
import br.edu.ifpb.dac.junior.business.dto.EventDto;
import br.edu.ifpb.dac.junior.model.entity.Local;
import br.edu.ifpb.dac.junior.model.repository.EventRepository;
import br.edu.ifpb.dac.junior.business.service.EventService;
import br.edu.ifpb.dac.junior.model.repository.LocalRepository;
import br.edu.ifpb.dac.junior.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private LocalRepository localRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;

    }



    @Override
    public EventDto save(EventDto eventDto) {
        Event eventSave = eventRepository.save(Convert.dtoToEvent(eventDto));
        return Convert.EventToDto(eventSave);
    }

    @Override
    public EventDto update(Long id, EventDto eventDto) {
        Event recoveredEvent = eventRepository.findById(id).orElseThrow();
        recoveredEvent.setTitle(eventDto.getTitle());
        recoveredEvent.setDescription(eventDto.getDescription());
        recoveredEvent.setDate(eventDto.getDate());
        recoveredEvent.setTime(eventDto.getTime());

        Local local = localRepository.getReferenceById(eventDto.getIdLocal());
        local.setStreet(eventDto.getStreet());
        local.setNumber(eventDto.getNumber());
        local.setCity(eventDto.getCity());
        local.setUf(eventDto.getUf());

        //recoveredEvent.setLocals(local);
        recoveredEvent.getLocals().add(local);
        Event updatedEvent = eventRepository.save(recoveredEvent);

        return Convert.EventToDto(updatedEvent);
    }

    public EventDto findById(Long id){
        Event recoveredEvent = eventRepository.findById(id).orElseThrow();
        return Convert.EventToDto(recoveredEvent);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> recoveredEvents = eventRepository.findAll();

        List<EventDto> eventsDto = recoveredEvents.stream().map(
                event -> Convert.EventToDto(event)).collect(Collectors.toList());

        return eventsDto;
    }
    public void delete(Long id){
        Event recoveredEvent = eventRepository.findById(id).orElseThrow();
        eventRepository.deleteById(id);
    }
}
