package com.jeff.puc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.jeff.puc.dto.ContactDTO;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name;
    protected String email;
    protected String subject;
    protected String message;

    public Contact(ContactDTO contactDTO) {
        this.id = contactDTO.getId();
        this.name = contactDTO.getName();
        this.email = contactDTO.getEmail();
        this.subject = contactDTO.getSubject();
        this.message = contactDTO.getMessage();
    }
}
