package com.mellberg.myphonebook.contact;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Contact {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "contact_id", nullable = false)
    private int contactId;
    @Basic
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = true, length = 30)
    private String lastName;
    @Basic
    @Column(name = "phone_nr", nullable = true)
    private Integer phoneNr;

    public Contact() {
    }

    public Contact(String firstName, String lastName, Integer phoneNr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNr = phoneNr;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(Integer phoneNr) {
        this.phoneNr = phoneNr;
    }

}
