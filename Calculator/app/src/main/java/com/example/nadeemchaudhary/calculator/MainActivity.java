package com.example.nadeemchaudhary.calculator;

import android.content.Context;
import android.renderscript.Script;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView expression,result;
    TextView clear,back;
    TextView zero,one,two,three,four,five,six,seven,eight,nine,dot;
    TextView plus,minus,divide,multiply,equal,close,open;
    String prevalues;
    private final char ADDITION='+';
    private final char SUBSTRACTION='-';
    private final char MULTIPLICATION='*';
    private final char DIVISION='/';
    private final char EQU=0;
    private double val1=Double.NaN;
    private double val2;
    private char Action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zero=(TextView)findViewById(R.id.zero);
        one=(TextView)findViewById(R.id.one);
        two=(TextView)findViewById(R.id.two);
        three=(TextView)findViewById(R.id.three);
        four=(TextView)findViewById(R.id.four);
        five=(TextView)findViewById(R.id.five);
        six=(TextView)findViewById(R.id.six);
        seven=(TextView)findViewById(R.id.seven);
        eight=(TextView)findViewById(R.id.eight);
        nine=(TextView)findViewById(R.id.nine);
        dot=(TextView)findViewById(R.id.dot);
        plus=(TextView)findViewById(R.id.plus);
        minus=(TextView)findViewById(R.id.minus);
        divide=(TextView)findViewById(R.id.divide);
        multiply=(TextView)findViewById(R.id.multiply);
        equal=(TextView)findViewById(R.id.equal);
        close=(TextView)findViewById(R.id.close);
        open=(TextView)findViewById(R.id.open);
        equal=(TextView)findViewById(R.id.equal);
        expression=(TextView)findViewById(R.id.expression);
        result=(TextView)findViewById(R.id.result);
        clear=(TextView)findViewById(R.id.clear);
        back=(TextView)findViewById(R.id.back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevalues=expression.getText().toString();
                if(prevalues.length()>0) {
                    prevalues = prevalues.substring(0, prevalues.length() - 1);
                    expression.setText(prevalues);
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val1=Double.NaN;
                val2=Double.NaN;
                expression.setText("");
                result.setText("");
            }
        });

        //for the numeric values//
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevalues=expression.getText().toString();
                expression.setText(prevalues+"1");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevalues=expression.getText().toString();
                expression.setText(prevalues+"0");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevalues=expression.getText().toString();
                expression.setText(prevalues+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevalues=expression.getText().toString();
                expression.setText(prevalues+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevalues=expression.getText().toString();
                expression.setText(prevalues+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevalues=expression.getText().toString();
                expression.setText(prevalues+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevalues=expression.getText().toString();
                expression.setText(prevalues+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevalues=expression.getText().toString();
                expression.setText(prevalues+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevalues=expression.getText().toString();
                expression.setText(prevalues+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevalues=expression.getText().toString();
                expression.setText(prevalues+"9");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevalues=expression.getText().toString();
                expression.setText(prevalues+".");
            }
        });
        //for the operation//
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                Action=ADDITION;
                result.setText(String.valueOf(val1)+"+");
                expression.setText(null);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                Action=SUBSTRACTION;
                result.setText(String.valueOf(val1)+"-");
                expression.setText(null);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                Action=MULTIPLICATION;
                result.setText(String.valueOf(val1)+"*");
                expression.setText(null);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                Action=DIVISION;
                result.setText(String.valueOf(val1)+"/");
                expression.setText(null);
            }
        });
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevalues=expression.getText().toString();
                expression.setText(prevalues+"(");
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevalues = expression.getText().toString();
                expression.setText(prevalues + ")");
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                Action=EQU;
                result.setText(result.getText().toString()+String.valueOf(val2)+"="+String.valueOf(val1));
                  expression.setText(null);
            }
        });

    }
    void compute(){
        if(!Double.isNaN(val1)){
            val2=Double.parseDouble(expression.getText().toString());

            switch (Action){
                case ADDITION:
                    val1=val1+val2;
                    break;

                case SUBSTRACTION:
                    val1=val1-val2;
                    break;
                case MULTIPLICATION:
                    val1=val1*val2;
                    break;

                case DIVISION:
                    val1=val1/val2;
                    break;

                case EQU:
                    break;
                    }
        }
        else{
            val1=Double.parseDouble(expression.getText().toString());

        }
    }
}
