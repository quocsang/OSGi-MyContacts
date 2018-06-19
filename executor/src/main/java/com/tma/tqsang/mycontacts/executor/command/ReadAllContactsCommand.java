package com.tma.tqsang.mycontacts.executor.command;

import com.tma.tqsang.mycontacts.repository.entiti.Contact;
import com.tma.tqsang.mycontacts.service.ContactsService;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tqsang on 6/6/2018.
 */
@Command(scope = "mycontacts", name = "list", description = "Read all list contacts")
@Service
public class ReadAllContactsCommand implements Action {

    @Reference
    private ContactsService contactsService;

    public void setContactsService(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @Override
    public Object execute() throws Exception {
        System.out.println("Read all contacts: ");
        List<Contact> contacts = contactsService.readAll();
        if (contactsService.readAll() != null) {
            System.out.println(String.format("%30s %25s %10s", "Name", "|", "Email"));
            System.out.println(String.format("%s", "------------------------------------------------------------------------------------------"));
            for (Contact contact : contacts) {
                System.out.println(String.format("%30s %25s %10s", contact.getName(), "|", contact.getEmail()));
            }
        } else {
            System.out.println("Contacts is null !!");
        }
        return null;
    }

}