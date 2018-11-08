package edu.osucascades.hubbard.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String NAME = "students";
    public static final String ID = "id";
    public static final String FIRST = "first";
    public static final String LAST = "last";
    public static final String GRADE = "grade";

    public static final String DATABASE_NAME = "studentBase.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);  //creates dbase

    }


    @Override
    public void onCreate(SQLiteDatabase db) {  //db is passed in
        db.execSQL("CREATE TABLE " + NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + "FIRST TEXT, LAST TEXT, GRADE INT)");  //creates table inside of dbase
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertData(String first, String last, String grade ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FIRST, first);  //puts key,value pairs into the ContentValues object
        //add code to put last into values
        //add code to put grade into values
        long result = db.insert(NAME, null, values);  //-a return value of -1 means .insert was unsuccessful
        //add code:  if insert() returns a -1 have this function return false. Otherwise, have it return true

    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + NAME , null); //query the dbase for all the data from the data
        return cursor;

    }
}


