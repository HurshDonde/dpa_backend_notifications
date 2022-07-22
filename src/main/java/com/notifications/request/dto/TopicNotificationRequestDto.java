package com.notifications.request.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class TopicNotificationRequestDto {

	private String topic;

	private String title;

	private String message;

}
