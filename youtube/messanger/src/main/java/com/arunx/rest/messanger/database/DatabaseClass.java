package com.arunx.rest.messanger.database;

import java.util.HashMap;
import java.util.Map;

import com.arunx.rest.messanger.model.Message;
import com.arunx.rest.messanger.model.Profile;

public class DatabaseClass {
	private static Map<Long, Message> message = new HashMap<>();
	private static Map<String, Profile> profile = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return message;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profile;
	}

}
