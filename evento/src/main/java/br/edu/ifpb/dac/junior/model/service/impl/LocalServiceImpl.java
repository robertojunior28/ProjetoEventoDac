package br.edu.ifpb.dac.junior.model.service.impl;

import br.edu.ifpb.dac.junior.model.entity.Local;
import br.edu.ifpb.dac.junior.view.payload.LocalDto;
import br.edu.ifpb.dac.junior.model.repository.LocalRepository;
import br.edu.ifpb.dac.junior.model.service.LocalService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class LocalServiceImpl implements LocalService {
    private ModelMapper mapper;
    private LocalRepository localRepository;
    @Autowired
    public LocalServiceImpl(ModelMapper mapper, LocalRepository localRepository) {
        this.mapper = mapper;
        this.localRepository = localRepository;
    }

    @Override
    @Transactional
    public LocalDto salvar(LocalDto localDto) {
        Local localSalvo = localRepository.save(mapper.map(localDto, Local.class));
        return mapper.map(localSalvo, LocalDto.class);
    }

    @Override
    public LocalDto atualizar(LocalDto localDto) {
        Local localRecuparado = localRepository.findById(localDto.getId()).orElseThrow();
        localRecuparado.setId(localDto.getId());
        localRecuparado.setRua(localDto.getRua());
        localRecuparado.setNumero(localDto.getNumero());
        localRecuparado.setCidade(localDto.getCidade());
        localRecuparado.setUf(localDto.getUf());
        Local localAtualizado = localRepository.save(localRecuparado);
        return mapper.map(localAtualizado, LocalDto.class);
    }

    public LocalDto recuperarId(Long id){
        Local localRecuperado = localRepository.findById(id).orElseThrow();
        return mapper.map(localRecuperado, LocalDto.class);
    }

    @Override
    public List<LocalDto> recuperarTodos() {
        List<Local> locaisRecuperados = localRepository.findAll();

        List<LocalDto> locaisDto = locaisRecuperados.stream().map(
                local -> mapper.map(local, LocalDto.class)).collect(Collectors.toList());

        return locaisDto;
    }

    public void delete(Long id){
        Local localRecuperado = localRepository.findById(id).orElseThrow();
        localRepository.deleteById(id);
    }
}
