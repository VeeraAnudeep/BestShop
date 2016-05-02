package com.shopit.app.dbManager.contentProvider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.shopit.app.dbManager.constants.DBConstants;
import com.shopit.app.dbManager.dbHelper.DbHelper;

public class BaseProvider extends ContentProvider {

    private static final String TAG = BaseProvider.class.getSimpleName();
    private DbHelper dbHelper;
    private Context mContext;


    @Override
    public boolean onCreate() {
        mContext = getContext();
        dbHelper = new DbHelper(mContext);

        return true;
    }

    @Nullable
    @Override
    public synchronized Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String groupBy = uri.getQueryParameter(DBConstants.QUERY_PARAMETER_GROUP_BY);
        String limit = uri.getQueryParameter(DBConstants.QUERY_PARAMETER_LIMIT);
        String notifyUri = uri.getQueryParameter(DBConstants.NOTIFY_URI);
        Cursor cursor = dbHelper.query(Matcher.getTable(uri), projection, selection, selectionArgs, groupBy, null, sortOrder, limit);
        ContentResolver contentResolver = mContext.getContentResolver();
        cursor.setNotificationUri(contentResolver, uri);
        if (!TextUtils.isEmpty(notifyUri)) {
            contentResolver.notifyChange(Uri.parse(notifyUri), null);
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public synchronized Uri insert(Uri uri, ContentValues values) {
        long _id = dbHelper.insert(Matcher.getTable(uri), values);
        if (_id != -1L) {
            notifyURI(uri);
        }
        Uri returnUri = DBConstants.buildIdForInsert(_id);
        return returnUri;
    }

    @Override
    public synchronized int delete(Uri uri, String selection, String[] selectionArgs) {

        int rowsAffected = dbHelper.delete(Matcher.getTable(uri), selection, selectionArgs);
        if (rowsAffected != 0) {
            notifyURI(uri);
        }
        return rowsAffected;
    }

    @Override
    public synchronized int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int rowsAffected = dbHelper.update(Matcher.getTable(uri), values, selection, selectionArgs);
        if (rowsAffected != 0)
            notifyURI(uri);
        return rowsAffected;
    }

    @Override
    public synchronized int bulkInsert(Uri uri, ContentValues[] values) {
        int rowsCreated = dbHelper.bulkInsert(Matcher.getTable(uri), values);
        notifyURI(uri);
        return rowsCreated;
    }

    private void notifyURI(Uri uri) {
        String notifyUri = uri.getQueryParameter(DBConstants.NOTIFY_URI);
        if (TextUtils.isEmpty(notifyUri) || "true".equalsIgnoreCase(notifyUri)) {
            mContext.getContentResolver().notifyChange(uri, null);
        }
    }

}
