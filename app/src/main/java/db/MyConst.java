package db;

import java.util.Date;

public class MyConst {
    public static final String DATABASE_NAME = "groupS.db";
    public static final int VERSION = 1;
    public static final String TABLE_NAME= "grouppa";
    public static final String ID = "id";
    public static final String FULL_NAME = "full_name";
    public static final String DATE = "date";

    public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY,"
            + FULL_NAME + " TEXT,"
            + DATE + " TEXT)";
    public static final String SQL_DROP_TABLE = "DROP TABLE IF NOT EXISTS " +
            TABLE_NAME;

}
