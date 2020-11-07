package com.contact.controllers;

import com.contact.converters.ContactConverter;
import com.contact.models.Contato;
import com.contact.presenters.ContactPresenter;
import com.contact.repository.ContactRepository;
import com.contact.services.ContactStoreService;
import com.contact.validaterequest.ContactFormValidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    ContactStoreService contactService;
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
}
