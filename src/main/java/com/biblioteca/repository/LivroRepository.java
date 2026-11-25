package com.biblioteca.repository;

import com.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

// O JpaRepository já oferece métodos para salvar, buscar e excluir livros.
public interface LivroRepository extends JpaRepository<Livro, Long> {
}

