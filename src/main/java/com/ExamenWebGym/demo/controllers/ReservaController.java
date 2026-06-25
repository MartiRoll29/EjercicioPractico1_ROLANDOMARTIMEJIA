package com.ExamenWebGym.demo.controllers;

import com.ExamenWebGym.demo.domain.Reserva;
import com.ExamenWebGym.demo.service.ReservaService;
import com.ExamenWebGym.demo.service.ServicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("reservas", reservaService.listarTodas());
        return "reservas/list";
    }

    @GetMapping("/nueva")
    public String formularioNueva(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("servicios", servicioService.listarTodas());
        return "reservas/form";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable Integer id, Model model) {
        model.addAttribute("reserva", reservaService.buscarPorId(id));
        model.addAttribute("servicios", servicioService.listarTodas());
        return "reservas/form";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("reserva") Reserva reserva, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("servicios", servicioService.listarTodas());
            return "reservas/form";
        }
        reservaService.guardar(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        reservaService.eliminar(id);
        return "redirect:/reservas";
    }
}
