package br.edu.ifpb.dac.junior.view.payload;

import br.edu.ifpb.dac.junior.model.entity.Evento;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocalDto {
    private Long id;
    private String rua;
    private String numero;
    private String cidade;
    private String uf;

    public LocalDto(String rua, String numero, String cidade, String uf) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Local{" +
                " id= " + id +
                ", rua= '" + rua + '\'' +
                ", numero= " + numero +
                ", cidade= '" + cidade + '\'' +
                ", uf= '" + uf + '\'' +
                '}';
    }
}
