package com.example.application.data.service;
import com.example.application.data.entity.User;
import java.util.Optional;

import com.vaadin.flow.component.crud.CrudGrid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudGrid<User> {

    private final UserRepository repository;


    public Optional<User> get(Integer id) {
        return repository.findById(id);
    }

    @Override
    public User update(User entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Page<User> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
