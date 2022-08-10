package com.notifications.exception;

import com.notifications.enums.ErrorCode;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Nahid Sheikh
 * @since 30-Mar-2022
 *
 */
@Getter
@Setter
public class DCException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Integer errorCode;

	private String message;

	public DCException(String message) {
		super(message);
		this.message = message;
	}

	public DCException(Integer error, String message) {
		super(message);
		this.errorCode = error;
		this.message = message;
	}

	public DCException(Integer error, Exception ex) {
		super(ex);
		this.errorCode = error;
		this.message = ex.getMessage();
	}

	public DCException(Exception ex) {
		super(ex);
		this.message = ex.getMessage();
	}

	public DCException(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode.getCode();
		this.message = message;
	}

}
