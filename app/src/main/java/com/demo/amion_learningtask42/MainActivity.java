package com.demo.amion_learningtask42;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText inputCount, inputAge;
    String header, result, resultMessage, txtCount, txtAge;
    int ageGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCompute = (Button) findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Computing....", Toast.LENGTH_SHORT).show();
        ComputeResult();
    }

    public void ComputeResult(){
        inputCount = (EditText) findViewById(R.id.inputCount);
        inputAge = (EditText) findViewById(R.id.inputAge);

        txtAge = inputAge.getText().toString();
        txtCount = inputCount.getText().toString();

        int userAge = Integer.parseInt(txtAge);
        int userCount = Integer.parseInt(txtCount);

        if(userAge >= 0 && userAge <= 3 ){
            ageGroup = 1;

        }else if(userAge > 3 && userAge <= 6 ){
            ageGroup = 2;

        }else if(userAge > 6 && userAge <= 18){
            ageGroup = 3;

        } else if(userAge > 18 && userAge <= 59){
            ageGroup = 4;

        }



        switch (ageGroup) {
            case 1:
                header = "Infant Respiratory Rate Assessment";
                if(userCount >= 20 && userCount <= 40){
                    resultMessage = "Normal Respiratory Rate";
                }else{
                    resultMessage = "Abnormal Respiratory Rate";
                }
                Bundle args1 = new Bundle();
                args1.putString(header,resultMessage);
                Intent infant = new Intent(MainActivity.this, InfantResult.class);
                infant.putExtras(args1);
                startActivity(infant);
                break;

            case 2:
                header = "Pre-school Children Respiratory Rate Assessment";
                if(userCount >= 20 && userCount <= 30){
                    resultMessage = "Normal Respiratory Rate";
                }else{
                    resultMessage = "Abnormal Respiratory Rate";
                }
                Bundle args2 = new Bundle();
                args2.putString(header,resultMessage);

                Intent preschool = new Intent(MainActivity.this, PreschoolResult.class);
                preschool.putExtras(args2);
                startActivity(preschool);
                break;
            case 3:
                header= "Older Children Respiratory Rate Assessment";
                if(userCount >= 16 && userCount <= 25){
                    resultMessage = "Normal Respiratory Rate";
                }else{
                    resultMessage = "Abnormal Respiratory Rate";
                }

                Bundle args3 = new Bundle();
                args3.putString(header,resultMessage);

                Intent older = new Intent(MainActivity.this, OlderChildResult.class);
                older.putExtras(args3);
                startActivity(older);
                break;
            case 4:
                header = "Adult Respiratory Rate Assessment";
                if(userCount >= 12 && userCount <= 20){
                    resultMessage = "Normal Respiratory Rate";
                }else{
                    resultMessage = "Abnormal Respiratory Rate";
                }

                Bundle args4 = new Bundle();
                args4.putString(header,resultMessage);

                Intent adult = new Intent(MainActivity.this, AdultResult.class);
                adult.putExtras(args4);
                startActivity(adult);
                break;

        }

        clearEditText();
    }
    public void clearEditText(){
        inputCount.getText().clear();
        inputAge.getText().clear();
        inputAge.requestFocus();
    }
    public double ToDecimal(double nbr){
        nbr = nbr/100;
        return nbr;
    }
}
