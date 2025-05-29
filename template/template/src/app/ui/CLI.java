package app.ui;

import app.ui.menu.ReservaMenu;
import app.ui.menu.QuartoMenu;
import app.ui.menu.HospedeMenu;

public class CLI {

    private final InputReader inputReader;
    private final ReservaMenu reservaMenu;
    private final QuartoMenu quartoMenu;
    private final HospedeMenu hospedeMenu;

    public CLI(InputReader inputReader, ReservaMenu reservaMenu, QuartoMenu quartoMenu, HospedeMenu hospedeMenu) {
        this.inputReader = inputReader;
        this.quartoMenu = quartoMenu;
        this.reservaMenu = reservaMenu;
        this.hospedeMenu = hospedeMenu;
    }

    public void start() {
        while (true) {
            System.out.println("\n=== SISTEMA CLI ===");
            System.out.println("1. Gerenciar Quarto");
            System.out.println("2. Gerenciar Hospedes");
            System.out.println("3. Gerenciar Reservas");
            System.out.println("4. Sair");

            int opcao = inputReader.readInt("Escolha uma opção");

            switch (opcao) {
                case 1 -> quartoMenu.start();
                case 2 -> hospedeMenu.start();
                case 3 -> reservaMenu.start();
                case 4 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
