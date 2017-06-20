package com.example.cardoso.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String operation;
    String arithmeticSign;
    String value_one;
    String value_two;

    TextView equal;

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
                arithmeticSign = "/";
                value_one = operation;
                ClearOperation();

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
                arithmeticSign = "*";
                value_one = operation;
                ClearOperation();

            }
        });

        equal = (TextView) findViewById(R.id.equal);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value_two =  operation;
                double total = TotalResult(Double.parseDouble(value_one),Double.parseDouble(value_two),arithmeticSign);
                String totalResult = String.valueOf(total);
                display.setText(totalResult);
                value_one = totalResult;
            }
        });


    }

    public void ClearOperation () {
        display.setText("");
        operation = "";

    }

    public double TotalResult (double value_one, double value_two, String arithmeticSign) {
        double total = 0;

        switch (arithmeticSign){
            case "/":
                total = value_one / value_two;
                break;

            case "*":
                total = value_one * value_two;
                break;

            case "-":
                total = value_one - value_two;
                break;

            case "+":
                total = value_one + value_two;
                break;
        }
        return total;
    }


}
