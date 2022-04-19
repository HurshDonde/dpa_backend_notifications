package com.notifications.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

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
public class EmailTemplate {
	@Email
	@NotBlank
	private String sendTo;
	@Max(value = 100)
	private String subject;
	@Max(value = 500)
	private String body;

}
