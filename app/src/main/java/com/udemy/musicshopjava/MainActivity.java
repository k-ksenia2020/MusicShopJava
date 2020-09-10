package com.udemy.musicshopjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    TextView quantityTextView;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantityTextView = findViewById(R.id.quantityNumberTextView);
        findViewById(R.id.minusButton).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do what you want here
                quantity--;
                if (quantity < 0) {
                    quantity = 0;
                }
                updateQuantityField();
            }
        });
        findViewById(R.id.plusButton).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do what you want here
                quantity++;
                updateQuantityField();
            }
        });

        spinner =findViewById(R.id.spinner);
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("guitars");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");
        spinnerArrayList.add("saxophones");
        spinnerArrayList.add("flutes");
        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    @SuppressLint("SetTextI18n")
    void updateQuantityField() {
        quantityTextView.setText("" + quantity);
    }
}