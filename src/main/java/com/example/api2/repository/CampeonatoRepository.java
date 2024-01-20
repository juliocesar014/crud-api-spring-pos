package com.example.api2.repository;

import com.example.api2.model.CampeonatoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CampeonatoRepository extends JpaRepository<CampeonatoModel, Integer> {

    List<CampeonatoModel> findByNomeOrderByNomeAsc(String nome);

    @Query("select a from AtletaModel a where a.nome = :nome order by a.nome asc")
    List<CampeonatoModel> buscarNomeCampeonato(@Param("nome") String nome);
}
