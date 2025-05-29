package api.service;

import api.model.HospedeEntity;
import api.model.QuartoEntity;
import api.repository.impl.HospedeRepository;
import java.util.List;


public class HospedeService {

    private HospedeRepository repository;

    public HospedeService(HospedeRepository repository){
        this.repository = repository;
    }
    
    public List<HospedeEntity> listarTodos() {
        return repository.listar();
    }

    public HospedeEntity buscarPorNome(String nome){

        return repository.buscarPorNome(nome);
    }

    public HospedeEntity cadastrar(HospedeEntity hospede) {
        return repository.cadastrar(hospede);
    }

    public HospedeEntity buscarPorId(int id) {
        return repository.findById(id);
    }
    public HospedeEntity buscarHospede(String nome){
        return repository.buscarHospede(nome);
    }

    public HospedeEntity remover(HospedeEntity hospede){
        return repository.remover(hospede);
    }

}