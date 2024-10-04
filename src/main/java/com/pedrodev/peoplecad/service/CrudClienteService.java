package com.pedrodev.peoplecad.service;


import com.pedrodev.peoplecad.orm.Cliente;
import com.pedrodev.peoplecad.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudClienteService {
    private ClienteRepository clienteRepository;

    public CrudClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void menu(Scanner scanner) {
        Boolean isTrue = true;

        while (isTrue) {
            System.out.println("Escolha um opção abaixo:");
            System.out.println("- 1 - Cadastrar novo cliente.");
            System.out.println("- 2 - Remover cliente");
            System.out.println("- 3 - Visulizar clientes");
            System.out.println("- 4 - Atualizar cliente");
            System.out.println("- 5 - Visualizar um cliente");
            System.out.println("- 0 - Sair");

            Integer opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    this.cadastrar(scanner);
                    break;
                case 2:
                    this.remove(scanner);
                    break;
                case 3:
                    this.visualizar();
                    break;
                case 4:
                    this.atualizar(scanner);
                    break;
                case 5:
                    this.viewClient(scanner);
                default:
                    isTrue = false;
                    break;
            }
        }
    }

    private void cadastrar(Scanner scanner) {
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();

        System.out.println("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.println("CPF: ");
        String cpf = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        System.out.println("Endereço: ");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setEndereco(endereco);

        this.clienteRepository.save(cliente);

        System.out.println("Cadastro efetuado com sucesso!");

    }
    public void remove(Scanner scanner){
        System.out.println("Digite o id do cliente que deseja remover");
        Long idCliente = scanner.nextLong();
        Optional<Cliente> optionalCliente = this.clienteRepository.findById(idCliente);
        if (optionalCliente.isPresent()){

            this.clienteRepository.deleteById(idCliente);
            System.out.println("Deletado com sucesso!");
        } else {
            System.out.println("O id informado é iválido!");
        }
    }
    public void visualizar(){
        Iterable<Cliente> clientes = this.clienteRepository.findAll();
        for (Cliente cliente : clientes){
            System.out.println(cliente);
        }
    }
    public void atualizar(Scanner scanner){
        System.out.println("Digite o id do cliente que deseja atualizar: ");
        Long idCliente = scanner.nextLong();
        scanner.nextLine();

        Optional<Cliente> optionalCliente = this.clienteRepository.findById(idCliente);
        if (optionalCliente.isPresent()){
            Cliente clientes = optionalCliente.get();

            System.out.println("Nome (atual : " + clientes.getNome()+ "): ");
            String nome = scanner.nextLine();
            if (!nome.isEmpty()){
                clientes.setNome(nome);
            }

            System.out.println("Telefone (atual : " + clientes.getTelefone() + "): ");
            String telefone = scanner.nextLine();
            if (!telefone.isEmpty()){
                clientes.setTelefone(telefone);
            }

            System.out.println("CPF (atual : " + clientes.getCpf() + "): ");
            String cpf = scanner.nextLine();
            if (!cpf.isEmpty()){
                clientes.setCpf(cpf);
            }

            System.out.println("Email (atual : " + clientes.getEmail() + "): ");
            String email = scanner.nextLine();
            if (!email.isEmpty()){
                clientes.setEmail(email);
            }

            System.out.println("Endereço (atual : " + clientes.getEmail() + "): ");
            String endereco = scanner.nextLine();
            if (!endereco.isEmpty()){
                clientes.setEndereco(endereco);
            }

            this.clienteRepository.save(clientes);

            System.out.println("Atualizado com sucesso!");
        } else {
            System.out.println("O id informado é inválido!");
        }
    }
    public void viewClient(Scanner scanner){
        System.out.println("Digite o id do cliente: ");
        Long idCliente = scanner.nextLong();

        Optional<Cliente> optionalCliente = this.clienteRepository.findById(idCliente);
        if (optionalCliente.isPresent()){
            Cliente clientes = optionalCliente.get();
            System.out.println("{");
            System.out.println("Id: " + clientes.getId());
            System.out.println("Nome: " + clientes.getNome());
            System.out.println("Telefone: " + clientes.getTelefone());
            System.out.println("CPF: " + clientes.getCpf());
            System.out.println("Email: " + clientes.getEmail());
            System.out.println("Endereço: " + clientes.getEndereco());
            System.out.println("     }");
            System.out.println(" ");
        }
    }
}
