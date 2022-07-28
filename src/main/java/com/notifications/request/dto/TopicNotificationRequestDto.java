package com.notifications.request.dto;

import javax.validation.constraints.NotBlank;

import com.notifications.utility.ConstantsDC;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Nahid Sheikh
 * @since 22-July-2022
 *
 */
@Setter
@Getter
@ToString
public class TopicNotificationRequestDto {

	@NotBlank(message = ConstantsDC.MANDOTORY_FIELD)
	private String topic;

	@NotBlank(message = ConstantsDC.MANDOTORY_FIELD)
	private String title;

	@NotBlank(message = ConstantsDC.MANDOTORY_FIELD)
	private String message;

}
