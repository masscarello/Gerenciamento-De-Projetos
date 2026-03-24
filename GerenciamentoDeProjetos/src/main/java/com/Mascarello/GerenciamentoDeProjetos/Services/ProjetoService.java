package com.Mascarello.GerenciamentoDeProjetos.Services;

import com.Mascarello.GerenciamentoDeProjetos.Models.ProjetoModel;
import com.Mascarello.GerenciamentoDeProjetos.Repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProjetoService {
    @Autowired
    ProjetoRepository projetoRepository;

    public void excluirProjeto(@PathVariable Long id){
        projetoRepository.deleteById(id);
    }

    public ProjetoModel criarProjeto(@RequestBody ProjetoModel projetoModel){
        return projetoRepository.save(projetoModel);


    }

    public List<ProjetoModel> listarProjetos(){
        return projetoRepository.findAll();

    }

    public ProjetoModel atualizarProjeto(@PathVariable Long id, @RequestBody ProjetoModel projetoModel){
        ProjetoModel projetoNovo = projetoRepository.findById(id).get();
        projetoNovo.setNome(projetoModel.getNome());
        return projetoRepository.save(projetoNovo);
    }


}
