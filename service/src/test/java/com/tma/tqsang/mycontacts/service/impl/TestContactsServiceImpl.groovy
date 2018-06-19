package com.tma.tqsang.mycontacts.service.impl

import com.tma.tqsang.mycontacts.repository.ContactsRepository
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner;
/**
 * Created by tqsang on 6/6/2018.
 */

@RunWith(MockitoJUnitRunner.class)
class TestContactsServiceImpl  {

    @InjectMocks
    private ContactsServiceImpl contactsService;

    @Mock
    private ContactsRepository contactsRepository;

    @Before
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    void tearDown() {
    }

    @Test
    void testCreate() {
    }
    @Test
    void testReadOne() {
    }

    @Test
    void testReadAll() {
    }

    @Test
    void testUpdate() {
    }

    @Test
    void testDelete() {
    }
}
