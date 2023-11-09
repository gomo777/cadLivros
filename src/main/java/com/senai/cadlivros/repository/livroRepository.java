package com.senai.cadlivros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.cadlivros.entities.livro;

public interface livroRepository extends JpaRepository<livro,Long>{

}
