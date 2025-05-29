package api.repository.impl;

import api.model.HospedeEntity;
import api.model.QuartoEntity;
import api.model.ReservaEntity;
import api.service.QuartoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuartoRepository{

    private List<QuartoEntity> quartos = new ArrayList<>();

    public void salvar(QuartoEntity quarto) {
        quartos.add(quarto);
    }


    public QuartoEntity buscarPorId(int id) {
        Optional<QuartoEntity> quarto = quartos.stream()
                .filter(q -> q.getId() == id)
                .findFirst();
        return quarto.orElse(null);
    }

    public List<QuartoEntity> buscarTodos() {
        return new ArrayList<>(quartos);
    }

    public QuartoEntity buscarPorNome(String nome){
        for(QuartoEntity quarto : quartos){
                return quarto;
            }
        return  null;
    }
    public void atualizar(QuartoEntity quartoAtualizado) {
        for (int i = 0; i < quartos.size(); i++) {
            if (quartos.get(i).getId() == quartoAtualizado.getId()) {
                quartos.set(i, quartoAtualizado);
                return;
            }
        }
    }
    public void deletar(int id) {
        quartos.removeIf(q -> q.getId() == id);
    }

    public QuartoEntity remover(QuartoEntity quarto) {
            quarto.setId(quartos.size()+1);
            quartos.remove(quarto);
            return quarto;
    }
}