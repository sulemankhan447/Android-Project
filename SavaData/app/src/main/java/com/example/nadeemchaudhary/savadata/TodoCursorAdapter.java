package com.example.nadeemchaudhary.savadata;


import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TodoCursorAdapter extends CursorAdapter {
    public TodoCursorAdapter(Context context, Cursor c) {
        super(context, c,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.row,parent,false);

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvComputerName = (TextView)view.findViewById(R.id.lvComputerName);
        TextView tvComputerType = (TextView)view.findViewById(R.id.lvComputerType);
        String compuerName = cursor.getString(cursor.getColumnIndexOrThrow("ComputerName"));
        String computerType = cursor.getString(cursor.getColumnIndexOrThrow("ComputerType"));
        tvComputerName.setText(compuerName);
        tvComputerType.setText(computerType);
     }
}
