package com.notifications.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Nahid Sheikh
 * @since 24-Mar-2022
 *
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SmsAlertBody {
	@JsonProperty("message")
	private String message;
	private String phoneNumber;
}