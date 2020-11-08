package com.contact.controllers;

import com.contact.converters.ContactConverter;
import com.contact.models.Contato;
import com.contact.presenters.ContactPresenter;
import com.contact.repository.ContactRepository;
import com.contact.services.ContactStoreService;
import com.contact.services.ContactUpdateService;
import com.contact.validaterequest.ContactFormValidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    ContactStoreService contactService;
    @Autowired
    ContactUpdateService contactUpdateService;
    @Autowired
    ContactRepository contactRepository;
    @Autowired
    ContactConverter contactConverter;

    @GetMapping
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Object[] listAllCollection() {
        return contactConverter.toCollection(contactRepository.findAll()).toArray();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ContactPresenter store(@Valid @RequestBody ContactFormValidate request) {
        Contato contato = contactConverter.toEntity(request);
        return contactConverter.toModel(contactService.store(contato));
    }

    @GetMapping("/contatoId")
    public ResponseEntity<ContactPresenter> filter(@PathVariable Long contatoId) {
        Optional<Contato> contato = contactRepository.findById(contatoId);
        if(contato.isPresent()) {
            ContactPresenter present = contactConverter.toModel(contato.get());
            return ResponseEntity.ok(present);
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{contatoId}")
    public ResponseEntity<Contato> update(@Valid @PathVariable Long contatoId,
                                          @RequestBody Contato contato) {
        if(!contactRepository.existsById(contatoId)) {
            return ResponseEntity.notFound().build();
        }
        contactUpdateService.update(contatoId, contato);
        return ResponseEntity.ok(contato);
    }
    
    @DeleteMapping("/{contatoId}")
    public ResponseEntity<Void> delete(@PathVariable Long contatoId) {
        if(!contactRepository.existsById(contatoId)) {
            return ResponseEntity.notFound().build();
        }
        contactRepository.deleteById(contatoId);
        return ResponseEntity.noContent().build();
    }
}
