package com.notifications.serivices;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.notifications.entity.EmailTemplate;

/**
 * @author Nahid Sheikh
 * @since 24-Mar-2022
 *
 */
@Service
public interface EmailService {

	/**
	 * @param emailTemplate
	 * @return
	 */
	public EmailTemplate sendTextEmail(EmailTemplate emailTemplate);

	/**
	 * @param multipartFile
	 * @param sendTo
	 * @param subject
	 * @param body
	 * @return
	 */
	public EmailTemplate sendEmailWithAttachment(MultipartFile multipartFile, String sendTo, String subject,
			String body);

	/**
	 * @param emailTemplate
	 * @return
	 */
	public EmailTemplate getJson(String emailTemplate);
}
