package com.tma.tqsang.mycontacts.executor.client;

import com.tma.tqsang.mycontacts.service.ContactsService;

/**
 * Created by tqsang on 6/4/2018.
 */
public class Client {
    private ContactsService m_contactsService;

    public void setM_contactsService(ContactsService m_contactsService) {
        this.m_contactsService = m_contactsService;
    }

    public void init(){
        System.out.println("Client is started!");
        System.out.println("Welcome to use MyContacts Application!");

        m_contactsService.readAll();
    }

    public void close(){
        System.out.println("Bye!");
    }
}
