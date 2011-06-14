/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.facebook.api;

import java.util.List;

import org.springframework.social.ApiException;
import org.springframework.social.InsufficientPermissionException;
import org.springframework.social.MissingCredentialsException;

/**
 * Interface defining operations that can be performed on a Facebook feed.
 * @author Craig Walls
 */
public interface FeedOperations {

	/**
	 * Retrieves recent feed entries for the authenticated user.
	 * Requires "read_stream" permission to read non-public posts. 
	 * Returns up to 50 entries or 30 days worth of entries, whichever is greatest.
	 * @return a list of {@link Post}s for the authenticated user. 
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	List<Post> getFeed();

	/**
	 * Retrieves recent feed entries for a given user. 
	 * Requires "read_stream" permission to read non-public posts. 
	 * Returns up to 50 entries or 30 days worth of entries, whichever is greatest.
	 * @param ownerId the Facebook ID or alias for the owner (user, group, event, page, etc) of the feed.
	 * @return a list of {@link Post}s for the specified user. 
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	List<Post> getFeed(String ownerId);

	/**
	 * Retrieves the user's home feed. This includes entries from the user's friends.
	 * Requires "read_stream" permission. 
	 * @return a list of {@link Post}s from the authenticated user's home feed.
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws InsufficientPermissionException if the user has not granted "read_stream" permission.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	List<Post> getHomeFeed();

	/**
	 * Retrieves a single feed entry.
	 * @param entryId the entry ID
	 * @return the requested {@link Post}
	 * @throws ApiException if there is an error while communicating with Facebook.
	 */
	Post getFeedEntry(String entryId);
	
	/**
	 * Retrieves the status entries from the authenticated user's feed.
	 * @return a list of status {@link Post}s. 
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	List<StatusPost> getStatuses();
	
	/**
	 * Retrieves the status entries from the specified user's feed.
	 * Requires "read_stream" permission. 
	 * @param userId the user's ID
	 * @return a list of status {@link Post}s. 
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws InsufficientPermissionException if the user has not granted "read_stream" permission.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	List<StatusPost> getStatuses(String userId);
	
	/**
	 * Retrieves the link entries from the authenticated user's feed.
	 * Requires "read_stream" permission. 
	 * @return a list of link {@link Post}s. 
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws InsufficientPermissionException if the user has not granted "read_stream" permission.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	List<LinkPost> getLinks();
	
	/**
	 * Retrieves the link entries from the specified owner's feed.
	 * Requires "read_stream" permission. 
	 * @param ownerId the owner of the feed (could be a user, page, event, etc)
	 * @return a list of link {@link Post}s. 
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws InsufficientPermissionException if the user has not granted "read_stream" permission.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	List<LinkPost> getLinks(String ownerId);
	
	/**
	 * Retrieves the note entries from the authenticated user's feed.
	 * Requires "read_stream" permission. 
	 * @return a list of note {@link Post}s. 
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws InsufficientPermissionException if the user has not granted "read_stream" permission.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	List<NotePost> getNotes();
	
	/**
	 * Retrieves the note entries from the specified owner's feed.
	 * Requires "read_stream" permission. 
	 * @param ownerId the owner of the feed (could be a user, page, event, etc)
	 * @return a list of note {@link Post}s. 
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws InsufficientPermissionException if the user has not granted "read_stream" permission.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	List<NotePost> getNotes(String ownerId);
	
	/**
	 * Retrieves the post entries from the authenticated user's feed.
	 * Requires "read_stream" permission. 
	 * @return a list of post {@link Post}s. 
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws InsufficientPermissionException if the user has not granted "read_stream" permission.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	List<Post> getPosts();
	
	/**
	 * Retrieves the post entries from the specified owner's feed.
	 * Requires "read_stream" permission. 
	 * @param ownerId the owner of the feed (could be a user, page, event, etc)
	 * @return a list of post {@link Post}s. 
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws InsufficientPermissionException if the user has not granted "read_stream" permission.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	List<Post> getPosts(String ownerId);
	
	/**
	 * Posts a status update to the authenticated user's feed.
	 * Requires "publish_stream" permission.
	 * @param message the message to post.
	 * @return the ID of the new feed entry.
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws InsufficientPermissionException if the user has not granted "publish_stream" permission.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	String updateStatus(String message);

	/**
	 * Posts a link to the authenticated user's feed.
	 * Requires "publish_stream" permission.
	 * @param message a message to send with the link.
	 * @return the ID of the new feed entry.
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws InsufficientPermissionException if the user has not granted "publish_stream" permission.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	String postLink(String message, FacebookLink link);

	/**
	 * Posts a message to a feed.
	 * Requires "publish_stream" permission.
	 * @param ownerId the feed owner ID. Could be a user ID or a page ID.
	 * @param message the message to post.
	 * @return the id of the new feed entry.
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws InsufficientPermissionException if the user has not granted "publish_stream" permission.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	String post(String ownerId, String message);
	
	/**
	 * Posts a link to a feed.
	 * Requires "publish_stream" permission.
	 * @param ownerId the feed owner ID. Could be a user ID or a page ID.
	 * @param message a message to send with the link.
	 * @return the ID of the new feed entry.
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws InsufficientPermissionException if the user has not granted "publish_stream" permission.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	String postLink(String ownerId, String message, FacebookLink link);

	/**
	 * Deletes a feed entry
	 * Requires "publish_stream" permission.
	 * @param id the feed entry ID
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws InsufficientPermissionException if the user has not granted "publish_stream" permission.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	void deleteFeedEntry(String id);

	/**
	 * Searches Facebook's public feed.
	 * @param query the search query (e.g., "Dr Seuss")
	 * @return a list of {@link Post}s that match the search query
	 * @throws ApiException if there is an error while communicating with Facebook.
	 */
	List<Post> searchPublicFeed(String query);

	/**
	 * Searches the authenticated user's home feed.
	 * @param query the search query (e.g., "Dr Seuss")
	 * @return a list of {@link Post}s that match the search query
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	List<Post> searchHomeFeed(String query);
	
	/**
	 * Searches the authenticated user's feed.
	 * @param query the search query (e.g., "football")
	 * @return a list of {@link Post}s that match the search query
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	List<Post> searchUserFeed(String query);
	
	/**
	 * Searches a specified user's feed.
	 * @param userId the ID of the user whose feed is to be searched
	 * @param query the search query (e.g., "football")
	 * @return a list of {@link Post}s that match the search query
	 * @throws ApiException if there is an error while communicating with Facebook.
	 * @throws MissingCredentialsException if FacebookTemplate was not created with an access token.
	 */
	List<Post> searchUserFeed(String userId, String query);
	
}
