package br.edu.ifpb.dac.junior.view;

import br.edu.ifpb.dac.junior.model.entity.Local;
import br.edu.ifpb.dac.junior.view.payload.EventoDto;
import br.edu.ifpb.dac.junior.view.payload.LocalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Listar {
    private Print print;
    @Autowired
    public Listar(Print print) {
        this.print = print;
    }

    public void eventos(List<EventoDto> eventos){
        for (EventoDto e: eventos) {
            print.escrever(e.toString());
        }
    }
    public void locasis(List<LocalDto> locais){
        for (LocalDto l: locais) {
            print.escrever(l.toString());
        }
    }
}
