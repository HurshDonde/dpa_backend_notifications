package com.notifications.service;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.notifications.entity.Note;
import com.notifications.request.dto.SubscriptionRequestDto;
import com.notifications.request.dto.TopicNotificationRequestDto;

/**
 * @author Nahid Sheikh
 * @since 21-July-2022
 *
 */
@Service
public interface FirebaseMessagingService {

	/**
	 * @param note
	 * @param token
	 * @return
	 * @throws FirebaseMessagingException
	 */
	public String sendNotification(Note note, String token) throws FirebaseMessagingException;

	/**
	 * @param request
	 * @return
	 * @throws FirebaseMessagingException
	 */
	public boolean subscribeToTopic(SubscriptionRequestDto request) throws FirebaseMessagingException;

	/**
	 * @param request
	 * @return
	 * @throws FirebaseMessagingException
	 */
	public String sendTopicNotification(TopicNotificationRequestDto request) throws FirebaseMessagingException;

}
