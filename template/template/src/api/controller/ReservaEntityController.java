package api.controller;

import api.model.QuartoEntity;
import api.model.ReservaEntity;
import api.service.ReservaService;

import java.util.List;

public class ReservaEntityController extends  BaseController<ReservaEntity> {
    private ReservaService service;

    public ReservaEntityController(ReservaService service){
        this.service = service;
    }

    @Override
    public ReservaEntity save(ReservaEntity entity){
        return service.cadastrar(entity);
    }

    @Override
    public ReservaEntity findById(int id) {
        return null;
    }
    
/*     @Override
    public ReservaEntity findById(int id) {
        return service.buscarPorId(id);
    } */

    @Override
    public List<ReservaEntity> findAll() {
        return service.listar();
    }

    @Override
    public QuartoEntity delete(int id) {

        return null;
    }

    public ReservaEntity remove(ReservaEntity entity) {
       return service.remover(entity);
    }

    public ReservaEntity findByHospede(String nome) {
        return service.buscarReserva(nome);
    }
}