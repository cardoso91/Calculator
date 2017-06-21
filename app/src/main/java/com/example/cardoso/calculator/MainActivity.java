package com.example.cardoso.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String operation;
    private double value_one = Double.NaN;
    private double value_two = Double.NaN;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    EditText display;
    TextView clear;
    TextView del;

    TextView no7;
    TextView no8;
    TextView no9;
    TextView division;

    TextView no4;
    TextView no5;
    TextView no6;
    TextView multiplication;

    TextView no1;
    TextView no2;
    TextView no3;
    TextView subtraction;

    TextView period;
    TextView no0;
    TextView equal;
    TextView addition;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (EditText) findViewById(R.id.display);

        clear = (TextView) findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClearOperation();
                value_one = Double.NaN;
                value_two = Double.NaN;

            }
        });

        del = (TextView) findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operation == null || operation.length() == 0){
                    ClearOperation();

                }else {
                    operation = operation.substring(0, operation.length() - 1);
                    display.setText(operation);
                }

            }
        });

        no7 = (TextView) findViewById(R.id.no7);
        no7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = display.getText().toString();
                operation = operation + 7;
                display.setText(String.valueOf(operation));
            }
        });

        no8 = (TextView) findViewById(R.id.no8);
        no8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = display.getText().toString();
                operation = operation + 8;
                display.setText(String.valueOf(operation));
            }
        });

        no9 = (TextView) findViewById(R.id.no9);
        no9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = display.getText().toString();
                operation = operation + 9;
                display.setText(String.valueOf(operation));
            }
        });

        division = (TextView) findViewById(R.id.division);
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Double.isNaN(value_two)) {
                    value_two = Double.NaN;
                    CURRENT_ACTION = DIVISION;
                    ClearOperation();
                }else {
                    TotalResult();
                    CURRENT_ACTION = DIVISION;
                    ClearOperation();
                }
            }
        });

        no4 = (TextView) findViewById(R.id.no4);
        no4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = display.getText().toString();
                operation = operation + 4;
                display.setText(String.valueOf(operation));
            }
        });

        no5 = (TextView) findViewById(R.id.no5);
        no5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = display.getText().toString();
                operation = operation + 5;
                display.setText(String.valueOf(operation));
            }
        });

        no6 = (TextView) findViewById(R.id.no6);
        no6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = display.getText().toString();
                operation = operation + 6;
                display.setText(String.valueOf(operation));
            }
        });

        multiplication = (TextView) findViewById(R.id.multiplication);
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Double.isNaN(value_two)) {
                    value_two = Double.NaN;
                    CURRENT_ACTION = MULTIPLICATION;
                    ClearOperation();
                }else {
                    TotalResult();
                    CURRENT_ACTION = MULTIPLICATION;
                    ClearOperation();
                }
            }
        });

        no1 = (TextView) findViewById(R.id.no1);
        no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = display.getText().toString();
                operation = operation + 1;
                display.setText(String.valueOf(operation));
            }
        });

        no2 = (TextView) findViewById(R.id.no2);
        no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = display.getText().toString();
                operation = operation + 2;
                display.setText(String.valueOf(operation));
            }
        });

        no3 = (TextView) findViewById(R.id.no3);
        no3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = display.getText().toString();
                operation = operation + 3;
                display.setText(String.valueOf(operation));
            }
        });

        subtraction = (TextView) findViewById(R.id.subtraction);
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Double.isNaN(value_two)) {
                    value_two = Double.NaN;
                    CURRENT_ACTION = SUBTRACTION;
                    ClearOperation();
                }else {
                    TotalResult();
                    CURRENT_ACTION = SUBTRACTION;
                    ClearOperation();
                }
            }
        });

        period = (TextView) findViewById(R.id.period);
        period.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = display.getText().toString();
                operation = operation + ".";
                display.setText(String.valueOf(operation));
            }
        });

        no0 = (TextView) findViewById(R.id.no0);
        no0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation = display.getText().toString();
                operation = operation + 0;
                display.setText(String.valueOf(operation));
            }
        });

        equal = (TextView) findViewById(R.id.equal);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TotalResult();
                display.setText(String.valueOf(value_one));
                operation = String.valueOf(value_one);
                //value_one = Double.NaN;
                //CURRENT_ACTION = '0';

            }
        });

        addition = (TextView) findViewById(R.id.addition);
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Double.isNaN(value_two)) {
                    value_two = Double.NaN;
                    CURRENT_ACTION = ADDITION;
                    ClearOperation();
                }else {
                    TotalResult();
                    CURRENT_ACTION = ADDITION;
                    ClearOperation();
                }
            }
        });

    }

    public void ClearOperation () {
        display.setText("");
        operation = "";

    }

    private void TotalResult () {
        if(!Double.isNaN(value_one)) {

            if(!Double.isNaN(value_two)) {

                if(CURRENT_ACTION == ADDITION)
                    value_one = this.value_one + value_two;
                else if(CURRENT_ACTION == SUBTRACTION)
                    value_one = this.value_one - value_two;
                else if(CURRENT_ACTION == MULTIPLICATION)
                    value_one = this.value_one * value_two;
                else if(CURRENT_ACTION == DIVISION)
                    value_one = this.value_one / value_two;

                display.setText(String.valueOf(value_one));

            } else {

                value_two = Double.parseDouble(display.getText().toString());

                if(CURRENT_ACTION == ADDITION)
                    value_one = this.value_one + value_two;
                else if(CURRENT_ACTION == SUBTRACTION)
                    value_one = this.value_one - value_two;
                else if(CURRENT_ACTION == MULTIPLICATION)
                    value_one = this.value_one * value_two;
                else if(CURRENT_ACTION == DIVISION)
                    value_one = this.value_one / value_two;
            }
        }
        else {
            try {
                value_one = Double.parseDouble(display.getText().toString());
            }
            catch (Exception e){}
        }
    }


}
