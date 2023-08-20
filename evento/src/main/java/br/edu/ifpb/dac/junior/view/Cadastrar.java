package br.edu.ifpb.dac.junior.view;

import br.edu.ifpb.dac.junior.view.payload.EventoDto;
import br.edu.ifpb.dac.junior.view.payload.LocalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Cadastrar {
    private Print print;
    private Input input;
    @Autowired
    public Cadastrar(Print print, Input input) {
        this.print = print;
        this.input = input;
    }
    public EventoDto criarEvento(){
        print.escrever("Digite o titulo do seu evento:");
        String titulo = input.ler();
        print.escrever("Digite a descrição do seu evento: ");
        String descricao = input.ler();
        print.escrever("Digite a data do seu evento: ");
        String data = input.ler();
        print.escrever("Digite a hora do seu evento: ");
        String hora = input.ler();
        return  new EventoDto(titulo, descricao, data, hora);
    }
    public LocalDto criarLocal(){
        print.escrever("Digite o nome da rua onde o evento ocorrerá: ");
        String rua = input.ler();
        print.escrever("Digite o numero do endereço: ");
        String numero = input.ler();
        print.escrever("Digite a cidade: ");
        String cidade = input.ler();
        print.escrever("Digite a UF do estado: ");
        String uf = input.ler();
        return new LocalDto(rua, numero, cidade, uf);
    }
}
