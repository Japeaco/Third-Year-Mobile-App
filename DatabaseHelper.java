package com.example.admin.easyeats;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by Admin on 14/04/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Recipes.sqlite";
    public static final String TABLE_NAME = "RECIPES";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "IMAGE";
    public static final String COL_3 = "INGREDIENT_1";
    public static final String COL_4 = "INGREDIENT_2";
    public static final String COL_5 = "INGREDIENT_3";
    public static final String COL_6 = "INGREDIENT_4";
    public static final String COL_7 = "INGREDIENT_5";
    public static final String COL_8 = "CATEGORY";
    public static final String COL_9 = "MEAL";
    public static final String COL_10 = "FAVOURITE";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insert(String name, byte[] img, String ing1, String ing2, String ing3, String ing4, String ing5,
                       String category, String meal){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO RECIPES VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 'No')";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindBlob(2, img);
        statement.bindString(3, ing1);
        statement.bindString(4, ing2);
        statement.bindString(5, ing3);
        statement.bindString(6, ing4);
        statement.bindString(7, ing5);
        statement.bindString(8, category);
        statement.bindString(9, meal);

        statement.executeInsert();
    }

    public void updateFavourite(String name){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE RECIPES SET favourite = 'Yes' WHERE name = '" + name + "'";

        SQLiteStatement statement = database.compileStatement(sql);

        statement.execute();
    }

    public void removeFavourite(String name){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE RECIPES SET favourite = 'No' WHERE name = '" + name + "'";

        SQLiteStatement statement = database.compileStatement(sql);

        statement.execute();
    }

    //get all data
    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(name VARCHAR PRIMARY KEY, image BLOG, " +
                "ing1 VARCHAR, ing2 VARCHAR, ing3 VARCHAR, ing4 VARCHAR, ing5 VARCHAR, category VARCHAR, meal VARCHAR, favourite VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
