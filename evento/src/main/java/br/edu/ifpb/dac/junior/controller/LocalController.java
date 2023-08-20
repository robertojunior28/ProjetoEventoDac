package br.edu.ifpb.dac.junior.controller;

import br.edu.ifpb.dac.junior.view.payload.LocalDto;
import br.edu.ifpb.dac.junior.model.service.impl.LocalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LocalController {
    private LocalServiceImpl localService;
    @Autowired
    public LocalController(LocalServiceImpl localService) {
        this.localService = localService;
    }

    public LocalDto criar(LocalDto localDto){
        return localService.salvar(localDto);
    }

    public LocalDto atulizar(LocalDto localDto) {
        return localService.atualizar(localDto);
    }

    public LocalDto recuperarId(Long id){
        return localService.recuperarId(id);
    }

    public List<LocalDto> recuperarTodos(){
        return localService.recuperarTodos();
    }

    public void deletarLocal(Long id){
        localService.delete(id);
    }
}
