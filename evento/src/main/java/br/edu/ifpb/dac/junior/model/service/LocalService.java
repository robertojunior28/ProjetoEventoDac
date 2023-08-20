package br.edu.ifpb.dac.junior.model.service;

import br.edu.ifpb.dac.junior.view.payload.LocalDto;

import java.util.List;
public interface LocalService {
    LocalDto salvar(LocalDto localDto);
    LocalDto atualizar(LocalDto localDto);
    LocalDto recuperarId(Long id);
    List<LocalDto> recuperarTodos();
    void delete(Long id);
}
