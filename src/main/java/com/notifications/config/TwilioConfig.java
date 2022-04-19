package com.notifications.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.twilio.Twilio;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Nahid Sheikh
 * @since 18-Mar-2022
 *
 */
@Setter
@Getter
@Configuration
@PropertySource("classpath:application-notications.properties")
public class TwilioConfig {
	@Value("${twilio.account-sid}")
	private String twilioAccountSid;

	@Value("${twilio.auth-token}")
	private String twilioAuthToken;

	@PostConstruct
	public void init() {
		Twilio.init(getTwilioAccountSid(), getTwilioAuthToken());
	}

}
