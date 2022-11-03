package es.uca.iw.bancaesi.webApp.data.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import es.uca.iw.bancaesi.webApp.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, UUID> {

}
