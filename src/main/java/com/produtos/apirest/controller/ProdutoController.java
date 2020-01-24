package com.produtos.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// Essa é a classe que vai receber as requisições HTTP
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*") // Qualquer domínio acessa essa api
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;
	
	// Retorna uma lista de produtos
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos") // Descrição sobre o que o método faz
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	// Retorna apenas um produto
	@GetMapping("/produto/{id}")
	@ApiOperation(value="Retorna um produto único") // Descrição sobre o que o método faz
	public Produto listaProdutoUnico(@PathVariable(value = "id") long id){
		// Para não converter Produto para Optional<> e também para não precisar de fazer um método no repository,
		// é só inserir .get() que o código estará funcionando da maneira correta.
		return produtoRepository.findById(id).get();
	}
	
	// Insere um produto
	@PostMapping("/produto")
	@ApiOperation(value="Salva um produto") // Descrição sobre o que o método faz
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	// Atualiza um produto
	@PutMapping("/produto")
	@ApiOperation(value="Atualiza um produto") // Descrição sobre o que o método faz
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	// Deleta um produto
	@DeleteMapping("/produto")
	@ApiOperation(value="Deleta um produto") // Descrição sobre o que o método faz
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	
	
}
