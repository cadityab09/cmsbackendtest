package com.clinic.cms.entity;

//public class Enquiry {
//}

import jakarta.persistence.*;

@Entity
@Table(name = "enquiries")
public class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contact;

    private String message;

    // No-argument constructor
    public Enquiry() {
    }

    // All-argument constructor
    public Enquiry(Long id, String name,  String contact, String message) {
        this.id = id;
        this.name = name;

        this.contact = contact;

        this.message = message;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

