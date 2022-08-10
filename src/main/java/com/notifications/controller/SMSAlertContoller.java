package com.notifications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notifications.entity.SmsAlertBody;
import com.notifications.serivices.SMSAlertService;
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
public class SMSAlertContoller {

	@Autowired
	private SMSAlertService sMSAlertService;

	/**
	 * <b>sendSms</b> - By calling this API , you can send sms
	 * 
	 * @param smsAlertBody
	 * @return - generic response
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/sms")
	public DentalClinicsResponse<SmsAlertBody> sendSms(@RequestBody SmsAlertBody smsAlertBody) {
		SmsAlertBody response = sMSAlertService.sendAlertSms(smsAlertBody);
		return ResponseHelper.createResponse(new DentalClinicsResponse<String>(), response,
				ConstantsDC.SMS_SEND_SUCCESS, ConstantsDC.SMS_SEND_FAIL);

	}
}
