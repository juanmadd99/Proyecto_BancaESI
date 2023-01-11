package com.example.application.data.service;

import com.example.application.data.entity.Movimiento;
import com.example.application.data.entity.Tarjeta;
import com.example.application.data.entity.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ReciboDomiciliadoService {

    private final ReciboDomiciliadoRepository repository;

    public ReciboDomiciliadoService(ReciboDomiciliadoRepository repository) {
        this.repository = repository;
    }

    public Optional<Movimiento> get(Long id) {
        return repository.findById(id);
    }

    public Movimiento update(Movimiento entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<Movimiento> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Movimiento> list(Pageable pageable, Specification<Movimiento> filter) {
        return repository.findAll(filter, pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
