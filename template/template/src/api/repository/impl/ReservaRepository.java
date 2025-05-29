package api.repository.impl;

import api.model.ReservaEntity;

import api.service.ReservaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservaRepository{

    private List<ReservaEntity> reservas = new ArrayList<>();

     public ReservaEntity cadastrar(ReservaEntity reserva){
         reserva.setId(reservas.size()+1);
         reservas.add(reserva);
         return reserva;
     }

     public List<ReservaEntity> listar(){
         return  reservas;
     }

    public ReservaEntity buscarReserva(String nome){
         for(ReservaEntity reserva : reservas){
             if(reserva.getHospede().getNome().equals(nome)){
                 return reserva;
             }
         }
        return  null;
    }

    public ReservaEntity buscarPorId(int id){
         for(ReservaEntity reserva : reservas){
             if(reserva.getId() == id){
                 return reserva;
             }
         }
        return  null;
    }
    public ReservaEntity remover(ReservaEntity reserva){
        reserva.setId(reservas.size()+1);
        reservas.remove(reserva);
        return reserva;
    }
    public ReservaEntity removePorId(int id){
        ReservaEntity reserva = buscarPorId(id);
        if(reserva != null){
            reservas.remove(reserva);
            return reserva;
        }
        return  null;
    }
}