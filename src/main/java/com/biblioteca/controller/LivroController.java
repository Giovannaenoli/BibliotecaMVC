package com.biblioteca.controller;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping("/livros")
    public String listar(Model model) {
        model.addAttribute("livros", livroRepository.findAll());
        return "livros/lista";
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

    @GetMapping("/livros/editar/{id}")
    public String editarLivro(@PathVariable Long id, Model model) {
        Livro livro = livroRepository.findById(id).orElseThrow();
        model.addAttribute("livro", livro);
        return "livros/form";
    }

    @PostMapping("/livros")
    public String cadastrarLivro(@ModelAttribute("livro") Livro livro) {
        livroRepository.save(livro);
        return "redirect:/livros";
    }

    @GetMapping("/livros/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        livroRepository.deleteById(id);
        return "redirect:/livros";
    }
}
