package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonConvertir;
    TextView textViewPrice1;
    TextView textViewPrice2;
    Spinner spinnerChoix;
    EditText editTextMonnaie;
    String[] list = {"DH","Euro","Dollar"};
    DecimalFormat df=new DecimalFormat("##.00");
    Double dh,euro,dollar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerChoix = findViewById(R.id.spinnerChoix);
        textViewPrice1 = findViewById(R.id.textViewPrice1);
        editTextMonnaie=findViewById(R.id.editTextMonnaie);
        textViewPrice2 = findViewById(R.id.textViewPrice2);
        buttonConvertir = findViewById(R.id.buttonConvertir);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        spinnerChoix.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        buttonConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double monnaie;
                if(editTextMonnaie.getText().toString().equals(""))
                    monnaie =0;
                else
                    monnaie =Double.parseDouble(editTextMonnaie.getText().toString());
                String typeMonnaie = spinnerChoix.getSelectedItem().toString();

                switch (typeMonnaie)
                {
                    case "DH" :
                        euro = monnaie*0.091;
                        dollar = monnaie*0.097;
                        textViewPrice1.setText("Euro : 0" +df.format(euro)+" €");
                        textViewPrice2.setText("Dollar : 0"+df.format(dollar)+" $");
                        break;
                    case "Euro" :
                        dh = monnaie*11.01;
                        dollar = monnaie * 1.06;
                        textViewPrice1.setText("Dirham : 0"+df.format(dh)+" MAD");
                        textViewPrice2.setText("Dollar : 0"+df.format(dollar)+" $");
                        break;
                    case "Dollar":
                        dh = monnaie*10.34;
                        euro = 0.94;
                        textViewPrice1.setText("Dirham : 0"+df.format(dh)+" MAD");
                        textViewPrice2.setText("Euro : 0" +df.format(euro)+" €");
                        break;
                }
            }
        });
    }
}