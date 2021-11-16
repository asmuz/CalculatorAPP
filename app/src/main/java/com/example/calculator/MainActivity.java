package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private String input = "";
    private String result = "0";
    private TextView resultsTV, workingsTV;
    private String buttonValue, operatorValue;
    private boolean dot, operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultsTV = findViewById(R.id.resultsTV);
        workingsTV = findViewById(R.id.workingsTV);

        dot = false;
        operator = false;
    }

    public void numberClick(View view) {
        buttonValue = ((Button) view).getText().toString();
        input += buttonValue;
        displayCurrent();
    }

    public void dotClick(View view) {
        if(input.isEmpty()){
            input = "0.";
            dot = true;
        }
        if(!dot){
            input += ".";
            dot = true;
        }
        displayCurrent();
    }

    public void operatorsClick(View view) {
        operatorValue = ((Button) view).getText().toString();
        dot = false;
        if(!input.isEmpty()){
            if(input.substring(input.length()-1, input.length()).equals(".")){
                backspace();
            }
            if(!operator){
                input += operatorValue;
                operator = true;
            }
        }
        displayCurrent();
    }

    public void clickPlus(View view) {

    }

    public void clickMinus(View view) {
    }

    public void clickMultiply(View view) {
    }

    public void clickDivide(View view) {
    }

    public void equalsClick(View view) {
    }

    public void deleteClick(View view) {
        backspace();
    }

    public void backspace() {
        if(!input.isEmpty()){
            input = input.substring(0,input.length()-1);
            displayCurrent();
        }
    }

    public void clearClick(View view) {
        input = "";
        result = "0";
        dot = false;
        operator = false;
        displayCurrent();
        displayResult();
    }

    private void displayCurrent() {
        workingsTV.setText(input);
    }

    private void displayResult() {
        resultsTV.setText(result);
    }
}