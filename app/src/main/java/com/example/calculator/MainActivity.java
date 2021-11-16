package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private String input = "";
    private Double result;
    private TextView resultsTV;
    private String buttonValue, operatorValue, lastChar;
    private boolean dot, operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultsTV = findViewById(R.id.resultsTV);
        dot = false;
        operator = false;
    }

    public void numberClick(View view) {
        buttonValue = ((Button) view).getText().toString();
        input += buttonValue;
        displayResult();
    }

    public void dotClick(View view) {
        if(input.isEmpty()){
            input = "0.";
            dot = true;
        }
        if(input.substring(input.length()-1).equals(" ")) if (!dot) {
            input += "0.";
            dot = true;
        }
        if(!dot){
            input += ".";
            dot = true;
        }
        displayResult();
    }

    public void operatorsClick(View view) {
        if(operator){
            calcResult();
        }
        operatorValue = ((Button) view).getText().toString();
        if(!input.isEmpty()){
            lastChar = input.substring(input.length()-1);
            if(lastChar.equals(".")){
                backspace();
            }
            if(!operator){
                input = input + " " + operatorValue + " ";
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
        if(!input.isEmpty()){
            lastChar = input.substring(input.length()-1);
            if(lastChar.equals(".")){
                dot = false;
            }
            if(lastChar.equals(" ")){
                operator = false;
                backspace();
                backspace();
            }
            backspace();
        }
    }

    public void backspace() {
        if(!input.isEmpty()){
            input = input.substring(0,input.length()-1);
            displayResult();
        }
    }

    private void calcResult() {
        lastChar = input.substring(input.length()-1);
        if(!lastChar.equals(" ")){
            if(operator){
                String[] tokens = input.split(" ");
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
            input = Integer.toString(aaa);
        }
        else
        {
            input = Double.toString(result);

        }
        operator = false;
        displayResult();
    }

    public void clearClick(View view) {
        input = "";
        result = 0.0;
        dot = false;
        operator = false;
        displayResult();
    }

    private void displayResult() {
        resultsTV.setText(input);
    }
}