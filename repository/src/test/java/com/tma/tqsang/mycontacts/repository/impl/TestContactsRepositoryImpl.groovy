package com.tma.tqsang.mycontacts.repository.impl

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource
import com.tma.tqsang.mycontacts.repository.entiti.Contact
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Ignore
import org.junit.Test


/**
 * Created by tqsang on 6/6/2018.
 */
class TestContactsRepositoryImpl {

    private ContactsRepositoryImpl contactsRepository;

    @Before
    void setUp() {
        contactsRepository = new ContactsRepositoryImpl();
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("test");
        dataSource.setPort(3306);
        dataSource.setUser("root");
        dataSource.setPassword("");
        contactsRepository.setDataSource(dataSource);

        Contact contact = new Contact("Tran Quoc Sang", "tranquocsang28@gmail.com");
        contactsRepository.create(contact);
    }
    @After
    void tearDown() {
        contactsRepository.delete("Tran Quoc Sang");
    }

    @Test
    void testReadAll() {
        List<Contact> contacts = contactsRepository.readAll();
        Assert.assertTrue(contacts.size() > 0);
    }

    @Test
    void testCreate() {
        Contact contact = new Contact("name test", "nametest@gmail.com");
        contactsRepository.create(contact);
        Assert.assertFalse(contactsRepository.create(contact));
        Contact newcontact =  contactsRepository.readOne("name test");
        Assert.assertEquals("name test", newcontact.getName());
        Assert.assertEquals("nametest@gmail.com", newcontact.getEmail());
        contactsRepository.delete("name  test");
    }

    @Test
    void testReadOne() {

        Contact contact =  contactsRepository.readOne("Tran Quoc Sang");
        Assert.assertEquals("Tran Quoc Sang", contact.getName());
        Assert.assertEquals("tranquocsang28@gmail.com", contact.getEmail());
    }

    @Test
//    @Ignore
    void testUpdate() {
        Contact contact = new Contact("Tran Quoc Sang", "updateemail@gmail.com");
        Assert.assertTrue(contactsRepository.update(contact));

        Contact newcontact =  contactsRepository.readOne("Tran Quoc Sang");
        Assert.assertEquals("Tran Quoc Sang", newcontact.getName());
        Assert.assertEquals("updateemail@gmail.com", newcontact.getEmail());


        Contact contact2 = new Contact("Tran Quoc Sang2", "updateemail@gmail.com");
        Assert.assertFalse(contactsRepository.update(contact2));

    }

    @Test
    void testDelete() {
        Assert.assertTrue(contactsRepository.delete("Tran Quoc Sang"));
        Assert.assertFalse(contactsRepository.delete("Tran Quoc Sang"));
        Assert.assertFalse(contactsRepository.delete("Tran Quoc Sang2"));
    }
}
