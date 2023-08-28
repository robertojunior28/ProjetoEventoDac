package br.edu.ifpb.dac.junior.presentation.controller;

import br.edu.ifpb.dac.junior.business.service.EventService;
import br.edu.ifpb.dac.junior.business.dto.EventDto;
import br.edu.ifpb.dac.junior.business.service.impl.EventServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private EventService eventService;
    @Autowired
    public EventController(EventServiceImpl eventService) {
        this.eventService = eventService;
    }
    @PostMapping
    @Transactional
    public EventDto create(@RequestBody EventDto eventDto){
        return eventService.save(eventDto);
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EventDto> update(@RequestBody EventDto eventDto, @PathVariable long id ) {
        return new ResponseEntity<>(eventService.update(id, eventDto), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EventDto> recovergitByID(@PathVariable long id){
        return new ResponseEntity<>(eventService.findById(id), HttpStatus.OK) ;
    }
    @GetMapping
    public ResponseEntity<List<EventDto>> recoverAll(){
        return new ResponseEntity<>(eventService.findAllEvents(), HttpStatus.OK) ;
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteEvent(@PathVariable long id){
        eventService.delete(id);
        return new ResponseEntity<>("Event entity deleted successful.", HttpStatus.OK);
    }

}
