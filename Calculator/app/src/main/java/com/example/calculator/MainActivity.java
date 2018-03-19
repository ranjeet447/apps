package com.example.calculator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.calculator.R.id.one;

public class MainActivity extends AppCompatActivity {

    Button button0 , button1 , button2 , button3 , button4 , button5 , button6 ,
            button7 , button8 , button9 , buttonAdd , buttonSub , buttonDevide ,
            buttonMul ,buttonEqual,buttonC,buttonDel,buttonDot;

    EditText display;

    private double valueOne = Double.NaN;
    private double valueTwo;

    boolean mAdd,mSub,mMul,mDiv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);

        button0 = (Button) findViewById(R.id.zero);
        button1 = (Button) findViewById(one);
        button2 = (Button) findViewById(R.id.two);
        button3 = (Button) findViewById(R.id.three);
        button4 = (Button) findViewById(R.id.four);
        button5 = (Button) findViewById(R.id.five);
        button6 = (Button) findViewById(R.id.six);
        button7 = (Button) findViewById(R.id.seven);
        button8 = (Button) findViewById(R.id.eight);
        button9 = (Button) findViewById(R.id.nine);
        buttonDot = (Button) findViewById(R.id.dot_button);
        buttonAdd = (Button) findViewById(R.id.add_button);
        buttonSub = (Button) findViewById(R.id.minus_button);
        buttonMul = (Button) findViewById(R.id.multiply_button);
        buttonDevide = (Button) findViewById(R.id.devide_button);
        buttonC = (Button) findViewById(R.id.cancel_button);
        buttonEqual = (Button) findViewById(R.id.equal_button);
        buttonDel = (Button)findViewById(R.id.delete_button);

        display = (EditText)findViewById(R.id.display) ;


        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(display.getText() + "9");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display==null){
                    display.setText((valueOne) +"");
                }else {
                    valueOne = Double.parseDouble(display.getText() + "");
                    mAdd = true;
                    display.setText((valueTwo) + "+");
                }
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    valueOne = Double.parseDouble(display.getText() + "");
                    mSub = true;
                    display.setText((valueOne) + "-");


            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(display==null){
                    display.setText("");
                }else {
                    valueOne = Double.parseDouble(display.getText() + "");
                    mMul = true;
                    display.setText((valueOne) + "*");
                }
            }
        });
        buttonDevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    valueOne = Double.parseDouble(display.getText() + "");
                    mDiv = true;
                    display.setText((valueOne) + "/");
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                valueTwo=Double.parseDouble(display.getText() +"");

                if(mAdd==true){
                    valueOne = valueOne + valueTwo;
                    display.setText(valueOne +"");
                    mAdd=false;
                }
                if(mSub==true){
                    valueOne = valueOne - valueTwo;
                    display.setText(valueOne +"");
                    mSub=false;
                }
                if(mMul==true){
                    valueOne = valueOne * valueTwo;
                    display.setText(valueOne +"");
                    mMul=false;
                }
                if(mDiv==true){
                    valueOne = valueOne / valueTwo;
                    display.setText(valueOne +"");
                    mDiv=false;
                }

            }
        });
        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (display.getText().length() > 0) {
                    CharSequence currentText = display.getText();
                    display.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    display.setText(null);
                }
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = '0';
                valueTwo = '0';
                display.setText(null);

            }
        });
    }
   /* private void Calculate() {
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(display.getText().toString());
            display.setText(null);

            if(CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if(CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if(CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        }
        else {
            try {
                valueOne = Double.parseDouble(display.getText().toString());
            }
            catch (Exception e){
            }
        }

    }*/
}
