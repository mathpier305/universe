package com.matt.utils;

public enum NotificationMessages {
	STUDENT_SAVE_VALIDATION_ERROR_TITLE("ERROR"),
	STUDENT_SAVE_VALIDATION_ERROR_DESCRIPTION("Fields must be filled")
	;
	
	private String string;
	
	private NotificationMessages(String string) {
		this.string= string;
	}
	
	public String getString() {
		return this.string;
	}

}
