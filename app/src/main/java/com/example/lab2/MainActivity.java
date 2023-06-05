 package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {
    EditText edit_a, edit_b, edit_c;
    Button button;
    TextView text;

    float a, b, c, d, x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_a = (EditText) findViewById(R.id.edit_a);
        edit_b = (EditText) findViewById(R.id.edit_b);
        edit_c = (EditText) findViewById(R.id.edit_c);

        button = (Button) findViewById(R.id.button);

        text = (TextView) findViewById(R.id.text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edit_a.getText().toString().equals("") && !edit_b.getText().toString().equals("")
                        && !edit_c.getText().toString().equals("")){
                    a = Float.parseFloat(edit_a.getText () .toString ());
                    b = Float.parseFloat(edit_b.getText () .toString ());
                    c = Float.parseFloat(edit_c.getText () .toString () );

                    d = (float) (Math.pow(b, 2) - 4 * a * c);

                    if (d == 0 && a != 0 && b != 0) {
                        x1 = -b / (2 * a);
                        text.setText("d = " + d + "\nx = " + x1);
                    } else if (d < 0 && a != 0 && b != 0) {
                        text.setText("Нет корней!");
                    } else if (d > 0 && a != 0 && b != 0 || d > 0 && a != 0) {
                        x1 = (float) ((-b + Math.sqrt(d)) / (2 * a));
                        x2 = (float) ((-b - Math.sqrt(d)) / (2 * a));
                        text.setText("d = " + d + "\nx1 = " + x1 + "\nx2 = " + x1);
                    } else if(a == 0 && b != 0){
                        text.setText("Уравнение не является квадратным!");
                    } else if (a == 0 && b == 0) {
                        if(c == 0){
                            text.setText("Части уравнения тождественно верны\n"+"Уравнение не является квадратным!");
                        }
                        if(c != 0){
                            text.setText("Части уравнения тождественно не верны\n"+"Уравнение не является квадратным!");
                        }
                    }
                }
            }
        });
    }
}