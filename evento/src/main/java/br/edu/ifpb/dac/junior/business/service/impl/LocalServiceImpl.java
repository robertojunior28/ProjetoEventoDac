package br.edu.ifpb.dac.junior.business.service.impl;

import br.edu.ifpb.dac.junior.business.service.LocalService;
import br.edu.ifpb.dac.junior.model.entity.Local;
import br.edu.ifpb.dac.junior.business.dto.LocalDto;
import br.edu.ifpb.dac.junior.model.repository.LocalRepository;
import br.edu.ifpb.dac.junior.utils.Convert;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class LocalServiceImpl implements LocalService {
    private LocalRepository localRepository;
    @Autowired
    public LocalServiceImpl(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    @Override
    @Transactional
    public LocalDto salvar(LocalDto localDto) {
        Local savedLocal = localRepository.save(Convert.dtoToLocal(localDto));
        return Convert.localToDto(savedLocal);
    }

    @Override
    public LocalDto update(long id, LocalDto localDto) {
        Local recoveredLocal = localRepository.findById(id).orElseThrow();
        recoveredLocal.setStreet(localDto.getStreet());
        recoveredLocal.setNumber(localDto.getNumber());
        recoveredLocal.setCity(localDto.getCity());
        recoveredLocal.setUf(localDto.getUf());
        Local updatingLocal = localRepository.save(recoveredLocal);
        return Convert.localToDto(updatingLocal);
    }

    public LocalDto findById(long id){
        Local recoveredLocal = localRepository.findById(id).orElseThrow();
        return Convert.localToDto(recoveredLocal);
    }

    @Override
    public List<LocalDto> findAll() {
        List<Local> recoveredLocations = localRepository.findAll();

        List<LocalDto> locationsDto = recoveredLocations.stream().map(
                local -> Convert.localToDto(local)).collect(Collectors.toList());

        return locationsDto;
    }

    public void delete(long id){
        Local recoveredLocal = localRepository.findById(id).orElseThrow();
        localRepository.deleteById(id);
    }
}
