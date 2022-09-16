package com.notifications.service;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.notifications.entity.SmsAlertBody;

/**
 * @author Nahid Sheikh
 * @since 24-Mar-2022
 *
 */
@Service
@PropertySource("classpath:application-notications.properties")
public interface SMSAlertService {

	public SmsAlertBody sendAlertSms(SmsAlertBody smsAlertBody);
}
