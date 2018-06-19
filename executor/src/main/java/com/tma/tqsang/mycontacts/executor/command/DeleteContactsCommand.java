package com.tma.tqsang.mycontacts.executor.command;

import com.tma.tqsang.mycontacts.service.ContactsService;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;

/**
 * Created by tqsang on 6/6/2018.
 */
@Command(scope = "mycontacts", name = "delete", description = "Delete one contacts by name")
@Service
public class DeleteContactsCommand implements Action {
    @Argument(index = 0, name = "Name", required = true, description = "Name", multiValued = false)
    String name;
    @Reference
    private ContactsService contactsService;

    public void setContactsService(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @Override
    public Object execute() throws Exception {
        System.out.println("My contacts -> Delete a contacts  by name=" + name);
        contactsService.delete(name);
        System.out.println("Delete " + name + " success");
        return null;
    }

}