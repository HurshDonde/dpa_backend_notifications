package com.notifications.utility;

import com.notifications.enums.ErrorCode;
import com.notifications.exception.DCException;

/**
 * @author Nahid Sheikh
 * @since 24-Mar-2022
 *
 */
public class ResponseHelper {
	public static DentalClinicsResponse createResponse(DentalClinicsResponse response, Object data,
			String successMessage, String errorMessage) {
		if (data != null) {
			response.setSuccess(true);
			response.setData(data);
			response.setMessage(successMessage);
		} else {
			throw new DCException(ErrorCode.INTERNAL_SERVER_ERROR, errorMessage);
		}
		return response;
	}

}
