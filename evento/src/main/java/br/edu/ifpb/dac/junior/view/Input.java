package br.edu.ifpb.dac.junior.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class Input {
    private Scanner scanner;
    @Autowired
    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String ler(){
        return scanner.nextLine();
    }
}
