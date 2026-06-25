package com.ExamenWebGym.demo.controllers;

import com.ExamenWebGym.demo.domain.Servicio;
import com.ExamenWebGym.demo.service.CategoriaService;
import com.ExamenWebGym.demo.service.ServicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clases")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clases", servicioService.listarTodas());
        return "clases/list";
    }

    @GetMapping("/nueva")
    public String formularioNueva(Model model) {
        model.addAttribute("clase", new Servicio());
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "clases/form";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable Integer id, Model model) {
        model.addAttribute("clase", servicioService.buscarPorId(id));
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "clases/form";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("clase") Servicio clase, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categorias", categoriaService.listarTodas());
            return "clases/form";
        }
        servicioService.guardar(clase);
        return "redirect:/clases";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        servicioService.eliminar(id);
        return "redirect:/clases";
    }
}
