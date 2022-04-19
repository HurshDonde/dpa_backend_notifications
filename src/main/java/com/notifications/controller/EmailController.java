package com.notifications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.notifications.entity.EmailTemplate;
import com.notifications.serivices.EmailService;
import com.notifications.utility.ConstantsDC;
import com.notifications.utility.DentalClinicsResponse;
import com.notifications.utility.ResponseHelper;

/**
 * @author Nahid Sheikh
 * @since 24-Mar-2022
 *
 */
@RestController
@RequestMapping("/v1/api/notification")
public class EmailController {

	@Autowired
	private EmailService emailService;

	/**
	 * <b>sendEmail</b> - By calling this API , you can send text email
	 * 
	 * @param userEmail
	 * @return - generic response
	 */
	@PostMapping(value = "/textemail", consumes = "application/json", produces = "application/json")
	public DentalClinicsResponse<EmailTemplate> sendEmail(@RequestBody EmailTemplate emailTemplate) {
		EmailTemplate response = emailService.sendTextEmail(emailTemplate);
		return ResponseHelper.createResponse(new DentalClinicsResponse<EmailTemplate>(), response,
				ConstantsDC.EMAIL_SEND_SUCCESS, ConstantsDC.EMAIL_SEND_FAIL);
	}

	/**
	 * <b>sendEmailWithAttachment</b> - By calling this API , you can send email
	 * with attachment
	 * 
	 * @param userEmail
	 * @return - generic response
	 */
	@PostMapping(value = "/attachemail", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE,
			MediaType.APPLICATION_JSON_VALUE })

	public DentalClinicsResponse<EmailTemplate> sendEmailWithAttachment(@RequestPart(value = "file") MultipartFile file,
			@RequestParam("sendTo") String sendTo, @RequestParam("subject") String subject,
			@RequestParam("body") String body) {

		EmailTemplate response = emailService.sendEmailWithAttachment(file, sendTo, subject, body);
		return ResponseHelper.createResponse(new DentalClinicsResponse<EmailTemplate>(), response,
				ConstantsDC.EMAIL_SEND_SUCCESS, ConstantsDC.EMAIL_SEND_FAIL);

	}

}
