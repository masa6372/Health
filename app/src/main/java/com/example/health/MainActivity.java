package com.example.health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double stdWeight;
    String stdWeightTxt;
    String errorMsg;
    DecimalFormat myFormat = new DecimalFormat("###.##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        stdWeightTxt = res.getString(R.string.stdWeight);
        errorMsg = res.getString(R.string.errorMsg);
    }
    public void onClickButton(View view) {
        EditText heightText = (EditText) findViewById(R.id.heightText);
        String heightStr = heightText.getText().toString();
        TextView stdWeightTextView = (TextView) findViewById(R.id.stdWeightText);
        try {
            double height = Double.parseDouble(heightStr);
            stdWeight = Math.pow(height / 100, 2) * 22;
            String stdweightStr = myFormat.format(stdWeight);
            stdWeightTextView.setText(stdWeightTxt + stdweightStr + "Kg");
        } catch (NumberFormatException e) {
            Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show();
        }
    }
}