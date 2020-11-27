package com.produtos.apirest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.domain.model.Produto;
import com.produtos.apirest.domain.service.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

	@Autowired
	private ProdutoService service;

	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista de produtos")
	public ResponseEntity<List<Produto>> listaProdutos() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retorna um produto único")
	public ResponseEntity<Produto> listaProdutoUnico(@PathVariable(value = "id") Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@PostMapping("/produto")
	@ApiOperation(value = "Salva um produto")
	public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto) {
		return new ResponseEntity<>(service.save(produto), HttpStatus.CREATED);
	}

	@PutMapping("/produto/{id}")
	@ApiOperation(value = "Atualiza um produto")
	public ResponseEntity<Produto> atualizaProduto(@PathVariable Long id, @RequestBody Produto produto) {
		service.update(id, produto);
		return ResponseEntity.ok(produto);
	}

	@DeleteMapping("/produto/{id}")
	@ApiOperation(value = "Deleta um produto")
	public ResponseEntity<Void> deletaProduto(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
