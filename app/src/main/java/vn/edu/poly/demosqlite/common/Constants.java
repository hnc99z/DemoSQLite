package vn.edu.poly.demosqlite.common;

public class Constants {


    public final static boolean isDEBUG = true;

    // create table Item

    // column ITEM TABLE
    public final static String ITEM_ID = "id";

    public final static String ITEM_NAME = "name";

    public final static String ITEM_PRICE = "price";

    public final static String ITEM_DATE = "date";

    public final static String ITEM_TABLE = "item_table";

    // CREATE TABLE ITEM
    public final static String CREATE_ITEM_TABLE = "CREATE TABLE " + ITEM_TABLE + " (" +
            "" + ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            "" + ITEM_NAME + " TEXT ," +
            "" + ITEM_PRICE + " TEXT  ," +
            "" + ITEM_DATE + " TEXT " +
            ")";

    // =================================================


    // create table USER

    // column USER TABLE
    public final static String USER_ID = "id";

    public final static String USER_NAME = "name";

    public final static String USER_PRICE = "price";

    public final static String USER_DATE = "date";

    public final static String USER_TABLE = "USER_table";

    // CREATE TABLE USER
    public final static String CREATE_USER_TABLE = "CREATE TABLE " + USER_TABLE + " (" +
            "" + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
            "" + USER_NAME + " TEXT ," +
            "" + USER_PRICE + " TEXT  ," +
            "" + USER_DATE + " TEXT " +
            ")";

    // =================================================



}
