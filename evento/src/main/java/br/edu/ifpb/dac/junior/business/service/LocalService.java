package br.edu.ifpb.dac.junior.business.service;

import br.edu.ifpb.dac.junior.business.dto.LocalDto;

import java.util.List;
public interface LocalService {
    LocalDto salvar(LocalDto localDto);
    LocalDto update(long id, LocalDto localDto);
    LocalDto findById(long id);
    List<LocalDto> findAll();
    void delete(long id);
}
