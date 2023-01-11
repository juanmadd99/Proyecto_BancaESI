package com.example.application.data.service;

import com.example.application.data.entity.Movimiento;
import com.example.application.data.entity.RecibosDomiciliados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReciboDomiciliadoRepository extends JpaRepository<Movimiento, Long>, JpaSpecificationExecutor<Movimiento> {

	RecibosDomiciliados findById(Integer Id);
}
