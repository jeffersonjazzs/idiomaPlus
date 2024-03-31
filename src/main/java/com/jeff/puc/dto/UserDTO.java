package com.jeff.puc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.jeff.puc.domain.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotBlank
    protected Long id;
    @NotBlank
    protected String name;
    @NotBlank
    @Email
    protected String email;
    @NotBlank
    protected String password;
    @NotBlank
    protected String role;
    @NotBlank
    public String username;

   public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.username = user.getUsername();
   }
}
