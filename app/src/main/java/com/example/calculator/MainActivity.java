package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    EditText num1,num2;

    Button plus,minus,mul,div;

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        num1= findViewById(R.id.num1);
        num2= findViewById(R.id.num2);
        plus= findViewById(R.id.sum);
        minus= findViewById(R.id.minus);
        mul= findViewById(R.id.multi);
        div= findViewById(R.id.div);
        result= findViewById(R.id.result);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "addtion", Toast.LENGTH_SHORT).show();
                perform("+");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform("-");
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform("*");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform("/");
            }
        });

    }

    void perform(String oper){
        double y=Double.parseDouble(num2.getText().toString());
        double x=Double.parseDouble(num1.getText().toString());
        double res=0;

        switch (oper){
            case "+":
                res=x + y;
                break;

            case "-":
                res=x - y;
                break;

            case "*":
                res=x * y;
                break;

            case "/":
                if(y==0){
                    result.setText("Can't divide by zero");
                }
                res=x / y;
                break;
        }

        result.setText(String.valueOf(res));

    }

}