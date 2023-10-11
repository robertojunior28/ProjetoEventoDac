package br.edu.ifpb.dac.junior.presentation.controller;

import br.edu.ifpb.dac.junior.business.service.LocalService;
import br.edu.ifpb.dac.junior.business.dto.LocalDto;
import br.edu.ifpb.dac.junior.business.service.impl.LocalServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/local")
public class LocalController {
    private LocalService localService;
    @Autowired
    public LocalController(LocalServiceImpl localService) {
        this.localService = localService;
    }
    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody LocalDto localDto){
        try {
            return new ResponseEntity(localService.salvar(localDto), HttpStatus.CREATED) ;
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity update(@RequestBody LocalDto localDto, @PathVariable long id) {
        try {
            return new ResponseEntity<>(localService.update(id, localDto), HttpStatus.OK);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity recoveredById(@PathVariable long id){
        try {
            return new ResponseEntity<>(localService.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity recoveredAll(){
        try {
            return new ResponseEntity<>(localService.findAll(), HttpStatus.OK) ;
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteLocal(@PathVariable long id){
        try {
            localService.delete(id);
            return new ResponseEntity<>("Local entity deleted successful.", HttpStatus.OK);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
