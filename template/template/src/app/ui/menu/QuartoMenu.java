package app.ui.menu;

import api.controller.QuartoEntityController;
import api.model.HospedeEntity;
import api.model.QuartoEntity;
import app.ui.InputReader;

import java.util.List;

public class QuartoMenu {

    private final InputReader input;

    private final QuartoEntityController controller;

    public QuartoMenu(QuartoEntityController controller) {
        this.input = new InputReader();
        this.controller = controller;
    }

    public void start() {
        while (true) {
            System.out.println("\n=== GERENCIAR ITENS ===");
            System.out.println("1. Listar itens");
            System.out.println("2. Criar item");
            System.out.println("3. Buscar por quarto");
            System.out.println("4. Remover item");
            System.out.println("0. Voltar ao menu principal");

            int choice = input.readInt("Escolha uma opção");
            switch (choice) {
                case 1 -> {
                    List<QuartoEntity> entities = controller.findAll();
                    entities.forEach(System.out::println);
                }
                case 2 -> {
                    String nome = input.readLine("Nome do quarto");
                    String descricao = input.readLine("Descricao do quarto");
                    double preco = input.readDouble("Preco do quarto");
                    QuartoEntity quarto = new QuartoEntity();
                    quarto.setNome(nome);
                    quarto.setDescricao(descricao);
                    quarto.setPreco(preco);
                    controller.save(quarto);
                    System.out.println("Quarto cadastrado!");
                }
                case 3 -> {
                    String nome =  input.readLine("Digite o nome do quarto");
                    QuartoEntity entity = controller.findByQuarto(nome);
                    System.out.println(entity);
                }
                case 4 -> {
                    String nome =  input.readLine("Digite o nome do Quarto");
                    QuartoEntity entity =  controller.findByQuarto(nome);
                    if(entity != null){
                        controller.remove(entity);
                        System.out.println("Quarto removido com sucesso");
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

}
