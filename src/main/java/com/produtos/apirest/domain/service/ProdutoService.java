package com.produtos.apirest.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.apirest.api.exception.ResourceNotFoundException;
import com.produtos.apirest.domain.model.Produto;
import com.produtos.apirest.infrastructure.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private static final String ID_NOT_FOUND = "Id not found";

	@Autowired
	private ProdutoRepository repository;

	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ID_NOT_FOUND));
	}

	public Produto save(Produto produto) {
		return repository.save(produto);
	}

	public Produto update(Long id, Produto produto) {
		verifyIfIdExists(id);
		produto.setId(id);
		produto = repository.save(produto);
		return produto;
	}

	public void delete(Long id) {
		verifyIfIdExists(id);
		repository.deleteById(id);
	}

	private void verifyIfIdExists(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException(ID_NOT_FOUND);
		}
	}

}
