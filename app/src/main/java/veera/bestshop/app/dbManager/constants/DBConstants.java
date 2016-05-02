package veera.bestshop.app.dbManager.constants;

import android.content.ContentUris;
import android.net.Uri;

/**
 * Created by MohdNoufil on 26/10/15.
 */
public class DBConstants {
    public static final String CONTENT_AUTHORITY = "haygot.toppr.crm";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final int CRM_DB_VERSION = 3;
    public static final String TOPPR_CRM_DB = "shopit.db";


    public static final String QUERY_PARAMETER_LIMIT = "LIMIT";
    public static final String QUERY_PARAMETER_GROUP_BY = "GROUP_BY";
    public static final String NOTIFY_URI = "notify_uri";

    public static Uri buildIdForInsert(long id) {
        return ContentUris.withAppendedId(BASE_CONTENT_URI, id);
    }

    public static final int EVENT_LIST = 1;
    public static final int HISTORY_LIST = EVENT_LIST + 1;
    public static final int EVENT_INFO = HISTORY_LIST + 1;
    public static final int REFERRAL_LEADS = EVENT_INFO + 1;
}
