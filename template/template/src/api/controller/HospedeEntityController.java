package api.controller;

import api.model.HospedeEntity;
import api.model.QuartoEntity;
import api.service.HospedeService;

import java.util.List;

public class HospedeEntityController extends  BaseController<HospedeEntity> {
    private HospedeService service;

    public HospedeEntityController(HospedeService service){
        this.service = service;
    }

    @Override
    public HospedeEntity save(HospedeEntity entity){
        return service.cadastrar(entity);
    }
    
    @Override
    public HospedeEntity findById(int id) {
        return service.buscarPorId(id);
    }

    public HospedeEntity findByHospede(String nome) {
        return service.buscarHospede(nome);
    }

    @Override
    public List<HospedeEntity> findAll() {
        return service.listarTodos();
    }

    @Override
    public QuartoEntity delete(int id) {

        return null;
    }

    public HospedeEntity remove(HospedeEntity entity) {
       return service.remover(entity);
    }
}