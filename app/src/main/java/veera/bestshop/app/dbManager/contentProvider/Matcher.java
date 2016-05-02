package veera.bestshop.app.dbManager.contentProvider;

import android.content.UriMatcher;
import android.net.Uri;

/**
 * Created by MohdNoufil on 26/10/15.
 */
public class Matcher {
    private final static UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
//        uriMatcher.addURI(CONTENT_AUTHORITY, PATH_EVENT_LIST, EVENT_LIST);
//        uriMatcher.addURI(CONTENT_AUTHORITY, PATH_EVENT_INFO, EVENT_INFO);
//        uriMatcher.addURI(CONTENT_AUTHORITY, PATH_HISTORY_LIST, HISTORY_LIST);
//        uriMatcher.addURI(CONTENT_AUTHORITY, PATH_REFERRAL_LEADS, REFERRAL_LEADS);
    }

    public static synchronized String getTable(Uri uri) {
        switch (uriMatcher.match(uri)) {
//            case EVENT_LIST:
//                return EVENT_LIST_TABLE;
//            case HISTORY_LIST:
//                return HISTORY_LIST_TABLE;
//            case EVENT_INFO:
//                return EVENT_INFO_TABLE;
//            case REFERRAL_LEADS:
//                return REFERRAL_LEADS_TABLE;
        }
        return null;
    }
}
