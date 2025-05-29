import api.controller.QuartoEntityController;
import api.repository.impl.QuartoRepository;
import api.service.QuartoService;

import api.controller.HospedeEntityController;
import api.repository.impl.HospedeRepository;
import api.service.HospedeService;

import api.controller.ReservaEntityController;
import api.repository.impl.ReservaRepository;
import api.service.ReservaService;
import app.ui.CLI;
import app.ui.InputReader;
import app.ui.menu.HospedeMenu;
import app.ui.menu.QuartoMenu;
import app.ui.menu.ReservaMenu;

public class Main {
    public static void main(String[] args) {
        // Backend entity
        QuartoRepository quartoRepository = new QuartoRepository();
        QuartoService quartoService = new QuartoService(quartoRepository);
        QuartoEntityController quartoEntityController = new QuartoEntityController(quartoService);

        HospedeRepository hospedeRepository = new HospedeRepository();
        HospedeService hospedeService = new HospedeService(hospedeRepository);
        HospedeEntityController hospedeEntityController = new HospedeEntityController(hospedeService);

        ReservaRepository reservaRepository = new ReservaRepository();
        ReservaService reservaService = new ReservaService(reservaRepository);
        ReservaEntityController reservaEntityController = new ReservaEntityController(reservaService);

        // Frontend entity
        QuartoMenu quartoMenu = new QuartoMenu(quartoEntityController);
        HospedeMenu hospedeMenu = new HospedeMenu(hospedeEntityController);
        ReservaMenu reservaMenu = new ReservaMenu(reservaEntityController, hospedeService, quartoService);

        // Initialize the CLI
        InputReader inputReader = new InputReader();
        CLI cli = new CLI(inputReader, reservaMenu, quartoMenu, hospedeMenu);
        cli.start();
    }
}