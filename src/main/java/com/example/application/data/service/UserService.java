package com.example.application.data.service;
import com.example.application.data.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lombok.RequiredArgsConstructor;
import org.vaadin.crudui.crud.CrudListener;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

@Service
public class UserService implements CrudListener<User> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserRepository repository;

	//Métodos de CrudListener<User>
	
    public Optional<User> get(Integer id) {
        return repository.findById(id);
    }

    @Override
    public User update(User entity) {
        return repository.save(entity);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
    
    public Page<User> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public int count() {
        return (int) repository.count();
    }

	@Override
	public Collection<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User add(User domainObjectToAdd) {
		return repository.save(domainObjectToAdd);
	}

	@Override
	public void delete(User domainObjectToDelete) {
		repository.delete(domainObjectToDelete);
	}
	
	public int lastId() {
		return repository.findLastId();
	}
}
