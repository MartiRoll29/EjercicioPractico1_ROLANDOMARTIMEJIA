package com.ExamenWebGym.demo.service;

import com.ExamenWebGym.demo.domain.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> listarTodas();

    Categoria buscarPorId(Integer id);

    Categoria guardar(Categoria categoria);

    void eliminar(Integer id);
}
