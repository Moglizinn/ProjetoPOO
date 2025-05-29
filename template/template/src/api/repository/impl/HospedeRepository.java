package api.repository.impl;
import api.model.HospedeEntity;
import api.model.QuartoEntity;
import api.model.ReservaEntity;
import api.service.HospedeService;

import java.util.ArrayList;
import java.util.List;

public class HospedeRepository {
     List<HospedeEntity> hospedes = new ArrayList<>();

     public HospedeEntity cadastrar(HospedeEntity hospede){
         hospede.setId(hospedes.size()+1);
         hospedes.add(hospede);
         return hospede;
     }

     public List<HospedeEntity> listar(){
         return  hospedes;
     }

    public HospedeEntity buscarHospede(String nome){
        for(HospedeEntity hospede : hospedes){
             if(hospede.getNome().equals(nome)){
                 return hospede;
             }
         }
        return  null;
    }
    public HospedeEntity findById(int id){
        for(HospedeEntity hospede : hospedes){
            if(hospede.getId() == id){
                return hospede;
            }
        }
        return  null;
    }
    public HospedeEntity remover(HospedeEntity hospede){
        hospede.setId(hospedes.size()+1);
        hospedes.remove(hospede);
        return hospede;
    }

    public HospedeEntity buscarPorNome(String nome) {
        for(HospedeEntity hospede : hospedes){
            return hospede;
        }
        return  null;
    }
}