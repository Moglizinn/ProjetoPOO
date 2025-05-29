package api.service;

import api.model.HospedeEntity;
import api.model.QuartoEntity;
import api.repository.impl.QuartoRepository;
import java.util.List;


public class QuartoService {

    private QuartoRepository repository;

    public QuartoService(QuartoRepository repository){
        this.repository = repository;
    }

    public List<QuartoEntity> listarTodos() {
        return repository.buscarTodos();
    }

    public QuartoEntity cadastrar(QuartoEntity quarto) {
        repository.salvar(quarto);
        return quarto;
    }

    public QuartoEntity buscarQuarto(int id){
        return repository.buscarPorId(id);
    }

    public QuartoEntity buscarPorNome(String nome){

        return repository.buscarPorNome(nome);
    }
    public QuartoEntity remover(int id){
        repository.deletar(id);
        return null;
    }
    public QuartoEntity remove(QuartoEntity hospede){
        return repository.remover(hospede);
    }
}