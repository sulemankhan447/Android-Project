package com.example.nadeemchaudhary.savadata;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class SecondActivity extends AppCompatActivity {
    Button btnDelete;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnDelete=(Button)findViewById(R.id.btnDelete);
        listView=(ListView)findViewById(R.id.lv);

        SqliteHandler sqliteHandler = new SqliteHandler(this);
        SQLiteDatabase sqLiteDatabase = sqliteHandler.getWritableDatabase();
        Cursor todoCursor = sqLiteDatabase.rawQuery("SELECT  * FROM computer",null);
        TodoCursorAdapter todoCursorAdapter = new TodoCursorAdapter(this,todoCursor);
        listView.setAdapter(todoCursorAdapter);
        todoCursorAdapter.changeCursor(todoCursor);
       //Cursor cursor = sqliteHandler.getComputer(0);
      // startManagingCursor(cursor);
    //   String computerName,computerType ;
//       String compuuterName  = new String[]{};computerType;
       // SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,R.layout.row,cursor,computerName,computerType);
        //listView.setAdapter(simpleCursorAdapter);
      //  sqliteHandler.close();
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
}
