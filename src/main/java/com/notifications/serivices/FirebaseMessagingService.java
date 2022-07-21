package com.notifications.serivices;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.notifications.entity.Note;

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

}
