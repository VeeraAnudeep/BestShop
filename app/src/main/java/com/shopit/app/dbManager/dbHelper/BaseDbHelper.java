package com.shopit.app.dbManager.dbHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by MohdNoufil on 07/03/16.
 */
public abstract class BaseDbHelper extends SQLiteOpenHelper {
    protected Context mContext;
    protected SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();

    public BaseDbHelper(Context context, String dbName, int dbVersion) {
        super(context, dbName, null, dbVersion);
        mContext = context;
    }

    public Cursor query(String table, String[] projectionIn, String selection, String[] selectionArgs, String groupBy, String having, String sortOrder, String limit) {
        SQLiteDatabase db = getReadableDatabase();
        queryBuilder.setTables(table);
        return queryBuilder.query(db, projectionIn, selection, selectionArgs, groupBy, having, sortOrder, limit);
    }

    public long insert(String table, ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        return db.insertWithOnConflict(table, null, values, SQLiteDatabase.CONFLICT_REPLACE);
    }

    public int delete(String table, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(table, whereClause, whereArgs);
    }

    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = getWritableDatabase();
        return db.update(table, values, whereClause, whereArgs);
    }

    public int bulkInsert(String table, ContentValues[] values) {
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try {
            for (ContentValues contentValues : values) {
                long rowId = db.insertWithOnConflict(table, null, contentValues, SQLiteDatabase.CONFLICT_REPLACE);
                if (rowId <= 0) {
                    throw new SQLiteException("Failed to insert row into " + table);
                }
            }
            db.setTransactionSuccessful();
            return values.length;
        } finally {
            db.endTransaction();
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    protected static void copyDataBase(Context context, String dbName, int rawResId) throws IOException {
        InputStream inputStream = context.getResources().openRawResource(rawResId);
        File file = context.getDatabasePath(dbName);
        file.mkdirs();
        OutputStream fileOutputStream = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            fileOutputStream.write(buffer, 0, length);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        inputStream.close();
    }

}