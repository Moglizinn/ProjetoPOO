package api.service;

import api.model.ReservaEntity;
import api.repository.impl.ReservaRepository;

import java.util.List;

public class ReservaService {
    private ReservaRepository repository;

    public ReservaService(ReservaRepository entityRepository) {
        this.repository = entityRepository;
    }

    public ReservaEntity cadastrar(ReservaEntity reserva){
        if(reserva.getHospede() == null){
            System.out.println("Reserva inválida");
            return null;
        }
        return repository.cadastrar(reserva);
    }

    public List<ReservaEntity> listar(){
        return repository.listar();
    }
    
    public ReservaEntity buscarReserva(String nome){
        return repository.buscarReserva(nome);
    }

    public ReservaEntity remover(ReservaEntity reserva){
        if(reserva.getHospede() == null){
            System.out.println("Reserva inválida");
            return null;
        }
        return repository.remover(reserva);
    }
}