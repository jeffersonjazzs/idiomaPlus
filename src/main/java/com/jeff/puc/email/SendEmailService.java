package com.jeff.puc.email;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
@Slf4j
public class SendEmailService {
	@Value("${default.sender}")
	private String sender;
	private final JavaMailSender envioEmailDoJava;

	public SendEmailService(final JavaMailSender javaMailSender) {
		this.envioEmailDoJava = javaMailSender;
	}

	public void enviarEmailComAnexo(String para, String titulo, String conteudo, String logo)
			throws MessagingException {
		log.info("Enviando E-mail com anexo");
		var mensagem = envioEmailDoJava.createMimeMessage();
		var helper = new MimeMessageHelper(mensagem, true);
		helper.setFrom(sender);
		helper.setTo(para);
		helper.setSubject(titulo);
		helper.setText(conteudo, true);
		helper.addAttachment("Logogrande.jpg", new ClassPathResource(logo));
		envioEmailDoJava.send(mensagem);
		log.info("Email com anexo enviado com sucesso");
	}
}
