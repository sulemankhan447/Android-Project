package com.example.nadeemchaudhary.prefrence;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    TextView txtNumber1,txtNumber2,txtNumber3;

    ListPreference listPreference;

    Typeface fontnumber1;
    Typeface fontnumber2;
    Typeface fontnumber3;

    String tv1size;
    String tv2size;
    String tv3size;

    SharedPreferences sharedPreferences;

    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber1= findViewById(R.id.tv1);
        txtNumber2= findViewById(R.id.tv2);
        txtNumber3= findViewById(R.id.tv3);

        fontnumber1=Typeface.createFromAsset(getAssets(),"fonts/Histeria.ttf"); //How access the font from the asset using typeface
        fontnumber2=Typeface.createFromAsset(getAssets(),"fonts/Raven.ttf");
        fontnumber3=Typeface.createFromAsset(getAssets(),"fonts/Waltograph.otf");

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(MainActivity.this); //instantiate the shared preference

        }


        //change the font of first textview
        public void specifyfontfortextview1()
        {
            boolean fontnumber1fortext1,fontnumber2fortext1,fontnumber3fortext1;

            fontnumber1fortext1=sharedPreferences.getBoolean("checkbox_font_number1_text1",false);
            fontnumber2fortext1=sharedPreferences.getBoolean("checkbox_font_number2_text1",false);
            fontnumber3fortext1=sharedPreferences.getBoolean("checkbox_font_number3_text1",false);

            if(fontnumber1fortext1){
                txtNumber1.setTypeface(fontnumber1);
            }
            else  if(fontnumber2fortext1){
                txtNumber1.setTypeface(fontnumber2);
            }
            else  if(fontnumber3fortext1){
                txtNumber1.setTypeface(fontnumber3);
            }
        }

        //change the size of first textview
        public  void specifysizeoftext1(){
            tv1size=sharedPreferences.getString("font_size_text1","20");
            txtNumber1.setTextSize( Float.parseFloat(tv1size));
            listPreference.setSummary(tv1size);
    }

        //Change the font of second textview
        public void specifyfontfortextview2(){
            boolean fontnumber1fortext2,fontnumber2fortext2,fontnumber3fortext2;

            fontnumber1fortext2=sharedPreferences.getBoolean("checkbox_font_number1_text2",false);
            fontnumber2fortext2=sharedPreferences.getBoolean("checkbox_font_number2_text2",false);
            fontnumber3fortext2=sharedPreferences.getBoolean("checkbox_font_number3_text2",false);


            if(fontnumber1fortext2){
                txtNumber2.setTypeface(fontnumber1);
            }
            else if(fontnumber2fortext2){
                txtNumber2.setTypeface(fontnumber2);
            }
            else if(fontnumber3fortext2){
                txtNumber3.setTypeface(fontnumber3);
            }
        }
        //change the ssize of second textview
        public void specifysizeoftext2(){
            tv2size=sharedPreferences.getString("font_size_text2","20");
           txtNumber2.setTextSize(Float.parseFloat(tv2size));
           listPreference.setSummary(tv2size);
        }

    //change the font of third textview
    public void specifyfontfortextview3(){
        boolean fontnumber1fortext3,fontnumber2fortext3,fontnumber3fortext3;

        fontnumber1fortext3=sharedPreferences.getBoolean("checkbox_font_number1_text3",false);
        fontnumber2fortext3=sharedPreferences.getBoolean("checkbox_font_number2_text3",false);
        fontnumber3fortext3=sharedPreferences.getBoolean("checkbox_font_number3_text3",false);


        if(fontnumber1fortext3){
            txtNumber3.setTypeface(fontnumber1);
        }
        else if(fontnumber2fortext3){
            txtNumber3.setTypeface(fontnumber2);
        }
        else if(fontnumber3fortext3){
            txtNumber3.setTypeface(fontnumber3);
        }
    }
    //change the size of third textview
    public void specifysizeoftext3(){
        tv3size=sharedPreferences.getString("font_size_text3","20");
        txtNumber3.setTextSize(Float.parseFloat(tv3size));
        listPreference.setSummary(tv3size);
    }


    @Override
        protected void onResume() {
            super.onResume();
        Toast.makeText(MainActivity.this,"This OnResumeMethod is call",Toast.LENGTH_SHORT).show();
        specifyfontfortextview1();
        specifysizeoftext1();

        specifyfontfortextview2();
        specifysizeoftext2();


        specifyfontfortextview3();
        specifysizeoftext3();
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.setting:
                Intent intent=new Intent(MainActivity.this,prefrences.class);
                startActivity(intent);

                break;

        }
            return onOptionsItemSelected(item);
    }
}

