package com.facisaflix.edu.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facisaflix.edu.Entidades.Filme;
import com.facisaflix.edu.Repositorios.FilmeRepository;

@Service
public class FilmeService {
	
	@Autowired
	private FilmeRepository filmeRepository;
	
	public List<Filme> listarFilmes(){
		return filmeRepository.findAll();
	}
	
	public Optional<Filme> retornarFilme(Long id) {
		return filmeRepository.findById(id);
	}
	
	public Filme criarFilme(Filme filme) {
		return filmeRepository.save(filme);
	}
	
	public Filme atualizarFilme(Long id, Filme filmeNovo) {
		Filme filmeAntigo = filmeRepository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
		
		
		if(filmeNovo.getTitulo() != null) {
			filmeAntigo.setTitulo(filmeNovo.getTitulo());	
		}
		    
		if(filmeNovo.getGenero() != null) {
			filmeAntigo.setGenero(filmeNovo.getGenero());	
		}
		
		if(filmeNovo.getSinopse() != null) {
			filmeAntigo.setSinopse(filmeNovo.getSinopse());	
		}
		
		if(filmeNovo.getAutor() != null) {
			filmeAntigo.setAutor(filmeNovo.getAutor());	
		}
		
		if(filmeNovo.getAnoLancamento() != null) {
			filmeAntigo.setAnoLancamento(filmeNovo.getAnoLancamento());	
		}
		
		if(filmeNovo.getDuracao() != null) {
			filmeAntigo.setDuracao(filmeNovo.getDuracao());	
		}
		
		return filmeRepository.save(filmeAntigo);	
	}
	
	public void deletarFilme(Long id) {
		filmeRepository.deleteById(id);
	}
	
		
	
	
	
	
	

	
}


