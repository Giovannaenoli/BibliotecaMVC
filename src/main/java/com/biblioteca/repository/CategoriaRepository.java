package com.biblioteca.repository;

import com.biblioteca.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

// O JpaRepository já oferece métodos para salvar, buscar e excluir categorias.
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
