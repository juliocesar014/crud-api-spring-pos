package com.example.api2.service;


import com.example.api2.model.CampeonatoModel;
import com.example.api2.repository.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampeonatoService {

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    public CampeonatoModel cadastrar(CampeonatoModel campeonatoModel) {
        return campeonatoRepository.save(campeonatoModel);
    }

    public CampeonatoModel alterar(CampeonatoModel campeonatoModel) {
        return campeonatoRepository.save(campeonatoModel);
    }

    public void deletar(Integer id) {
        campeonatoRepository.deleteById(id);
    }

    public CampeonatoModel consultarPorId(Integer id) {
        return campeonatoRepository.findById(id).get();
    }

    public Iterable<CampeonatoModel> listarTodos() {
        return campeonatoRepository.findAll();
    }

    public Iterable<CampeonatoModel> listarPorNome(String nome) {
        return campeonatoRepository.findByNomeOrderByNomeAsc(nome);
    }
}
