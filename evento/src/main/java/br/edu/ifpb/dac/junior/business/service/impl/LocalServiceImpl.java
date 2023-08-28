package br.edu.ifpb.dac.junior.business.service.impl;

import br.edu.ifpb.dac.junior.business.service.LocalService;
import br.edu.ifpb.dac.junior.model.entity.Local;
import br.edu.ifpb.dac.junior.business.dto.LocalDto;
import br.edu.ifpb.dac.junior.model.repository.LocalRepository;
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
        Local savedLocal = localRepository.save(mapper.map(localDto, Local.class));
        return mapper.map(savedLocal, LocalDto.class);
    }

    @Override
    public LocalDto update(long id, LocalDto localDto) {
        Local recoveredLocal = localRepository.findById(id).orElseThrow();
        recoveredLocal.setStreet(localDto.getStreet());
        recoveredLocal.setNumber(localDto.getNumber());
        recoveredLocal.setCity(localDto.getCity());
        recoveredLocal.setUf(localDto.getUf());
        Local updatingLocal = localRepository.save(recoveredLocal);
        return mapper.map(updatingLocal, LocalDto.class);
    }

    public LocalDto findById(long id){
        Local recoveredLocal = localRepository.findById(id).orElseThrow();
        return mapper.map(recoveredLocal, LocalDto.class);
    }

    @Override
    public List<LocalDto> findAll() {
        List<Local> recoveredLocations = localRepository.findAll();

        List<LocalDto> locationsDto = recoveredLocations.stream().map(
                local -> mapper.map(local, LocalDto.class)).collect(Collectors.toList());

        return locationsDto;
    }

    public void delete(long id){
        Local recoveredLocal = localRepository.findById(id).orElseThrow();
        localRepository.deleteById(id);
    }
}
