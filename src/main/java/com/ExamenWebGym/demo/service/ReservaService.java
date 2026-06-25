package com.ExamenWebGym.demo.service;

import com.ExamenWebGym.demo.domain.Reserva;

import java.util.List;

public interface ReservaService {

    List<Reserva> listarTodas();

    Reserva buscarPorId(Integer id);

    Reserva guardar(Reserva reserva);

    void eliminar(Integer id);
}
