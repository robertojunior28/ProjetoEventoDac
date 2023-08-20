package br.edu.ifpb.dac.junior.controller;

import br.edu.ifpb.dac.junior.view.payload.EventoDto;
import br.edu.ifpb.dac.junior.model.service.impl.EventoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EventoController {

    private EventoServiceImpl eventoService;
    @Autowired
    public EventoController(EventoServiceImpl eventoService) {
        this.eventoService = eventoService;
    }

    public EventoDto criar(EventoDto eventoDto){
        return eventoService.salvar(eventoDto);
    }

    public EventoDto atulizar(EventoDto eventoDto) {
        return eventoService.atualizar(eventoDto);
    }

    public EventoDto recuperarId(Long id){
        return eventoService.recuperarId(id);
    }

    public List<EventoDto> recuperarTodos(){
        return eventoService.recuperarTodos();
    }

    public void deletarEvento(Long id){
        eventoService.delete(id);
    }

}
