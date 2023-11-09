package com.senai.cadlivros.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.cadlivros.entities.livro;
import com.senai.cadlivros.repository.livroRepository;

@Service
public class livroServicies {
	private final livroRepository LivroRepository;	
	@Autowired
	public livroServicies(livroRepository LivroRepository ) {
		this.LivroRepository = LivroRepository;
	}
	
	public livro Savelivro(livro livro) {
		return LivroRepository.save(livro);
	}
	public List<livro> getAlllivro(){
		return LivroRepository.findAll();
	}
	
	public livro getlivroByid(Long id) {
		return LivroRepository.findById(id).orElse(null);			
	}
	
	public void deletelivro(Long id) {
		LivroRepository.deleteById(id);
	}
	
	// fazendo o update do jogo com o optional
		public livro updatelivro(Long id, livro novolivro) {
	        Optional<livro> livroOptional = LivroRepository.findById(id);
	        if (livroOptional.isPresent()) {
	        	livro livroExistente = livroOptional.get();
	           	livroExistente.setdescrição(novolivro.getdescrição());
	        	livroExistente.setisbn(novolivro.getisbn());          
	            return LivroRepository.save(livroExistente); 
	        } else {
	            return null; 
	        }
	    }

		

	
	
}
