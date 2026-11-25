package com.biblioteca.controller;

import com.biblioteca.model.Autor;
import com.biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @GetMapping({"", "/novo"})
    public String listar(Model model) {
        model.addAttribute("autor", new Autor());
        model.addAttribute("autores", autorRepository.findAll());
        return "autores/form";
    }

    @PostMapping
    public String cadastrarAutor(@ModelAttribute("autor") Autor autor) {
        autorRepository.save(autor);
        return "redirect:/autores";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        autorRepository.deleteById(id);
        return "redirect:/autores";
    }
}
