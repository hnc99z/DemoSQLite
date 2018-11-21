package vn.edu.poly.demosqlite.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static vn.edu.poly.demosqlite.common.Constants.CREATE_ITEM_TABLE;
import static vn.edu.poly.demosqlite.common.Constants.CREATE_USER_TABLE;
import static vn.edu.poly.demosqlite.common.Constants.ITEM_TABLE;
import static vn.edu.poly.demosqlite.common.Constants.USER_DATE;
import static vn.edu.poly.demosqlite.common.Constants.USER_TABLE;
import static vn.edu.poly.demosqlite.common.Constants.isDEBUG;

public class SqliteHelper extends SQLiteOpenHelper {

    public SqliteHelper(Context context) {
        super(context, "db.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_ITEM_TABLE);
        if (isDEBUG) Log.e("ITEM_TABLE",CREATE_ITEM_TABLE);
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
        if (isDEBUG) Log.e("USER_TABLE",CREATE_USER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ITEM_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);

    }
}
