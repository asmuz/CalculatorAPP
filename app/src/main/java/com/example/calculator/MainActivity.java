package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private String display;
    private Double result;
    private TextView resultsTV;
    private String buttonValue, operatorValue, lastChar;
    private boolean dot, operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = "0";
        resultsTV = findViewById(R.id.resultsTV);
        dot = false;
        operator = false;
    }

    public void numberClick(View view) {
        buttonValue = ((Button) view).getText().toString();
        if(!display.equals("0")) {
            display += buttonValue;
        }
        if(display.equals("0")) {
            backspace();
            display += buttonValue;
        }
        displayResult();
    }

    public void dotClick(View view) {
        if(display.equals("0")){
            display = "0.";
            dot = true;
        }
        if(display.substring(display.length()-1).equals(" ")) if (!dot) {
            display += "0.";
            dot = true;
        }
        if(!dot){
            display += ".";
            dot = true;
        }
        displayResult();
    }

    public void operatorsClick(View view) {
        if(operator){
            calcResult();
        }
        operatorValue = ((Button) view).getText().toString();
        if(!display.equals("0")){
            lastChar = display.substring(display.length()-1);
            if(lastChar.equals(".")){
                backspace();
            }
            if(!operator){
                display = display + " " + operatorValue + " ";
                operator = true;
            }
            dot = false;
        }
        displayResult();
    }

    public void equalsClick(View view) {
        calcResult();
    }

    public void deleteClick(View view) {
            lastChar = display.substring(display.length()-1);
            if(lastChar.equals(".")){
                dot = false;
            }
            if(lastChar.equals(" ")){
                operator = false;
                backspace();
                backspace();
            }
            backspace();

        if(display.length() == 0){
            display = "0";
            displayResult();
        }
    }

    public void backspace() {
        display = display.substring(0, display.length()-1);
        displayResult();
    }

    private void calcResult() {
        lastChar = display.substring(display.length()-1);
        if(!lastChar.equals(" ")){
            if(operator){
                String[] tokens = display.split(" ");
                Double firstArg = Double.parseDouble(tokens[0]);
                Double secondArg = Double.parseDouble(tokens[2]);
                switch (tokens[1]) {
                    case "+":
                        result = firstArg + secondArg;
                        break;
                    case "-":
                        result = firstArg - secondArg;
                        break;
                    case "x":
                        result = firstArg * secondArg;
                        break;
                    case "/":
                        result = firstArg / secondArg;
                        break;
                }
            }
        }
        if (result % 1 == 0) {
            int aaa = (int) Math.round(result);
            display = Integer.toString(aaa);
        }
        else
        {
            display = Double.toString(result);

        }
        operator = false;
        displayResult();
    }

    public void clearClick(View view) {
        display = "0";
        result = 0.0;
        dot = false;
        operator = false;
        displayResult();
    }

    private void displayResult() {
        resultsTV.setText(display);
    }
}