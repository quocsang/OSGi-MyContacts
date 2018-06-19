package com.tma.tqsang.mycontacts.service.impl;

import com.tma.tqsang.mycontacts.repository.ContactsRepository;
import com.tma.tqsang.mycontacts.repository.entiti.Contact;
import com.tma.tqsang.mycontacts.service.ContactsService;

import java.util.List;

/**
 * Created by tqsang on 6/4/2018.
 */
public class ContactsServiceImpl implements ContactsService{
    private ContactsRepository contactsRepository;

    public void setContactsRepository(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public boolean create(Contact contact) {
        try {
            return contactsRepository.create(contact);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Contact readOne(String name) {
        try {
            return contactsRepository.readOne(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Contact> readAll() {
        try {
            return contactsRepository.readAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Contact contact) {
        try {
            return contactsRepository.update(contact);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String name) {
        try {
            return contactsRepository.delete(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
