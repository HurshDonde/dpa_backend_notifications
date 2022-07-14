package com.notifications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.notifications.serivices.PushNotificationService;
import com.notifications.utility.ConstantsDC;
import com.notifications.utility.DentalClinicsResponse;
import com.notifications.utility.ResponseHelper;

/**
 * @author Arnie Bertino
 * @since 08-Jun-2022
 *
 */
@RestController
@RequestMapping("/v1/api/notification")
public class PushNotificationController {

	@Autowired
	private PushNotificationService pushNotificationService;

	/**
	 * <b>sendSms</b> - By calling this API , you can send push
	 * 
	 * @param
	 * @return
	 */
	@PostMapping("/push{userId}")
	public DentalClinicsResponse<String> sendPushNotification(@PathVariable String userId)
			throws FirebaseMessagingException {
		pushNotificationService.sendNotification(userId);
		String response = "Notification or  " + userId + " has been send succesfully!";
		return ResponseHelper.createResponse(new DentalClinicsResponse<String>(), response,
				ConstantsDC.SMS_SEND_SUCCESS, ConstantsDC.SMS_SEND_FAIL);

	}
}
