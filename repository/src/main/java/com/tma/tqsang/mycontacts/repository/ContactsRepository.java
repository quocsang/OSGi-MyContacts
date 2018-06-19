package com.tma.tqsang.mycontacts.repository;

import com.tma.tqsang.mycontacts.repository.entiti.Contact;

import java.util.List;

/**
 * Created by tqsang on 6/5/2018.
 */
public interface ContactsRepository  {
    boolean create(Contact contact);
    Contact readOne(String name);
    List<Contact> readAll();
    boolean update(Contact contact);
    boolean delete(String name);
}
