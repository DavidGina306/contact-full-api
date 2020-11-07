package com.contact.services;

import com.contact.execptions.domain.ApiExecption;
import com.contact.models.Contato;
import com.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactStoreService {
    @Autowired
    private ContactRepository contactRepository;

    public Contato store(Contato contato) {
        Contato contatoExist = contactRepository.findByNome(contato.getNome());
        if(contatoExist != null && !contatoExist.equals(contato) ) {
            throw new ApiExecption("Cliente já existente");
        }
        return contactRepository.save(contato);
    }
}
