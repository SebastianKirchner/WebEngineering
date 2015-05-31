package twitter;

import twitter4j.Twitter;
import twitter4j.auth.AccessToken;
import twitter4j.Status;
import twitter4j.TwitterFactory;

/**
 * Interface for Twitter clients
 * @author pl
 *
 */
public class TwitterClientImpl implements ITwitterClient {
	public void publishUuid(TwitterStatusMessage message) throws Exception {

        		TwitterFactory twitterFactory = new TwitterFactory();
        		Twitter twitter = twitterFactory.getInstance();
        		AccessToken accessToken = new AccessToken(message.getAccessToken(), message.getAccessTokenSecret());
        		twitter.setOAuthConsumer(message.getConsumerKey(), message.getConsumerSecret());
        		twitter.setOAuthAccessToken(accessToken);

        		//try to post to twitter:
        		Status status = twitter.updateStatus(message.getTwitterPublicationString());

	}
}
