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
// Controla as páginas e ações relacionadas aos livros.
public class LivroController {

    // Usado para acessar os livros salvos no banco.
    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    // Busca os livros cadastrados e abre a página da lista.
    @GetMapping("/livros")
    public String listar(Model model) {
        model.addAttribute("livros", livroRepository.findAll());
        return "livros/lista";
    }

    // Mostra um livro de exemplo.
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

    // Abre o formulário para cadastrar um livro.
    @GetMapping("/livros/novo")
    public String novoLivro(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    // Busca o livro pelo ID e coloca os dados no formulário.
    @GetMapping("/livros/editar/{id}")
    public String editarLivro(@PathVariable Long id, Model model) {
        Livro livro = livroRepository.findById(id).orElseThrow();
        model.addAttribute("livro", livro);
        return "livros/form";
    }

    // Salva o livro. Se ele já tiver ID, atualiza o registro.
    @PostMapping("/livros")
    public String cadastrarLivro(@ModelAttribute("livro") Livro livro) {
        livroRepository.save(livro);
        return "redirect:/livros";
    }

    // Exclui o livro pelo ID e volta para a lista.
    @GetMapping("/livros/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        livroRepository.deleteById(id);
        return "redirect:/livros";
    }
}
