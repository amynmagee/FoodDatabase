package com.example.fooddatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {

    public DatabaseManager(Context context){
        super(context, "FoodDB", null, 1);
    }

    public void onCreate(SQLiteDatabase db){
        String sql = "create table FoodTable(";
        sql += "id integer primary key autoincrement, ";
        sql += "dish text, country text, type text)";
        db.execSQL(sql);
    }

    public void insert(String dishName, String countryName, String typeName){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "insert into FoodTable values(";
        sql += "null, '"+dishName+"', '"+countryName+"', '"+typeName+"')";
        db.execSQL(sql);
        db.close();
    }

    public void updateByFood(String dish, String country, String type){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "update FoodTable set country = '"+country+"'";
        sql += "where dish = '"+dish+"'";
        db.execSQL(sql);
        db.close();
    }

    public ArrayList<String> getDish(){
        ArrayList<String> list = new ArrayList<String>();
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from FoodTable";
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()) {
            String dish = cursor.getString(1);
            list.add(dish);
        }
        db.close();
        return list;
    }

    public String[] get(String dishName){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from FoodTable where dish = '"+dishName+"'";
        Cursor cursor = db.rawQuery(sql, null);
        String[] entry = new String[3];
        if (cursor.moveToFirst()){
            String dish = cursor.getString(1);
            String country = cursor.getString(2);
            String type = cursor.getString(3);
            entry[0] = dish;
            entry[1] = country;
            entry[2] = type;
        }
        db.close();
        return entry;
    }

    public ArrayList<String> getCountry (String countryName){
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<String> list = new ArrayList<String>();
        String sql = "select * from FoodTable where country = '"+countryName+"'";
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()) {
            String country = cursor.getString(1);
            list.add(country);
        }
        db.close();
        return list;
    }

    public void delete (String deleteDish){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "delete from FoodTable where dish = '"+deleteDish+"'";
        db.execSQL(sql);
        db.close();
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

}
