package com.example.application.data.service;

import com.example.application.data.entity.Tarjeta;
import com.example.application.data.entity.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TarjetaService {

    private final TarjetaRepository repository;

    public TarjetaService(TarjetaRepository repository) {
        this.repository = repository;
    }

    public Optional<Tarjeta> get(Long id) {
        return repository.findById(id);
    }

    public Tarjeta update(Tarjeta entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<Tarjeta> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Tarjeta> list(Pageable pageable, Specification<Tarjeta> filter) {
        return repository.findAll(filter, pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
