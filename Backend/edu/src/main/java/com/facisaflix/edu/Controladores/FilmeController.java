package com.facisaflix.edu.Controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facisaflix.edu.Entidades.Filme;
import com.facisaflix.edu.Services.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
	
	@Autowired
	private FilmeService filmeService;
	
	@GetMapping
	private ResponseEntity<List<Filme>> listarFilmes(){
		return ResponseEntity.ok(filmeService.listarFilmes());	
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Filme> retornarFilme(@PathVariable Long id){
		Optional<Filme> filmePorId = filmeService.retornarFilme(id);
		
		if(filmePorId.isPresent() ) {
			return ResponseEntity.ok(filmePorId.get());
		} else {
			return ResponseEntity.notFound().build();
		}				
	}
	
	@PostMapping
	private ResponseEntity<Filme> criarFilme(@RequestBody Filme filme){
		Filme filmeNovo = filmeService.criarFilme(filme);
		return ResponseEntity.status(201).body(filmeNovo);	
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<Filme> atualizarFilme(@PathVariable Long id, @RequestBody Filme filme){
		Filme filmeAtualizado = filmeService.atualizarFilme(id, filme);		
		return ResponseEntity.status(200).body(filmeAtualizado);	
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<Void> deletarFilme(@PathVariable Long id){
		filmeService.deletarFilme(id);
		return ResponseEntity.noContent().build();
	}
	
}
