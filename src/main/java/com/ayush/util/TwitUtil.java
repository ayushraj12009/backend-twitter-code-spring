package com.ayush.util;

import com.ayush.model.Like;
import com.ayush.model.Twit;
import com.ayush.model.User;

public class TwitUtil {
	
	public final static boolean isLikedByReqUser(User reqUser, Twit twit) {
		for(Like like:twit.getLikes()) {
			if(like.getUser().getId().equals(reqUser.getId())) {
				return true;
			}
		
		}
		return false;
	}

	public final static boolean  isRetwitedByReqUser(User reqUser, Twit twit) {
		for(User user: twit.getRetwitUser()) {
		if(user.getId().equals(reqUser.getId())) {
			return true;
		}
		}
		return false;
	}
}
