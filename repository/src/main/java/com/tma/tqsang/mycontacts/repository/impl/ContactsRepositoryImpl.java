package com.tma.tqsang.mycontacts.repository.impl;

import com.tma.tqsang.mycontacts.repository.ContactsRepository;
import com.tma.tqsang.mycontacts.repository.entiti.Contact;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tqsang on 6/5/2018.
 */
public class ContactsRepositoryImpl implements ContactsRepository {
    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Contact> readAll() {
        List<Contact> contacts = new ArrayList<Contact>();
        try (
                Connection con = dataSource.getConnection();
                Statement stmt = con.createStatement()
        ) {
            ResultSet rs = stmt.executeQuery("select * from person");
            ResultSetMetaData meta = rs.getMetaData();
            while (rs.next()) {
                Contact contact = new Contact(rs.getString("name"), rs.getString("email"));
                contacts.add(contact);
            }
            return contacts;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean create(Contact contact) {
        String sql = "insert into person (name, email) values ('" + contact.getName() + "', '" + contact.getEmail()+ "')";
        try (
                Connection con = dataSource.getConnection();
                Statement stmt = con.createStatement()
        ) {
            Contact contact1 = readOne(contact.getName());
            if (contact1.getName() == null){
                stmt.execute(sql);
                return true;
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Contact readOne(String name) {
        Contact contact = new Contact();
        String sql = "select * from person where name='" + name + "'";
        try (
                Connection con = dataSource.getConnection();
                Statement stmt = con.createStatement()
        ) {
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();
            while (rs.next()) {
                contact.setName(rs.getString("name"));
                contact.setEmail(rs.getString("email"));
            }
            return contact;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public boolean update(Contact contact) {
        String sql ="UPDATE person SET email='" + contact.getEmail()+ "' WHERE name='" + contact.getName() + "'";
        try (
                Connection con = dataSource.getConnection();
                Statement stmt = con.createStatement()
        ) {
            if (stmt.executeUpdate(sql) > 0 ){
                return true;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(String name) {
        String sql="delete from person where name='" + name + "'";
        try (
                Connection con = dataSource.getConnection();
                Statement stmt = con.createStatement()
        ) {
            if (stmt.executeUpdate(sql) > 0 ){
                return true;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private void writeInfos(Connection con) throws SQLException {
        DatabaseMetaData dbMeta = con.getMetaData();
        System.out.println("Using datasource " + dbMeta.getDatabaseProductName() + ", URL " + dbMeta.getURL());
    }

    private void dropTable(Connection con) {
        try (Statement stmt = con.createStatement()) {
            stmt.execute("drop table person");
        }
        catch (Exception e) {
            // Ignore as it will fail the first time
        }
    }

    private void writeResult(ResultSet rs, int columnCount) throws SQLException {
        for (int c = 1; c <= columnCount; c++) {
            System.out.print(rs.getString(c) + ", ");
        }
        System.out.println();
    }
}
