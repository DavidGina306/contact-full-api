package com.contact.repository;

import com.contact.models.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
    
public interface ContactRepository extends JpaRepository<Contato, Long> {
    Contato findByNome(String nome);
    List<Contato> findByNomeContaining(String nome);
    Contato findByEmail(String email);
    List<Contato> findByEmailContaining(String email);
    @Query("FROM contatos cont " + "WHERE cont.nome like %:searchTerm% or "
    		+ "LOWER(cont.telefone) like %:searchTerm% or "
    		+ "LOWER(cont.email) like %:searchTerm% or "
    		+ "LOWER(cont.sexo) like %:searchTerm%")
    List<Contato> search(@Param("searchTerm") String searchTerm);
}
