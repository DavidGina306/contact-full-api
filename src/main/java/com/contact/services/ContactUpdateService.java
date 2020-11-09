package com.contact.services;

import com.contact.models.Contato;
import com.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;

@Service
public class ContactUpdateService {
    @Autowired
    ContactRepository contactRepository;

    public Contato update(Long contatoId, Contato contato) {
        contato.setId(contatoId);
        contato.setUpdatedDate(OffsetDateTime.now());
        return contactRepository.save(contato);
    }
}
