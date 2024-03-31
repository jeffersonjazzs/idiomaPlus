package com.jeff.puc.dto;

import com.jeff.puc.domain.Contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {
    protected Long id;
    protected String name;
    protected String email;
    protected String subject;
    protected String message;

    public ContactDTO(Contact contact) {
        this.id = contact.getId();
        this.name = contact.getName();
        this.email = contact.getEmail();
        this.subject = contact.getSubject();
        this.message = contact.getMessage();
    }
}
