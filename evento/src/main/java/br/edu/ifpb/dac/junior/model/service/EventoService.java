package br.edu.ifpb.dac.junior.model.service;

import br.edu.ifpb.dac.junior.view.payload.EventoDto;

import java.util.List;
public interface EventoService {
    EventoDto salvar(EventoDto eventoDto);
    EventoDto atualizar(EventoDto eventoDto);
    EventoDto recuperarId(Long id);
    List<EventoDto> recuperarTodos();
    void delete(Long id);
}
