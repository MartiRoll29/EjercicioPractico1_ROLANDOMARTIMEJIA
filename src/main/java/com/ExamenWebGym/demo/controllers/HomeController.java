package com.ExamenWebGym.demo.controllers;

import com.ExamenWebGym.demo.domain.ContactoForm;
import com.ExamenWebGym.demo.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("destacados", servicioService.listarTodas().stream().limit(3).toList());
        return "index";
    }

    @GetMapping("/contacto")
    public String contacto(Model model) {
        model.addAttribute("contacto", new ContactoForm());
        return "contacto";
    }

    @PostMapping("/contacto/enviar")
    public String enviarContacto(@ModelAttribute("contacto") ContactoForm contacto, Model model) {
        model.addAttribute("enviado", true);
        model.addAttribute("contacto", new ContactoForm());
        return "contacto";
    }
}
