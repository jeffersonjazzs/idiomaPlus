package com.jeff.puc.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jeff.puc.dto.ContactDTO;
import com.jeff.puc.services.impl.ContactService;

import javax.mail.MessagingException;
import java.net.URI;


@RestController
@RequestMapping(value = "/contacts")
public class ContactResource {
    private final ContactService ContactService;

    public ContactResource(ContactService ContactService) {
        this.ContactService = ContactService;
    }

    @GetMapping
    public ResponseEntity<Page<ContactDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(this.ContactService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.ContactService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDTO> update(@PathVariable Long id, @RequestBody ContactDTO ContactDTO) {
        return ResponseEntity.accepted().body(this.ContactService.update(id, ContactDTO));
    }

    @PostMapping
    public ResponseEntity<ContactDTO> insert(@RequestBody ContactDTO newContactDTO) throws MessagingException {
        ContactDTO contactDTO = this.ContactService.insert(newContactDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(contactDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(contactDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.ContactService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
