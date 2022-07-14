package com.notifications.serivices;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessagingException;

@Service
public interface PushNotificationService {
	public void sendNotification(String userId) throws FirebaseMessagingException;

}
