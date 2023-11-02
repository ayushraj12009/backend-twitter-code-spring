package com.ayush.service;

import java.util.List;

import com.ayush.exception.TwitException;
import com.ayush.exception.UserException;
import com.ayush.model.Like;
import com.ayush.model.User;

public interface LikeService {
	public Like likeTwit(Long twitId, User user) throws UserException, TwitException;
	
	public List<Like> getAllLikes(Long twitId) throws TwitException;
	

}
