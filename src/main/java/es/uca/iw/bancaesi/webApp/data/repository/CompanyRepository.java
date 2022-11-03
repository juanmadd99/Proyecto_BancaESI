package es.uca.iw.bancaesi.webApp.data.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.bancaesi.webApp.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, UUID> {

}
