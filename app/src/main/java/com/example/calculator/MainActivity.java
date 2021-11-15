package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private int inputValue;
    private int result = 0;
    private String display = "";
    private StringBuilder inputStr = new StringBuilder();
    private TextView resultsTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultsTV = findViewById(R.id.resultsTV);
    }

    public void numberClick(View view) {
        String buttonValue = ((Button) view).getText().toString();
        inputStr.append(buttonValue);
        inputValue = Integer.parseInt(inputStr.toString());
        resultsTV.setText(display + inputStr);
    }

    public void clickPlus(View view) {
        result = result + inputValue;
        inputValue = 0;
        display = (result + "+").toString();
        inputStr.setLength(0);
        resultsTV.setText(String.valueOf(display));

    }

    public void clickMinus(View view) {
        result = result - inputValue;
        inputValue = 0;
        display = (result + "-").toString();
        inputStr.setLength(0);
        resultsTV.setText(String.valueOf(display));
    }

    public void clickMultiply(View view) {

    }

    public void clickDivide(View view) {

    }

    public void equalsClick(View view) {
    }

    public void deleteClick(View view) {
        inputStr.setLength(inputStr.length() -1);
        resultsTV.setText(inputStr);
    }

    public void clearClick(View view) {
        display = "";
        inputValue = 0;
        result = 0;
        inputStr.setLength(0);
        resultsTV.setText("0");
    }
}