package twitter;

import java.util.Date;
import twitter.TwitterException;
import twitter4j.Twitter;
import twitter4j.auth.AccessToken;
import twitter4j.Status;
import twitter4j.TwitterFactory;


/**
 * Wraps a status message to be pushed to Twitter
 * @author pl
 *
 */
public class TwitterStatusMessage {
	
	private String from;
	private String uuid;
	private Date dateTime;

	private String consumerKey = "GZ6tiy1XyB9W0P4xEJudQ";
	private String consumerSecret = "gaJDlW0vf7en46JwHAOkZsTHvtAiZ3QUd2mD1x26J9w";
	private String accessToken = "1366513208-MutXEbBMAVOwrbFmZtj1r4Ih2vcoHGHE2207002";
	private String accessTokenSecret = "RMPWOePlus3xtURWRVnv1TgrjTyK7Zk33evp4KKyA";
	
	public TwitterStatusMessage(String from, String uuid, Date dateTime) {
		if (from == null)
			throw new IllegalArgumentException("From must not be null.");
		
		if (uuid == null)
			throw new IllegalArgumentException("UUID must not be null");
		
		if (dateTime == null)
			throw new IllegalArgumentException("DateTime must not be null");
				
		this.from = from;
		this.uuid = uuid;
		this.dateTime = dateTime;
	}
	
	/**
	 * Return the string to be published on Twitter
	 * @return
	 */
	public String getTwitterPublicationString() {
		StringBuffer sb = new StringBuffer();
		sb.append(dateTime).append(": " );		
		sb.append("User ").append(from).append(" publizierte folgende UUID am Highscoreboard: ");
		sb.append(uuid);
		return sb.toString().trim();
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}

	public String getConsumerKey() {
		return consumerKey;
	}

	public String getConsumerSecret() {
		return consumerSecret;
	}
}
