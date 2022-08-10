package com.notifications.services.Impl;

import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notifications.entity.EmailTemplate;
import com.notifications.enums.ErrorCode;
import com.notifications.exception.DCException;
import com.notifications.serivices.EmailService;
import com.notifications.utility.ConstantsDC;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Nahid Sheikh
 * @since 24-Mar-2022
 *
 */
@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	/**
	 * send text email
	 * 
	 * @param emailTemplate
	 * @return
	 */
	@Override
	public EmailTemplate sendTextEmail(EmailTemplate emailTemplate) {

		SimpleMailMessage msg = new SimpleMailMessage();
		try {
			if (emailTemplate.getSendTo().contains(",")) {
				String[] emails = emailTemplate.getSendTo().split(",");
				int receipantSize = emails.length;
				for (int i = 0; i < receipantSize; i++) {

					msg.setTo(emails[i]);
					msg.setSubject(emailTemplate.getSubject());
					msg.setText(emailTemplate.getBody());
					log.info("Sending Simple Text Email....");
					javaMailSender.send(msg);
					log.info("Email sent....");

				}

			} else {
				msg.setTo(emailTemplate.getSendTo());
				msg.setSubject(emailTemplate.getSubject());
				msg.setText(emailTemplate.getBody());
				log.info("Sending Simple Text Email....");
				javaMailSender.send(msg);
				log.info("Email sent....");

			}
			return emailTemplate;
		}

		catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			throw new DCException(ErrorCode.INTERNAL_SERVER_ERROR, ConstantsDC.EMAIL_SEND_FAIL);
		}

	}

	/**
	 * send email with attachment
	 * 
	 * @param emailTemplate
	 * @return
	 */
	@Override
	public EmailTemplate sendEmailWithAttachment(MultipartFile multipartFile, String sendTo, String subject,
			String body) {

		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			if (sendTo.contains(",")) {
				String[] emails = sendTo.split(",");
				int receipantSize = emails.length;
				for (int i = 0; i < receipantSize; i++) {
					helper.setTo(emails[i]);
					helper.setSubject(subject);
					helper.setText(body, true);
					InputStreamSource attachment = new ByteArrayResource(multipartFile.getBytes());

					helper.addAttachment(multipartFile.getOriginalFilename(), attachment);
					log.info("Sending Attachment Email....");
					javaMailSender.send(msg);
					log.info("Email sent....");

				}

			} else {
				helper.setTo(sendTo);
				helper.setSubject(subject);
				helper.setText(body, true);
				InputStreamSource attachment = new ByteArrayResource(multipartFile.getBytes());
				helper.addAttachment(multipartFile.getOriginalFilename(), attachment);
				log.info("Sending Attachment Email....");
				javaMailSender.send(msg);
				log.info("Email sent....");

			}
			EmailTemplate emailTemplate = new EmailTemplate();
			emailTemplate.setSendTo(sendTo);
			emailTemplate.setSubject(subject);
			emailTemplate.setBody(body);
			return emailTemplate;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			throw new DCException(ErrorCode.INTERNAL_SERVER_ERROR, ConstantsDC.EMAIL_SEND_FAIL);

		}

	}

	/**
	 * Convert string to json object
	 * 
	 * @param emailTemplate
	 * @return
	 */
	@Override
	public EmailTemplate getJson(String emailTemplate) {
		EmailTemplate userJson = new EmailTemplate();

		try {
			log.info("Converting string into json object....");
			ObjectMapper objectMapper = new ObjectMapper();
			userJson = objectMapper.readValue(emailTemplate, EmailTemplate.class);
			log.info("Converted string into json object....");
			return userJson;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			throw new DCException(ErrorCode.INTERNAL_SERVER_ERROR, ConstantsDC.EMAIL_SEND_FAIL);
		}

	}
}
