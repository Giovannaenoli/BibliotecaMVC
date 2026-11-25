package com.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Representa um autor e seus dados no banco.
@Entity
public class Autor {

    // O banco cria um ID para identificar cada autor.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Informações do autor.
    private String nome;
    private String nacionalidade;
    private String obrasPublicadas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getObrasPublicadas() {
        return obrasPublicadas;
    }

    public void setObrasPublicadas(String obrasPublicadas) {
        this.obrasPublicadas = obrasPublicadas;
    }
}
