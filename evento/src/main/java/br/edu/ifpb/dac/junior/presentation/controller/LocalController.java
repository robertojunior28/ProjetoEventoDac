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
    public ResponseEntity<LocalDto> create(@RequestBody LocalDto localDto){
        return new ResponseEntity<>(localService.salvar(localDto), HttpStatus.CREATED) ;
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<LocalDto> update(@RequestBody LocalDto localDto, @PathVariable long id) {
        return new ResponseEntity<>(localService.update(id, localDto), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LocalDto> recoveredById(@PathVariable long id){
        return new ResponseEntity<>(localService.findById(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<LocalDto>> recoveredAll(){
        return new ResponseEntity<>(localService.findAll(), HttpStatus.OK) ;
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteLocal(@PathVariable long id){
        localService.delete(id);
        return new ResponseEntity<>("Local entity deleted successful.", HttpStatus.OK);
    }
}
