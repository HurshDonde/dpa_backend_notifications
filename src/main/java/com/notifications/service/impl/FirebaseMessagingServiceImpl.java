package com.notifications.service.impl;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.notifications.entity.Note;
import com.notifications.enums.ErrorCode;
import com.notifications.exception.DCException;
import com.notifications.request.dto.SubscriptionRequestDto;
import com.notifications.request.dto.TopicNotificationRequestDto;
import com.notifications.service.FirebaseMessagingService;
import com.notifications.utility.ConstantsDC;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Nahid Sheikh
 * @since 21-July-2022
 *
 */
@Slf4j
@Service
public class FirebaseMessagingServiceImpl implements FirebaseMessagingService {

	@Autowired
	private FirebaseMessaging firebaseMessaging;

	/**
	 * send firebase push notification
	 * 
	 * @param note
	 * @param token
	 * @return
	 */
	@Override
	public String sendNotification(Note note, String token) throws FirebaseMessagingException {
		try {
			Notification notification = Notification.builder().setTitle(note.getSubject()).setBody(note.getContent())
					.build();
			Message message = Message.builder().setToken(token).setNotification(notification).putAllData(note.getData())
					.build();
			return firebaseMessaging.send(message);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			throw new DCException(ErrorCode.INTERNAL_SERVER_ERROR, ConstantsDC.PUSH_NOTIFICATION_SEND_FAIL);
		}
	}

	@Override
	public String sendTopicNotification(TopicNotificationRequestDto request) throws FirebaseMessagingException {
		try {
			Notification notification = Notification.builder().setTitle(request.getTitle())
					.setBody(request.getMessage()).build();
			Message message = Message.builder().setTopic(request.getTopic()).setNotification(notification).build();
			return firebaseMessaging.send(message);
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			throw new DCException(ErrorCode.INTERNAL_SERVER_ERROR, ConstantsDC.PUSH_NOTIFICATION_SEND_FAIL);
		}
	}

	@Override
	public boolean subscribeToTopic(SubscriptionRequestDto request) throws FirebaseMessagingException {
		try {
			firebaseMessaging.subscribeToTopic(List.of(request.getSubscriber()), request.getTopic());
			return true;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			throw new DCException(ErrorCode.INTERNAL_SERVER_ERROR, ConstantsDC.TOPIC_SUBSCRIBED_FAIL);
		}
	}

}
