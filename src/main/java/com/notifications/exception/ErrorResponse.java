package com.notifications.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Nahid Sheikh
 * @since 24-Mar-2022
 *
 */
@Getter
@Setter
public class ErrorResponse {
	private int errorCode;

	private String message;

	private Boolean success;

	private Object errorData;

}
