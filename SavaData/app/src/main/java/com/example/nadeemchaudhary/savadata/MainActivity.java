package com.example.nadeemchaudhary.savadata;

import android.content.Intent;
import android.icu.text.TimeZoneNames;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt1,edt2;
    Button btnAdd,btnMove;
    ListView listView;

    List<Computer> allComputer;
    ArrayList<String> NameType;
    ArrayAdapter adapter;
    SqliteHandler sqliteHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=(EditText)findViewById(R.id.edt1);
        edt2=(EditText)findViewById(R.id.edt2);
        btnAdd=(Button)findViewById(R.id.btnAdd);
        btnMove=(Button)findViewById(R.id.btnMove);
        listView=(ListView)findViewById(R.id.lv);

        btnAdd.setOnClickListener(MainActivity.this);
        btnMove.setOnClickListener(MainActivity.this);


        sqliteHandler=new SqliteHandler(MainActivity.this);
        allComputer=sqliteHandler.getAllComputer();
        NameType=new ArrayList<>();

        if(allComputer.size()>0){
            for(int i=0;i<allComputer.size();i++){
                Computer computer=allComputer.get(i);
                NameType.add(computer.getComputerName()+"--"+computer.getComputerType());
            }
        }


       // adapter=new ArrayAdapter(,android.R.layout.simple_list_item_1,
                //NameType);
        //listView.setAdapter(adapter);
    }
    @Override
    public void onClick(View view){

        switch (view.getId()){
            case R.id.btnAdd:
                Computer computer=new Computer(edt1.getText().toString(),edt2.getText().toString());
                if(edt1.getText().toString().matches("")||edt2.getText().toString().matches("")){
                    return;
                }
                else {
                    allComputer.add(computer);
                    sqliteHandler.addComputer(computer);
                    NameType.add(computer.getComputerName()+"--"+computer.getComputerType());
                    edt1.setText("");
                    edt2.setText("");
                }
                break;

            case R.id.btnMove:
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                break;

        }
    }
}
