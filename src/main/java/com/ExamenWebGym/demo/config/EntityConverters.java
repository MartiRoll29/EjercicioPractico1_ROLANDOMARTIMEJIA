package com.ExamenWebGym.demo.config;

import com.ExamenWebGym.demo.domain.Categoria;
import com.ExamenWebGym.demo.domain.Servicio;
import com.ExamenWebGym.demo.repository.CategoriaRepository;
import com.ExamenWebGym.demo.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

public class EntityConverters {

    @Component
    public static class CategoriaConverter implements Converter<String, Categoria> {

        @Autowired
        private CategoriaRepository categoriaRepository;

        @Override
        public Categoria convert(String source) {
            if (source == null || source.isBlank()) {
                return null;
            }
            return categoriaRepository.findById(Integer.parseInt(source)).orElse(null);
        }
    }

    @Component
    public static class ServicioConverter implements Converter<String, Servicio> {

        @Autowired
        private ServicioRepository servicioRepository;

        @Override
        public Servicio convert(String source) {
            if (source == null || source.isBlank()) {
                return null;
            }
            return servicioRepository.findById(Integer.parseInt(source)).orElse(null);
        }
    }
}
