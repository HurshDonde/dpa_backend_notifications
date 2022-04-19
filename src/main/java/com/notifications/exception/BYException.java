package com.notifications.exception;

/**
 * @author Nahid Sheikh
 * @since 24-Mar-2022
 *
 */
import com.notifications.enums.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BYException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ErrorCode errorCode;
	String errorMsg;

}
