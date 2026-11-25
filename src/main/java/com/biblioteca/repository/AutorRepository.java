package com.biblioteca.repository;

import com.biblioteca.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

// O JpaRepository já oferece métodos para salvar, buscar e excluir autores.
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
