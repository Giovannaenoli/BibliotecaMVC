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

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping({"", "/novo"})
    public String listar(Model model) {
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("categorias", categoriaRepository.findAll());
        return "categorias/form";
    }

    @PostMapping
    public String cadastrarCategoria(@ModelAttribute("categoria") Categoria categoria) {
        categoriaRepository.save(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        categoriaRepository.deleteById(id);
        return "redirect:/categorias";
    }
}
