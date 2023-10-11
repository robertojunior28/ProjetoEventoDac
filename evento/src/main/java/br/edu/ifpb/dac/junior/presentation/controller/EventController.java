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
    public ResponseEntity create(@RequestBody EventDto eventDto){
        try {
            return new ResponseEntity(eventService.save(eventDto), HttpStatus.CREATED);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity update(@RequestBody EventDto eventDto, @PathVariable long id ) {
        try {
            return new ResponseEntity(eventService.update(id, eventDto), HttpStatus.OK);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity recovergitByID(@PathVariable long id){
        try {
            return new ResponseEntity(eventService.findById(id), HttpStatus.OK) ;
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity recoverAll(){
        try {
            return new ResponseEntity<>(eventService.findAllEvents(), HttpStatus.OK) ;
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteEvent(@PathVariable long id){
        try {
            eventService.delete(id);
            return new ResponseEntity<>("Event entity deleted successful.", HttpStatus.OK);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
