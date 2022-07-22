package com.notifications.request.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SubscriptionRequestDto {

	private String subscriber;

	private String topic;
}
