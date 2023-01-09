package com.example.application.data.service;

import com.example.application.data.entity.Tarjeta;
import com.example.application.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Long>, JpaSpecificationExecutor<Tarjeta> {

    Tarjeta findByNumero(Integer numero);
}
