package com.example.application.data.service;

import com.example.application.data.entity.Movimiento;
import com.example.application.data.entity.Tarjeta;
import com.example.application.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long>, JpaSpecificationExecutor<Movimiento> {

	Movimiento findById(Integer Id);
}
