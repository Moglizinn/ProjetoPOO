 package app.ui.menu;

import api.controller.HospedeEntityController;
import api.model.HospedeEntity;
import app.ui.InputReader;

import java.util.List;

public class HospedeMenu {

    private final InputReader input;

    private final HospedeEntityController controller;

    public HospedeMenu(HospedeEntityController controller) {
        this.input = new InputReader();
        this.controller = controller;
    }
     
        public void start() {
 
           System.out.println("\n=== GERENCIAR ITENS ===");
            System.out.println("1. Listar itens");
            System.out.println("2. Criar item");
            System.out.println("3. Buscar por hospede");
            System.out.println("4. Remover item");
            System.out.println("0. Voltar ao menu principal");

            int choice = input.readInt("Escolha uma opção");
            switch (choice) {
                case 1 -> {
                    List<HospedeEntity> entities = controller.findAll();
                    entities.forEach(System.out::println);
                }
                case 2 -> {
                    String nome = input.readLine("Nome do hospede");
                    String telefone = input.readLine("telefone do hospede");

                    HospedeEntity exampleEntity = new HospedeEntity();
                    exampleEntity.setNome(nome);
                    exampleEntity.setTelefone(telefone);
                    controller.save(exampleEntity);
                    System.out.println("Hospede cadastrado!");
                }
                case 3 -> {
                    String nome =  input.readLine("Digite o nome do hospede");
                    HospedeEntity entity = controller.findByHospede(nome);
                    System.out.println(entity);
                }
                case 4 -> {
                    String nome =  input.readLine("Digite o nome do Hospede");
                    HospedeEntity entity =  controller.findByHospede(nome);
                    if(entity != null){
                        controller.remove(entity);
                        System.out.println("Hospede removido com sucesso");
                    }
                }
                case 0 -> {
                    System.out.println("Voltando ao menu principal...");
                    return;
                }
                default -> {
                    System.out.println("Opção inválida.");
                }
            }
        }
    }