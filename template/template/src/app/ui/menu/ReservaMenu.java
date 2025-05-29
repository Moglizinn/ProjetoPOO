 package app.ui.menu;

import api.controller.ReservaEntityController;
import api.model.ReservaEntity;
import api.model.HospedeEntity;
import api.model.QuartoEntity;
import api.service.HospedeService;
import api.service.QuartoService;
import app.ui.InputReader;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ReservaMenu {

    private  InputReader input;
    private  ReservaEntityController reservaEntityController;
    private HospedeService hospedeService;
    private QuartoService quartoService;
    private  SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

    public ReservaMenu(ReservaEntityController reservaEntityController, HospedeService hospedeService, QuartoService quartoService) {
        this.input = new InputReader();
        this.reservaEntityController = reservaEntityController;
        this.hospedeService = hospedeService;
        this.quartoService = quartoService;
    }



    public void start() {
        while (true) {
            System.out.println("\n=== GERENCIAR ITENS ===");
            System.out.println("1. Listar itens");
            System.out.println("2. Criar item");
            System.out.println("3. Buscar por reserva");
            System.out.println("4. Remover item");
            System.out.println("0. Voltar ao menu principal");

            int choice = input.readInt("Escolha uma opção");
            switch (choice) {
                case 1 -> {
                    List<ReservaEntity> entities = reservaEntityController.findAll();
                    entities.forEach(System.out::println);
                }
                case 2 -> {
                    String nome = input.readLine("Nome do hospede");
                    HospedeEntity hospede = hospedeService.buscarPorNome(nome);
                    String quartoEscolhido = input.readLine("Quarto escolhido");
                    QuartoEntity quarto = quartoService.buscarPorNome(quartoEscolhido);
                    String status = input.readLine("Status do quarto");

                    Date dataEntrada = null;
                    try {
                        dataEntrada = data.parse(input.readLine("Data de entrada (dd/MM/yyyy)"));
                    } catch (ParseException e) {
                        System.out.println("Formato de data inválido! Tente novamente.");
                    }

                    Date dataSaida = null;
                    try {
                        dataSaida = data.parse(input.readLine("Data de saída (dd/MM/yyyy)"));
                    } catch (ParseException e) {
                        System.out.println("Formato de data inválido! Tente novamente.");
                    }

//                    Date dataEntrada = data.parse(input.readLine("Data de entrada (dd/MM/yyyy)"));
//                    Date dataSaida = data.parse(input.readLine("Data de saída (dd/MM/yyyy)"));


                    quarto.setNome(quartoEscolhido);

                    ReservaEntity reserva = new ReservaEntity();
                    reserva.setHospede(hospede);
                    reserva.setQuarto(quarto);
                    reserva.setStatus(status);
                    reserva.setDataEntrada(dataEntrada);
                    reserva.setDataSaida(dataSaida);
                    reservaEntityController.save(reserva);
                    System.out.println("Reserva cadastrada");
                }
                case 3 -> {
                    String nome =  input.readLine("Digite o nome do hospede");
                    ReservaEntity entity = reservaEntityController.findByHospede(nome);
                    System.out.println(entity);
                }
                case 4 -> {
                    String nome =  input.readLine("Digite o nome do Hospede");
                    HospedeEntity hospede = hospedeService.buscarPorNome(nome);
                    ReservaEntity entity = new ReservaEntity();
                    entity.setHospede(hospede);
                    reservaEntityController.remove(entity);
                    System.out.println("Reserva removida com sucesso");
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