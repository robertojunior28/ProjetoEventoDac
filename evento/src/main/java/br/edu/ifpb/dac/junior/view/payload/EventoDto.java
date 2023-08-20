package br.edu.ifpb.dac.junior.view.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventoDto {
    private Long id;
    private String titulo;
    private String descricao;
    private String data;
    private String hora;

    private LocalDto local;

    public EventoDto(String titulo, String descricao, String data, String hora) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Evento{" +
                " id= " + id +
                ", titulo= '" + titulo + '\'' +
                ", descricao= '" + descricao + '\'' +
                ", data= '" + data + '\'' +
                ", hora= '" + hora + '\'' +
                ", local= " + local +
                '}';
    }
}
