package com.jeff.puc.resources;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jeff.puc.dto.UserDTO;
import com.jeff.puc.repositories.UserRepository;
import com.jeff.puc.services.impl.UserDetailsServiceImpl;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserResource {
    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final UserRepository userRepository;

    public UserResource(UserDetailsServiceImpl userDetailsServiceImpl,
                        UserRepository userRepository) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(this.userDetailsServiceImpl.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.userDetailsServiceImpl.findById(id));
    }

    @GetMapping("/userName/{userName}")
    public ResponseEntity<UserDTO> findByName(@PathVariable String userName)  {
        this.userDetailsServiceImpl.findByUsername(userName);
        return ResponseEntity.ok(this.userDetailsServiceImpl.enviarSenha(userName));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.accepted().body(this.userDetailsServiceImpl.update(id, userDTO));
    }

    @PutMapping("trocarSenha/{id}")
    public ResponseEntity<UserDTO> trocarSenha(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.accepted().body(this.userDetailsServiceImpl.trocarSenha(id, userDTO));
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO newUserDTO) {
        try {
            this.userRepository.findByUsername(newUserDTO.getUsername()).ifPresent(user -> {
                throw new Error("Username already exists");
            });

            UserDTO userDTO = this.userDetailsServiceImpl.insert(newUserDTO);
            URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(userDTO.getId())
                    .toUri();
            return ResponseEntity.created(uri).body(userDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.userDetailsServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }

}
