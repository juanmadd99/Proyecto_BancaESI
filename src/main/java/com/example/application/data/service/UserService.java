package com.example.application.data.service;
import com.example.application.data.entity.User;

import java.util.Collection;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.vaadin.crudui.crud.CrudListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements CrudListener<User> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final UserRepository repository = null;


    public Optional<User> get(Integer id) {
        return repository.findById(id);
    }

    @Override
    public User update(User entity) {
        return repository.save(entity);
    }

    public void delete(Integer id) {
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

}
