package com.tma.tqsang.mycontacts.service;

import com.tma.tqsang.mycontacts.repository.entiti.Contact;

import java.util.List;

/**
 * Created by tqsang on 6/4/2018.
 */
public interface ContactsService {
    boolean create(Contact contact);
    Contact readOne(String name);
    List<Contact> readAll();
    boolean update(Contact contact);
    boolean delete(String name);
}
