package com.contact.converters;

import com.contact.models.Contato;
import com.contact.presenters.ContactPresenter;
import com.contact.validaterequest.ContactFormValidate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactConverter {
    @Autowired
    private ModelMapper modelMapper;

    public ContactPresenter toModel(Contato contato) {
        ContactPresenter present = modelMapper.map(contato, ContactPresenter.class);
        return present;
    }

    public List<ContactPresenter> toCollection(List<Contato> contatos) {
        return contatos.stream()
                .map(contato -> toModel(contato))
                .collect(Collectors.toList());
    }

    public Contato toEntity(ContactFormValidate contactFormValidate) {
        return modelMapper.map(contactFormValidate, Contato.class);
    }
}
