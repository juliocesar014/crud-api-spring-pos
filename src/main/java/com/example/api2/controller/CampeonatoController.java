package com.example.api2.controller;


import com.example.api2.model.CampeonatoModel;
import com.example.api2.service.CampeonatoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campeonato")
@Tag(name="3. Campeonato Controller")
public class CampeonatoController {

    @Autowired
    private CampeonatoService service;

    @PostMapping
    public ResponseEntity<CampeonatoModel> cadastrar(@RequestBody CampeonatoModel campeonatoModel){
        campeonatoModel = service.cadastrar(campeonatoModel);
        return ResponseEntity.ok(campeonatoModel);
    }

    @PutMapping
    public ResponseEntity<CampeonatoModel> alterar(@RequestBody CampeonatoModel campeonatoModel){
        campeonatoModel = service.alterar(campeonatoModel);
        return ResponseEntity.ok(campeonatoModel);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        service.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<CampeonatoModel> consultarPorId(@PathVariable Integer id){
        CampeonatoModel campeonatoModel = service.consultarPorId(id);
        return ResponseEntity.ok(campeonatoModel);
    }

    @GetMapping
    public ResponseEntity<Iterable<CampeonatoModel>> listarTodos() {
        Iterable<CampeonatoModel> campeonatoModel = service.listarTodos();
        return ResponseEntity.ok(campeonatoModel);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Iterable<CampeonatoModel>> listarPorNome(@PathVariable String nome) {
        Iterable<CampeonatoModel> campeonatoModel = service.listarPorNome(nome);
        return ResponseEntity.ok(campeonatoModel);
    }

}
