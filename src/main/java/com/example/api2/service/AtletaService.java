package com.example.api2.service;

import com.example.api2.model.AtletaModel;
import com.example.api2.repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AtletaService {
    @Autowired
    private AtletaRepository repository;

    public AtletaModel cadastrar(AtletaModel atletaModel) {
        return repository.save(atletaModel);
    }



    public List<AtletaModel> listarPorNome(String nome) {
        if (Objects.isNull(nome)) {
            throw new RuntimeException("Não foi possível realizar a pesquisa");
        }
        return repository.findByNomeOrderByNomeAsc(nome);
    }

    public AtletaModel alterar(AtletaModel atletaModel) {
        if (Objects.isNull(atletaModel.getId())) {
            throw new RuntimeException("Não foi possível alterar o registro");
        }
        return repository.save(atletaModel);
    }

    public void deletar(Integer id) {
        if (Objects.isNull(id)) {
            throw new RuntimeException("Não foi possível deletar o registro");
        }
        repository.deleteById(id);
    }

    public AtletaModel consultarPorId(Integer id) {
        if (Objects.isNull(id)) {
            throw new RuntimeException("Não foi possível deletar o registro");
        }
        return repository.findById(id).get();
    }


    public List<AtletaModel> listarTodos() {
        return repository.findAll();
    }
}
