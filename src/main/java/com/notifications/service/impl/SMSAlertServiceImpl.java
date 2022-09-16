package com.notifications.service.impl;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.notifications.entity.SmsAlertBody;
import com.notifications.enums.ErrorCode;
import com.notifications.exception.DCException;
import com.notifications.service.SMSAlertService;
import com.notifications.utility.ConstantsDC;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 * @author Nahid Sheikh
 * @since 24-Mar-2022
 *
 */
@Service
public class SMSAlertServiceImpl implements SMSAlertService {
	private static final Logger log = LoggerFactory.getLogger(SMSAlertServiceImpl.class);

	@Value("${twilio.phone-number}")
	private String twilioPhoneNumber;

	@Override
	public SmsAlertBody sendAlertSms(SmsAlertBody smsAlertBody) {
		try {
			log.info(" Sending SMS ");
			Message.creator(new PhoneNumber(smsAlertBody.getPhoneNumber()), new PhoneNumber(twilioPhoneNumber),
					smsAlertBody.getMessage()).create();
			log.info("SMS Sent....");
			return smsAlertBody;
		} catch (Exception e) {
			log.error(ExceptionUtils.getStackTrace(e));
			throw new DCException(ErrorCode.INTERNAL_SERVER_ERROR, ConstantsDC.SMS_SEND_FAIL);

		}

	}

}
