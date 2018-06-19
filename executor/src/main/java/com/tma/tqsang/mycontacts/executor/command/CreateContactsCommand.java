package com.tma.tqsang.mycontacts.executor.command;

import com.tma.tqsang.mycontacts.repository.entiti.Contact;
import com.tma.tqsang.mycontacts.service.ContactsService;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

/**
 * Created by tqsang on 6/6/2018.
 */
@Command(scope = "mycontacts", name = "create", description = "Create a new contacts")
@Service
public class CreateContactsCommand implements Action {
    @Argument(index = 0, name = "Name", required = true, description = "Name", multiValued = false)
    String name;
    @Argument(index = 1, name = "Email", required = true, description = "Email", multiValued = false)
    String email;
    @Reference
    private ContactsService contactsService;

    public void setContactsService(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @Override
    public Object execute() throws Exception {
        Contact contact = new Contact(name, email);
        System.out.println("My contacts -> Create a new contacts name=" + name + " email=" + email);


        if (contactsService.create(contact)){
            System.out.println("Create Success");
        } else {
            System.out.println("Create False");
        }
        return null;
    }

}