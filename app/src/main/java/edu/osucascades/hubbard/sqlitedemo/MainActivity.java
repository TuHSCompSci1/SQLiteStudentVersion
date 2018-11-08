package edu.osucascades.hubbard.sqlitedemo;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //add code to create an object of type DatabaseHelper. Name it myDb

    //add code to create objects for your editText views
    //add code to create objects for your addData button and your viewAll button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myDb = new DatabaseHelper(this);//the DatabaseHelper constructor create the database and table

        //add code to assign editText and button objects to your inflated view objects

        addData();
        viewAll();
    }

    public void addData() {
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(editFirst.getText().toString(), editLast.getText().toString(),editGrade.getText().toString()); //insert data into your database using text extracted from editText views
                if (isInserted) {
                    //add a success Toast
                }
                else {
                    //add an error toast
                }
            }
        });
    }

    /*  Views all the data in the database */
    public void viewAll() {
        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = myDb.getAllData();  //puts all the data from the database in the cursor object
                if (cursor.getCount()==0) {
                    //add code to call showMessage sending "Error" for the AlertDialog title and "No data found" for the AlertDialog message
                    return;
                }

                //This code parses the cursor data add headings and newlines and places the formatted data in buffer
                StringBuffer buffer = new StringBuffer();
                while (cursor.moveToNext()) {    //process the cursor object one element at a time adding formatted data to buffer
                    buffer.append("Id :" + cursor.getString(0) +"\n");  //columnIndex 0 is the id data
                    buffer.append("First :" + cursor.getString(1) +"\n"); //columnIndex 1 is the first data
                    buffer.append("Last :" + cursor.getString(2) +"\n");  //columnIndex 2 is the last data
                    buffer.append("Grade :" + cursor.getString(3) +"\n\n"); //columnIndex 3 is the grade data
                }

                //add code to call showMessage sending "Data" for the AlertDialog title and buffer(the formatted data) for the AlertDialog message
            }
        });
    }

    //This function creates an AlertDialog
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);  //let user cancel the dialog
        // add code to set the AlertDialog's title and message the builder object
        builder.show();  //shows alert dialog. Don't forget this or you'll never see it!

    }
}
