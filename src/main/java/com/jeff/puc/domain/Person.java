package com.jeff.puc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.jeff.puc.dto.PersonDTO;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name;
    protected String phone;
    protected String email;
    protected String cep;
    protected String street;
    protected Integer number;
    protected String district;
    protected String city;
    protected String state;
    protected String country;

    public Person(PersonDTO personDTO) {
        this.id = personDTO.getId();
        this.name = personDTO.getName();
        this.phone = personDTO.getPhone();
        this.email = personDTO.getEmail();
        this.cep = personDTO.getCep();
        this.street = personDTO.getStreet();
        this.number = personDTO.getNumber();
        this.district = personDTO.getDistrict();
        this.city = personDTO.getCity();
        this.state = personDTO.getState();
        this.country = personDTO.getCountry();
    }
}
