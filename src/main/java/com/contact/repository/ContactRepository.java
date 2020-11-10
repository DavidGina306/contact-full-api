package com.contact.repository;

import com.contact.models.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
    
public interface ContactRepository extends JpaRepository<Contato, Long> {
    Contato findByNome(String nome);
    List<Contato> findByNomeContaining(String nome);
    Contato findByEmail(String email);
    List<Contato> findByEmailContaining(String email);
}
