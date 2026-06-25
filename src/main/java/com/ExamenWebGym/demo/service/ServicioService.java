package com.ExamenWebGym.demo.service;

import com.ExamenWebGym.demo.domain.Servicio;

import java.util.List;

public interface ServicioService {

    List<Servicio> listarTodas();

    Servicio buscarPorId(Integer id);

    Servicio guardar(Servicio servicio);

    void eliminar(Integer id);
}
