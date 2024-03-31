package com.jeff.puc.services.impl;

import javax.mail.MessagingException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jeff.puc.dto.ContactDTO;
import com.jeff.puc.email.SendEmailService;
import com.jeff.puc.messages.EmailMessages;
import com.jeff.puc.repositories.ContactRepository;
import com.jeff.puc.services.Util;
import com.jeff.puc.domain.Contact;

@Service
public class ContactService {
	private final ContactRepository contactRepository;
	private final SendEmailService sendEmailService;

	public SendEmailService getSendEmailService() {
		return sendEmailService;
	}

	public ContactService(ContactRepository contactRepository, SendEmailService sendEmailService) {
		this.contactRepository = contactRepository;
		this.sendEmailService = sendEmailService;
	}

	@Transactional(rollbackFor = Exception.class)
	public ContactDTO insert(ContactDTO newContactDTO) throws MessagingException {
		Contact model = new Contact(newContactDTO);
		model = this.contactRepository.save(model);
		newContactDTO.setId(model.getId());
		try {
			this.getSendEmailService().enviarEmailComAnexo(newContactDTO.getEmail(),
					EmailMessages.createTitleContact(newContactDTO), EmailMessages.dadosContact(newContactDTO),
					"/logo/logo-white.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newContactDTO;
	}

	@Transactional(readOnly = true)
	public Page<ContactDTO> findAll(Pageable pageable) {
		return this.contactRepository.findAll(pageable).map(ContactDTO::new);
	}

	@Transactional(readOnly = true)
	public ContactDTO findById(Long id) {
		return new ContactDTO(this.findModel(id));
	}

	@Transactional(rollbackFor = Exception.class)
	public ContactDTO update(Long id, ContactDTO contactDTO) {
		ContactDTO fromDatabase = this.findById(id);
		Util.myCopyProperties(contactDTO, fromDatabase);
		this.contactRepository.save(new Contact(fromDatabase));
		return contactDTO;
	}

	@Transactional(rollbackFor = Exception.class)
	public void delete(Long id) {
		this.contactRepository.delete(this.findModel(id));
	}

	protected Contact findModel(Long id) {
		return this.contactRepository.findById(id).orElseThrow(() -> new RuntimeException("not found"));
	}
}
