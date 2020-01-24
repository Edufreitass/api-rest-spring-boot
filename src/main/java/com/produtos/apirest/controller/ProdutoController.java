package com.produtos.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

// Essa é a classe que vai receber as requisições HTTP
@RestController
@RequestMapping(value="/api")
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	// Retorna uma lista de produtos
	@GetMapping("/produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	// Retorna apenas um produto
	@GetMapping("/produto/{id}")
	public Produto listaProdutoUnico(@PathVariable(value = "id") long id){
		// Para não converter Produto para Optional<> e também para não precisar de fazer um método no repository,
		//é só inserir .get() que o código estará funcionando da maneira correta.
		return produtoRepository.findById(id).get();
	}
	
	// Insere um produto no banco de dados
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	
	
	
	
}
