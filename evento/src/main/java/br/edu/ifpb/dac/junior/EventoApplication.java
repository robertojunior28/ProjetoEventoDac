package br.edu.ifpb.dac.junior;

import br.edu.ifpb.dac.junior.controller.EventoController;
import br.edu.ifpb.dac.junior.controller.LocalController;
import br.edu.ifpb.dac.junior.view.Cadastrar;
import br.edu.ifpb.dac.junior.view.Input;
import br.edu.ifpb.dac.junior.view.Listar;
import br.edu.ifpb.dac.junior.view.payload.EventoDto;
import br.edu.ifpb.dac.junior.view.payload.LocalDto;
import br.edu.ifpb.dac.junior.view.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class EventoApplication implements CommandLineRunner {
	private EventoController eventoController;
	private LocalController localController;
	private Input input;
	private Cadastrar cadastrar;
	private Print print;
	private Listar listar;
	@Autowired
	public EventoApplication(EventoController eventoController, LocalController localController, Input input, Cadastrar cadastrar, Print print, Listar listar) {
		this.eventoController = eventoController;
		this.localController = localController;
		this.input = input;
		this.cadastrar = cadastrar;
		this.print = print;
		this.listar = listar;
	}

	public static void main(String[] args) {
		SpringApplication.run(EventoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var acabou = false;
		while (acabou == false){
			print.escrever("----DIGITE O QUE DESEJA :-) ---- \n " +
					"1-CADASTRAR EVENTO E LOCAL\n " +
					"2-CADASTRAR LOCAL\n "+
					"3-CADASTRAR EVENTO\n "+
					"4-LISTAR EVENTOS E LOCAIS\n " +
					"5-SAIR DO PROGRAMA \n ");
			try {
				int entrada = Integer.parseInt(input.ler());
				if(entrada == 1){
					EventoDto evento = cadastrar.criarEvento();
					LocalDto local = cadastrar.criarLocal();
					LocalDto localsalvo = localController.criar(local);
					evento.setLocal(localController.recuperarId(localsalvo.getId()));
					eventoController.criar(evento);
				}else if (entrada == 2) {
					LocalDto local = cadastrar.criarLocal();
					localController.criar(local);
				}else if (entrada == 3) {
					EventoDto evento = cadastrar.criarEvento();
					eventoController.criar(evento);
				}else if (entrada == 4) {
					listar.eventos(eventoController.recuperarTodos());
					listar.locasis(localController.recuperarTodos());
				}else {
					acabou = true;
				}
			}catch (Exception e){
				print.escrever("Entrada invalida");
				continue;
			}
		}
	}
}
