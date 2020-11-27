package com.produtos.apirest.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.domain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
