package com.shopit.app.dbManager.dbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;

import com.shopit.app.BuildConfig;
import com.shopit.app.dbManager.constants.DBConstants;

/**
 * Created by MohdNoufil on 07/03/16.
 */
public class DbHelper extends BaseDbHelper {

    boolean isDbCreated;

    public DbHelper(Context context) {
        super(context, DBConstants.TOPPR_CRM_DB, DBConstants.CRM_DB_VERSION);
        getReadableDatabase();
        if (isDbCreated) {
            try {
                copyDataBase(mContext, DBConstants.TOPPR_CRM_DB, -1);
            } catch (IOException ioException) {
                if (BuildConfig.DEBUG) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        isDbCreated = true;
        //db.execSQL(EventListContract.CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        isDbCreated = true;
    }
}