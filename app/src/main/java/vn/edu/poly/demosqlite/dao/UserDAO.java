package vn.edu.poly.demosqlite.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.demosqlite.model.Item;
import vn.edu.poly.demosqlite.sqlite.SqliteHelper;

import static vn.edu.poly.demosqlite.common.Constants.ITEM_DATE;
import static vn.edu.poly.demosqlite.common.Constants.ITEM_ID;
import static vn.edu.poly.demosqlite.common.Constants.ITEM_NAME;
import static vn.edu.poly.demosqlite.common.Constants.ITEM_PRICE;
import static vn.edu.poly.demosqlite.common.Constants.ITEM_TABLE;

public class UserDAO {


    private SQLiteDatabase sqLiteDatabase;
    private SqliteHelper sqliteHelper;

    public UserDAO(SqliteHelper sqliteHelper) {
        this.sqliteHelper = sqliteHelper;
    }

    public List<Item> getAllItems() {

        // xin quyen doc ghi vao DB
        sqLiteDatabase = sqliteHelper.getWritableDatabase();


        // Khoi tao 1 list item rong~ de luu du lieu
        List<Item> items = new ArrayList<>();


        // khai bao cau lenh query toan bo bang item
        String GET_ALL_ITEMS = "SELECT * FROM " + ITEM_TABLE;

        // viet cau lenh query va tra ket qua vao doi tuong con tro? la Cursor
        Cursor cursor = sqLiteDatabase.rawQuery(GET_ALL_ITEMS, null);


        // Kiem tra gia tri con tro truoc khi doc du lieu de tranh crash app
        if (cursor != null & cursor.getCount() > 0) {
            // di chuyen con tro toi vi tri dau tien
            cursor.moveToFirst();

            // vong while chay toi khi nao het gia tri trong con tro Cursor
            while (!cursor.isAfterLast()){


                // lay gia tri cac column theo Column Index (or theo ten cot)
                int id = cursor.getInt(cursor.getColumnIndex(ITEM_ID));
                String name = cursor.getString(cursor.getColumnIndex(ITEM_NAME));
                String price = cursor.getString(cursor.getColumnIndex(ITEM_PRICE));
                String date = cursor.getString(cursor.getColumnIndex(ITEM_DATE));


                // gan du lieu lay dc vao model Item
                Item item = new Item();
                item.id = id;
                item.name = name;
                item.price = price;
                item.date = date;

                // them item da dc gan du lieu vao List Item
                items.add(item);

                // di chuyen toi phan tu tiep theo
                cursor.moveToNext();
            }

            // close ket noi, giai phong bo nho
            cursor.close();
            sqLiteDatabase.close();

        }
        // tra ve ket qua la items (List)
        return items;
    }

    public Item getItemByID (int itemId){
        Item item = null;

        sqLiteDatabase = sqliteHelper.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(ITEM_TABLE,
                new String[]{ITEM_ID,ITEM_NAME,ITEM_PRICE,ITEM_DATE},ITEM_ID + "=?",
                new String[]{String.valueOf(itemId)},null,null,null,null);

        // Kiem tra gia tri con tro truoc khi doc du lieu de tranh crash app
        if (cursor != null & cursor.getCount() > 0) {
            // di chuyen con tro toi vi tri dau tien
                cursor.moveToFirst();

               // lay gia tri cac column theo Column Index (or theo ten cot)
                int id = cursor.getInt(cursor.getColumnIndex(ITEM_ID));
                String name = cursor.getString(cursor.getColumnIndex(ITEM_NAME));
                String price = cursor.getString(cursor.getColumnIndex(ITEM_PRICE));
                String date = cursor.getString(cursor.getColumnIndex(ITEM_DATE));

                // gan du lieu lay dc vao model Item
                item = new Item();
                item.id = id;
                item.name = name;
                item.price = price;
                item.date = date;

                // di chuyen toi phan tu tiep theo
                cursor.moveToNext();
            }

            // close ket noi, giai phong bo nho
            cursor.close();
            sqLiteDatabase.close();

        return item;
    }

    public long updateItem(Item item){

        sqLiteDatabase = sqliteHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ITEM_ID,item.id);
        contentValues.put(ITEM_NAME,item.name);
        contentValues.put(ITEM_PRICE,item.price);
        contentValues.put(ITEM_DATE,item.date);

        long result = sqLiteDatabase.update(ITEM_TABLE,contentValues,ITEM_ID + "=?",
                new String[]{String.valueOf(item.id)});

        sqLiteDatabase.close();

        return result;
    }


    public long insertItem(Item item){

        sqLiteDatabase = sqliteHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ITEM_ID,item.id);
        contentValues.put(ITEM_NAME,item.name);
        contentValues.put(ITEM_PRICE,item.price);
        contentValues.put(ITEM_DATE,item.date);

        long result = sqLiteDatabase.insert(ITEM_TABLE,null,contentValues);

        sqLiteDatabase.close();

        return result;

    }

    public long deleteItem(int id){
        sqLiteDatabase = sqliteHelper.getWritableDatabase();

        long result = sqLiteDatabase.delete(ITEM_TABLE,ITEM_ID + "=?",
                new String[]{String.valueOf(id)});

        sqLiteDatabase.close();

        return result;

    }




}
