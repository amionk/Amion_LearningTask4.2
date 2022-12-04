package com.demo.amion_learningtask42;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PreschoolResult extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        String result = extras.getString("result");
        setContentView(R.layout.activity_preschool_result);

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        TextView tvResult = (TextView) findViewById(R.id.txt_result);
        tvResult.setText(result);
        btnReturn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent preschool = new Intent(PreschoolResult.this, MainActivity.class);
        startActivity(preschool);
    }
}