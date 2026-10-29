package com.biblioteca.controller;

import com.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LivroController {

    @GetMapping("/livros")
    public String inicio() {
        return "livros/inicio";
    }

    @GetMapping("/livro")
    public String exibirLivro(Model model) {
        Livro livro = new Livro();
        livro.setTitulo("Trono de Vidro");
        livro.setAutor("Sarah J. Maas");
        livro.setIsbn("978-0261102385");
        livro.setAnoPublicacao(2012);

        model.addAttribute("livro", livro);
        return "livro";
    }

    @GetMapping("/livros/novo")
    public String novoLivro(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    @PostMapping("/livros")
    public String cadastrarLivro(@ModelAttribute("livro") Livro livro, Model model) {
        model.addAttribute("livro", livro);
        return "livros/confirmacao";
    }
}
