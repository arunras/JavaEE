package com.arunx.rest.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.arunx.rest.messanger.database.DatabaseClass;
import com.arunx.rest.messanger.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("arun", new Profile(1L, "arun", "Arun", "Rasmey"));
	}
	
	public List<Profile> getAllProfiiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) return null;
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
}
