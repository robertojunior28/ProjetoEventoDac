package br.edu.ifpb.dac.junior.model.service.impl;

import br.edu.ifpb.dac.junior.model.entity.Evento;
import br.edu.ifpb.dac.junior.model.entity.Local;
import br.edu.ifpb.dac.junior.view.payload.EventoDto;
import br.edu.ifpb.dac.junior.model.repository.EventoRepository;
import br.edu.ifpb.dac.junior.model.service.EventoService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EventoServiceImpl implements EventoService {
    private ModelMapper mapper;
    private EventoRepository eventoRepository;
    @Autowired
    public EventoServiceImpl(ModelMapper mapper, EventoRepository eventoRepository) {
        this.mapper = mapper;
        this.eventoRepository = eventoRepository;
    }

    @Override
    @Transactional
    public EventoDto salvar(EventoDto eventoDto) {
        Evento eventoSalvo = eventoRepository.save(mapper.map(eventoDto, Evento.class));
        return mapper.map(eventoSalvo, EventoDto.class);
    }

    @Override
    public EventoDto atualizar(EventoDto eventoDto) {
        Evento eventoRecuparado = eventoRepository.findById(eventoDto.getId()).orElseThrow();
        eventoRecuparado.setId(eventoDto.getId());
        eventoRecuparado.setTitulo(eventoDto.getDescricao());
        eventoRecuparado.setData(eventoDto.getData());
        eventoRecuparado.setHora(eventoDto.getHora());
        eventoRecuparado.setLocal(mapper.map(eventoDto.getLocal(), Local.class));
        Evento eventoAtualizado = eventoRepository.save(eventoRecuparado);
        return mapper.map(eventoAtualizado, EventoDto.class);
    }

    public EventoDto recuperarId(Long id){
        Evento eventoRecuperado = eventoRepository.findById(id).orElseThrow();
        return mapper.map(eventoRecuperado, EventoDto.class);
    }

    @Override
    public List<EventoDto> recuperarTodos() {
        List<Evento> eventosRecuperados = eventoRepository.findAll();

        List<EventoDto> eventosDto = eventosRecuperados.stream().map(
                evento -> mapper.map(evento, EventoDto.class)).collect(Collectors.toList());

        return eventosDto;
    }

    public void delete(Long id){
        Evento eventoRecuperado = eventoRepository.findById(id).orElseThrow();
        eventoRepository.deleteById(id);
    }
}
