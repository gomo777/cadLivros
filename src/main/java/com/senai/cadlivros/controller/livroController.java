package com.senai.cadlivros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.cadlivros.entities.livro;
import com.senai.cadlivros.service.livroServicies;

@RestController
@RequestMapping("/livro")
public class livroController {
private final livroServicies livroServicies;
	
	@Autowired
	public livroController(livroServicies livroServicies) {
		this.livroServicies = livroServicies ;
	}
	
	@PostMapping
	public livro createProduct(@RequestBody livro livro ) {
		//return produtoService.saveProduto(produto);
		return livroServicies.Savelivro(livro);
	}
	@GetMapping("/{id}")
	public ResponseEntity<livro> getlivro(@PathVariable Long id) {
		livro livro = livroServicies.getlivroByid(id);
		if(livro != null) {
			return ResponseEntity.ok(livro);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/home")
	public String paginaInicial() {
		return "index" ; // nome do seu arquivo HTML , (sem a extensão)
	}
	

	public List<livro> getAlllivro(){
		return livroServicies.getAlllivro();
	}
	@DeleteMapping("/{id}")
	public void deletelivro(@PathVariable Long id) {
		livroServicies.deletelivro(id);
	}
	
	//Utilizando o ResponseEntity e RequestEntity
		@GetMapping
		public ResponseEntity<List<livro>> getAlllivro(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<livro> livro = livroServicies.getAlllivro();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(livro);
		}
		
		@PutMapping("/{id}")
		public livro updateJogo(@PathVariable Long id, @RequestBody livro livro) {
		    return livroServicies.updatelivro(id, livro);
		}
}
