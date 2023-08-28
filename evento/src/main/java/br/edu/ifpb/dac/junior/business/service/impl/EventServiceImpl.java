package br.edu.ifpb.dac.junior.business.service.impl;

import br.edu.ifpb.dac.junior.model.entity.Event;
import br.edu.ifpb.dac.junior.business.dto.EventDto;
import br.edu.ifpb.dac.junior.model.repository.EventRepository;
import br.edu.ifpb.dac.junior.business.service.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EventServiceImpl implements EventService {
    private ModelMapper mapper;
    private EventRepository eventRepository;
    @Autowired
    public EventServiceImpl(ModelMapper mapper, EventRepository eventRepository) {
        this.mapper = mapper;
        this.eventRepository = eventRepository;
    }

    @Override
    public EventDto save(EventDto eventDto) {
        Event eventSave = eventRepository.save(mapper.map(eventDto, Event.class));
        return mapper.map(eventSave, EventDto.class);
    }

    @Override
    public EventDto update(long id, EventDto eventDto) {
        Event recoveredEvent = eventRepository.findById(id).orElseThrow();
        recoveredEvent.setTitle(eventDto.getTitle());
        recoveredEvent.setDescription(eventDto.getDescription());
        recoveredEvent.setDate(eventDto.getDate());
        recoveredEvent.setTime(eventDto.getTime());
        recoveredEvent.setLocals(eventDto.getLocals());
        Event updatedEvent = eventRepository.save(recoveredEvent);
        return mapper.map(updatedEvent, EventDto.class);
    }

    public EventDto findById(long id){
        Event recoveredEvent = eventRepository.findById(id).orElseThrow();
        return mapper.map(recoveredEvent, EventDto.class);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> recoveredEvents = eventRepository.findAll();

        List<EventDto> eventsDto = recoveredEvents.stream().map(
                event -> mapper.map(event, EventDto.class)).collect(Collectors.toList());

        return eventsDto;
    }
    public void delete(long id){
        Event recoveredEvent = eventRepository.findById(id).orElseThrow();
        eventRepository.deleteById(id);
    }
}
