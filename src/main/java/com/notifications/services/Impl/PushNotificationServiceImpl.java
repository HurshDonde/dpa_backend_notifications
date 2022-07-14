package com.notifications.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.notifications.helper.FirebaseNotificationHelper;
import com.notifications.serivices.PushNotificationService;

@Service
public class PushNotificationServiceImpl implements PushNotificationService {

	@Autowired
	FirebaseNotificationHelper notificationHelper;

	@Override
	public void sendNotification(String userId) throws FirebaseMessagingException {

		notificationHelper.sendNotification("Task Completed", "Your task is completed",
				"eqELrGLgW1HylgR-37mInW:APA91bFjmAxnQPEYbkdb38NyWcr5hlp4PPKys1HWDoHPAWQ-W6MIa7z3ySxokpVhe96gaBcnKB1S-7jQM9v6ab8KSE0gy7QGtGhPW8_JlAf_ISi3AC9lmerIo-ASXcvK_l9B8mm6-JIS");
	}
}