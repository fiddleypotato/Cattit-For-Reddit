package ml.docilealligator.infinityforreddit.Utils;

import android.util.Base64;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by alex on 2/23/18.
 */

public class RedditUtils {
    public static final String OAUTH_URL = "https://www.reddit.com/api/v1/authorize.compact";
    public static final String OAUTH_API_BASE_URI = "https://oauth.reddit.com";
    public static final String API_BASE_URI = "https://www.reddit.com";
    public static final String API_UPLOAD_MEDIA_URI = "https://reddit-uploaded-media.s3-accelerate.amazonaws.com";
    public static final String API_UPLOAD_VIDEO_URI = "https://reddit-uploaded-video.s3-accelerate.amazonaws.com";

    public static final String CLIENT_ID_KEY = "client_id";
    public static final String CLIENT_ID = "";
    public static final String RESPONSE_TYPE_KEY = "response_type";
    public static final String RESPONSE_TYPE = "code";
    public static final String STATE_KEY = "state";
    public static final String STATE = "";
    public static final String REDIRECT_URI_KEY = "redirect_uri";
    public static final String REDIRECT_URI = "";
    public static final String DURATION_KEY = "duration";
    public static final String DURATION = "permanent";
    public static final String SCOPE_KEY = "scope";
    public static final String SCOPE = "identity edit flair history modconfig modflair modlog modposts modwiki mysubreddits privatemessages read report save submit subscribe vote wikiedit wikiread";
    public static final String ACCESS_TOKEN_KEY = "access_token";

    public static final String AUTHORIZATION_KEY = "Authorization";
    public static final String AUTHORIZATION_BASE = "bearer ";
    public static final String USER_AGENT_KEY = "User-Agent";
    public static final String USER_AGENT = "";

    public static final String GRANT_TYPE_KEY = "grant_type";
    public static final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";
    public static final String REFRESH_TOKEN_KEY = "refresh_token";

    public static final String DIR_KEY = "dir";
    public static final String ID_KEY = "id";
    public static final String RANK_KEY = "rank";
    public static final String DIR_UPVOTE = "1";
    public static final String DIR_UNVOTE = "0";
    public static final String DIR_DOWNVOTE = "-1";
    public static final String RANK = "10";

    public static final String ACTION_KEY = "action";
    public static final String SR_NAME_KEY = "sr_name";

    public static final String API_TYPE_KEY = "api_type";
    public static final String API_TYPE_JSON = "json";
    public static final String RETURN_RTJSON_KEY = "return_rtjson";
    public static final String TEXT_KEY = "text";
    public static final String URL_KEY = "url";
    public static final String VIDEO_POSTER_URL_KEY = "video_poster_url";
    public static final String THING_ID_KEY = "thing_id";

    public static final String SR_KEY = "sr";
    public static final String TITLE_KEY = "title";
    public static final String FLAIR_TEXT_KEY = "flair_text";
    public static final String SPOILER_KEY = "spoiler";
    public static final String NSFW_KEY = "nsfw";
    public static final String KIND_KEY = "kind";
    public static final String KIND_SELF = "self";
    public static final String KIND_LINK = "link";
    public static final String KIND_IMAGE = "image";
    public static final String KIND_VIDEO = "video";
    public static final String KIND_VIDEOGIF = "videogif";

    public static final String FILEPATH_KEY = "filepath";
    public static final String MIMETYPE_KEY = "mimetype";

    public static final String LINK_KEY = "link";
    public static final String FLAIR_TEMPLATE_ID_KEY = "flair_template_id";

    public static final String MAKE_FAVORITE_KEY = "make_favorite";

    public static final String MULTIPATH_KEY = "multipath";
    public static final String MODEL_KEY = "model";

    public static Map<String, String> getHttpBasicAuthHeader() {
        Map<String, String> params = new HashMap<>();
        String credentials = String.format("%s:%s", RedditUtils.CLIENT_ID, "");
        String auth = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
        params.put(RedditUtils.AUTHORIZATION_KEY, auth);
        return params;
    }

    public static Map<String, String> getOAuthHeader(String accessToken) {
        Map<String, String> params = new HashMap<>();
        params.put(RedditUtils.AUTHORIZATION_KEY, RedditUtils.AUTHORIZATION_BASE + accessToken);
        params.put(RedditUtils.USER_AGENT_KEY, RedditUtils.USER_AGENT);
        return params;
    }

    public static RequestBody getRequestBody(String s) {
        return RequestBody.create(MediaType.parse("text/plain"), s);
    }
}
