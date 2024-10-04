package com.pedrodev.peoplecad;

import com.pedrodev.peoplecad.service.CrudClienteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PeoplecadApplication implements CommandLineRunner {
	private CrudClienteService crudClienteService;

	public PeoplecadApplication(CrudClienteService crudClienteService){
		this.crudClienteService = crudClienteService;
	}

	public static void main(String[] args) {
		SpringApplication.run(PeoplecadApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Boolean isTrue = true;
		Scanner scanner = new Scanner(System.in);

		while (isTrue){
			System.out.println("Qual opção deseja acessar ?");
			System.out.println("- 1 - Acessar clientes.");
			System.out.println("- 0 - SAIR.");

			Integer opcao = scanner.nextInt();
			switch (opcao){
				case 1:
					this.crudClienteService.menu(scanner);
					break;
				default:
					isTrue = false;
					break;
			}
		}
	}
}
