package com.example.api2.repository;

import com.example.api2.model.AtletaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AtletaRepository extends JpaRepository<AtletaModel, Integer> {

    List<AtletaModel> findByNomeOrderByNomeAsc(String nome);

    @Query("select a from AtletaModel a where a.nome = :nome order by a.nome asc")
    List<AtletaModel> buscarNomeAtleta(@Param("nome") String nome);



}
