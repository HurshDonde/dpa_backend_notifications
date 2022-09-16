package com.notifications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.notifications.entity.Note;
import com.notifications.request.dto.SubscriptionRequestDto;
import com.notifications.request.dto.TopicNotificationRequestDto;
import com.notifications.service.FirebaseMessagingService;
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
public class FireBasePushNotificationController {

	@Autowired
	private FirebaseMessagingService firebaseService;

	/**
	 * <b>sendPushNotification</b> - By calling this API , you can send firebase
	 * push notification
	 * 
	 * @param note
	 * @param token
	 * @return - generic response
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/token/push-notification")
	public DentalClinicsResponse<String> sendPushNotification(@RequestBody Note note, @RequestParam String token)
			throws FirebaseMessagingException {
		String response = firebaseService.sendNotification(note, token);
		return ResponseHelper.createResponse(new DentalClinicsResponse<String>(), response,
				ConstantsDC.PUSH_NOTIFICATION_SEND_SUCCESSFULLY, ConstantsDC.PUSH_NOTIFICATION_SEND_FAIL);

	}

	@SuppressWarnings("unchecked")
	@PostMapping("/topic/subscription")
	public DentalClinicsResponse<Boolean> subscribeToTopic(@RequestBody SubscriptionRequestDto request)
			throws FirebaseMessagingException {
		boolean response = firebaseService.subscribeToTopic(request);
		return ResponseHelper.createResponse(new DentalClinicsResponse<Boolean>(), response,
				ConstantsDC.TOPIC_SUBSCRIBED_SUCCESS, ConstantsDC.TOPIC_SUBSCRIBED_FAIL);

	}

	@SuppressWarnings("unchecked")
	@PostMapping("/topic/push-notification")
	public DentalClinicsResponse<String> sendTopicNotification(@RequestBody TopicNotificationRequestDto request)
			throws FirebaseMessagingException {
		String response = firebaseService.sendTopicNotification(request);
		return ResponseHelper.createResponse(new DentalClinicsResponse<String>(), response,
				ConstantsDC.PUSH_NOTIFICATION_SEND_SUCCESSFULLY, ConstantsDC.PUSH_NOTIFICATION_SEND_FAIL);
	}
}
