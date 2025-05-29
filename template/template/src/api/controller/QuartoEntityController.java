package api.controller;

import api.model.HospedeEntity;
import api.model.QuartoEntity;
import api.service.QuartoService;

import java.util.List;

public class QuartoEntityController extends  BaseController<QuartoEntity> {
    private QuartoService service;

    public QuartoEntityController(QuartoService service){
        this.service = service;
    }

    @Override
    public QuartoEntity save(QuartoEntity entity){
        service.cadastrar(entity);
        return entity;
    }
    public QuartoEntity findByQuarto(String nome) {
        return service.buscarPorNome(nome);
    }

    public QuartoEntity remove(QuartoEntity entity) {
        return service.remove(entity);
    }
    @Override
    public QuartoEntity findById(int id) {
        return service.buscarQuarto(id);
    }

    @Override
    public List<QuartoEntity> findAll() {
        return service.listarTodos();
    }

    @Override
    public QuartoEntity delete(int id) {
        return service.remover(id);
    }
}