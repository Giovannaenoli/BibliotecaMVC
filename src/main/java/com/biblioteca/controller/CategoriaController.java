package com.biblioteca.controller;

import com.biblioteca.model.Categoria;
import com.biblioteca.repository.CategoriaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Controla o cadastro, a lista e a exclusão de categorias.
@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    // Usado para acessar as categorias salvas no banco.
    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Abre o formulário e carrega as categorias cadastradas.
    @GetMapping({"", "/novo"})
    public String listar(Model model) {
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "categorias/form";
    }

    // Salva a categoria e volta para a lista.
    @PostMapping
    public String cadastrarCategoria(@ModelAttribute("categoria") Categoria categoria) {
        categoriaRepository.save(categoria);
        return "redirect:/categorias";
    }

    // Exclui a categoria pelo ID e volta para a lista.
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
        return "redirect:/categorias";
    }
}
