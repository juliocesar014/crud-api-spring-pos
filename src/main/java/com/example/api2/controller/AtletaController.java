package com.example.api2.controller;

import com.example.api2.model.AtletaModel;
import com.example.api2.service.AtletaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atleta")
@Tag(name="2. Atleta Controller")
public class AtletaController {

    @Autowired
    private AtletaService service;


    @PostMapping
    public ResponseEntity<AtletaModel> cadastrar(@RequestBody AtletaModel atletaModel){
        atletaModel = service.cadastrar(atletaModel);
        return ResponseEntity.ok(atletaModel);
    }


    @PutMapping
    public ResponseEntity<AtletaModel> alterar(@RequestBody AtletaModel atletaModel){
        atletaModel = service.alterar(atletaModel);
        return ResponseEntity.ok(atletaModel);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        service.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<AtletaModel> consultarPorId(@PathVariable Integer id){
        AtletaModel atletaModel = service.consultarPorId(id);
        return ResponseEntity.ok(atletaModel);
    }


    @GetMapping
    public ResponseEntity<List<AtletaModel>> listarTodos() {
        List<AtletaModel> atletaModel = service.listarTodos();
        return ResponseEntity.ok(atletaModel);
    }

    @GetMapping("{nome}")
    public ResponseEntity<List<AtletaModel>> listarPorNome(@PathVariable String nome) {
        List<AtletaModel> atletaModel = service.listarPorNome(nome);
        return ResponseEntity.ok(atletaModel);
    }


}
