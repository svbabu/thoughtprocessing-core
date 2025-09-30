package com.thoughtprocessing.service;

import com.thoughtprocessing.model.Contact;
import com.thoughtprocessing.model.MessageDto;
import com.thoughtprocessing.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private final ContactRepository contactRepository;



    @Autowired
    public ContactService(ContactRepository contactRepository)
    {
        this.contactRepository = contactRepository;

    }
    public Contact save(Contact contact) {

        return contactRepository.save(contact);
    }
    public void saveMessage(MessageDto message) {
        Contact contact = new Contact();
        /*contact.setName(message.getId());*/
        contact.setName(message.getName());
        contact.setEmail(message.getEmail());
        contact.setMobile(message.getMobile());
        contact.setSubject(message.getSubject());
        contact.setMessage(message.getMessage());

        contactRepository.save(contact);
    }


    /*public Optional<Contact> findById(long id) {
        return contactRepository.findById(id);
    }
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }
    public Contact update(Contact contact)
    {
    return null;  // Optional<Contact> contactUpdate=contactRepository.findById(contact.getId());

    }*/
}
