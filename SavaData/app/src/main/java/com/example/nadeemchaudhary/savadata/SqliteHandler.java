package com.example.nadeemchaudhary.savadata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class SqliteHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="computer.db";
    private static final String TABLE_NAME="computer";

    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="ComputerName";
    private static final String COLUMN_TYPE="ComputerType";

    String CREATE_COMPUTER_TABLE="CREATE TABLE " + TABLE_NAME + "(" +COLUMN_ID + " INTEGER PRIMARY KEY, "
            + COLUMN_NAME + " TEXT,"+COLUMN_TYPE +" TEXT "+")";

    public SqliteHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(CREATE_COMPUTER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    //create
    public void addComputer(Computer computer){

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(COLUMN_NAME,computer.getComputerName());
        values.put(COLUMN_TYPE,computer.getComputerType());

        sqLiteDatabase.insert(TABLE_NAME,null,values);
        sqLiteDatabase.close();
    }
    //Getting a single a computer--read
    public Cursor getComputer(int id){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();

        Cursor cursor=sqLiteDatabase.query(TABLE_NAME,new String[]{COLUMN_ID,COLUMN_NAME,COLUMN_TYPE},
                COLUMN_ID+"=?",new String[]{String.valueOf(id)},null,null,null);
            return cursor;
    //    if(cursor!=null){
         //   cursor.moveToFirst();
      //  }
        //Computer computer=new Computer(Integer.parseInt(cursor.getString(0)),cursor.getString(1),
    //            cursor.getString(2));
//
      //  return computer;
    }

    //Getting all computer object
    public List<Computer> getAllComputer() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String allComputer = "SELECT * FROM " + TABLE_NAME;
        List<Computer> computerList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery(allComputer, null);

        if (cursor.moveToFirst()) {
            do {
                Computer computer = new Computer();
                computer.setID(Integer.parseInt(cursor.getString(0)));
                computer.setComputerName(cursor.getString(1));
                computer.setComputerType(cursor.getString(2));

                computerList.add(computer);

            } while (cursor.moveToNext());
        }

        return computerList;
    }
    //deleting
    public void delete(Computer computer){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME,COLUMN_ID+"=?",
                new String[]{String.valueOf(computer.getID())});
        sqLiteDatabase.close();

    }

    //Getting number of computer
    public int getcountComputer(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        String allCountComputer=" SELECT * FROM "+TABLE_NAME;
        Cursor cursor=sqLiteDatabase.rawQuery(allCountComputer,null);
        cursor.close();
        return cursor.getCount();
    }
















}
