package br.edu.ifpb.dac.junior.view;

import org.springframework.stereotype.Component;

@Component
public class Print {
    public void escrever(String mensagem){
        System.out.println(mensagem);
    }
}
