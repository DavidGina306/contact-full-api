package com.contact.services;

import com.contact.execptions.domain.ApiExecption;
import com.contact.models.Contato;
import com.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class ContactStoreService {
    @Autowired
    private ContactRepository contactRepository;

    public Contato store(Contato contato) {
        Contato contatoExist = contactRepository.findByNome(contato.getNome());
        System.out.println(contatoExist);
        if(contatoExist != null && !contatoExist.equals(contato) ) {
            throw new ApiExecption("Contato já existente");
        }
        contato.setCreatedDate(OffsetDateTime.now());
        contato.setUpdatedDate(OffsetDateTime.now());
        return contactRepository.save(contato);
    }
}
