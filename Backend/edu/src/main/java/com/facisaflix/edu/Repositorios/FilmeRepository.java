package com.facisaflix.edu.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.facisaflix.edu.Entidades.Filme;

public interface FilmeRepository  extends JpaRepository<Filme, Long> {
	

}
