package com.jeff.puc.dto;

import com.jeff.puc.domain.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
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

   public PersonDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.phone = person.getPhone();
        this.email = person.getEmail();
        this.cep = person.getCep();
        this.street = person.getStreet();
        this.number = person.getNumber();
        this.district = person.getDistrict();
        this.city = person.getCity();
        this.state = person.getState();
        this.country = person.getCountry();
   }
}
