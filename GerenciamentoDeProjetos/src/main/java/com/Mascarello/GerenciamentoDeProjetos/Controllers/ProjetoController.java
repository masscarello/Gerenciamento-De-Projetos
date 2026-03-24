package com.Mascarello.GerenciamentoDeProjetos.Controllers;

import com.Mascarello.GerenciamentoDeProjetos.Models.ProjetoModel;
import com.Mascarello.GerenciamentoDeProjetos.Services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<ProjetoModel> criarprojeto(@RequestBody ProjetoModel projetoModel) {
        ProjetoModel requeste = projetoService.criarProjeto(projetoModel);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(projetoModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);

    }

    @DeleteMapping
    public ResponseEntity<?> excluirProjeto(@PathVariable Long id){
        projetoService.excluirProjeto(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProjetoModel>> listarProjetos(){
        List<ProjetoModel> requeste = projetoService.listarProjetos();
        return ResponseEntity.ok().body(requeste);
    }

    @PutMapping
    public ResponseEntity<ProjetoModel> atualizarProjeto(@PathVariable Long id, @RequestBody ProjetoModel projetoModel){
        ProjetoModel requeste = projetoService.atualizarProjeto(id, projetoModel);
        return ResponseEntity.ok().body(requeste);

    }

}
