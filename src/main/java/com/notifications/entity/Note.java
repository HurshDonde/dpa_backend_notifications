package com.notifications.entity;

import lombok.Data;

import java.util.Map;

import javax.validation.constraints.NotBlank;

import com.google.firebase.database.annotations.NotNull;

@Data
public class Note {
	
	@NotBlank
	private String subject;
	
	@NotBlank
	private String content;
	
	@NotNull
	private Map<String, String> data;
//    private String image;
}
