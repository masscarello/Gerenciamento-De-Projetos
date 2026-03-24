package com.Mascarello.GerenciamentoDeProjetos.Repositories;

import com.Mascarello.GerenciamentoDeProjetos.Models.ProjetoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoModel, Long> {
}
