package com.udemy.musicshopjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int quantity = 0;
    TextView quantityTextView;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;

    HashMap goodsMap;
    String goodsName;
    double price;

    EditText userNameEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     createSpinner();
     createMap();

        quantityTextView = findViewById(R.id.quantityNumberTextView);
        userNameEditText=findViewById(R.id.nameEditText);

        findViewById(R.id.minusButton).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do what you want here
                quantity--;
                if (quantity < 0) {
                    quantity = 0;
                }
                updateQuantityField();
                TextView priceTextView = findViewById(R.id.priceNumberTextView);
                priceTextView.setText("" + quantity * price);
            }
        });
        findViewById(R.id.plusButton).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do what you want here
                quantity++;
                updateQuantityField();
                TextView priceTextView = findViewById(R.id.priceNumberTextView);
                priceTextView.setText("" + quantity * price);
            }
        });
        findViewById(R.id.addToCartBtn).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do what you want here

                    Order order = new Order();
                    order.userName = userNameEditText.getText().toString();
                    Log.d("printUserName",order.userName);
                    order.goodsName = goodsName;
                    Log.d("goodsNAme",order.goodsName);
                    order.quantity = quantity;
                    Log.d("quantity",""+order.quantity);
                    order.orderPrice = quantity*price;
                    Log.d("orderPrice",""+ order.orderPrice);
                    order.price = price;

                    Intent orderIntent = new Intent(MainActivity.this, OrderActivity.class);
                    orderIntent.putExtra("userNameForIntent", order.userName);
                    orderIntent.putExtra("goodsName",order.goodsName);
                    orderIntent.putExtra("quantity", order.quantity);
                    orderIntent.putExtra("orderPrice", order.orderPrice);
                    orderIntent.putExtra("price",order.price);
                    startActivity(orderIntent);
            }
        });
    }
    void createSpinner(){
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();
        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drum set");
        spinnerArrayList.add("keyboard");
        spinnerArrayList.add("saxophone");
        spinnerArrayList.add("flute");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    void createMap(){
        goodsMap = new HashMap();
        goodsMap.put("guitar", 500.00);
        goodsMap.put("drum set", 1000.00);
        goodsMap.put("keyboard", 750.00);
        goodsMap.put("saxophone", 600.00);
        goodsMap.put("flute", 450.00);
    }
    @SuppressLint("SetTextI18n")
    void updateQuantityField() {
        quantityTextView.setText("" + quantity);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double)goodsMap.get(goodsName);
        TextView priceTextView = findViewById(R.id.priceNumberTextView);
        priceTextView.setText("" + quantity * price);

        ImageView goodsImageView = findViewById(R.id.smallView1);
        switch(goodsName){
            case "guitar": goodsImageView.setImageResource(R.drawable.guitar2);
            break;
            case "drum set": goodsImageView.setImageResource(R.drawable.drums);
                break;
            case "keyboard": goodsImageView.setImageResource(R.drawable.keyboard);
                break;
            case "saxophone": goodsImageView.setImageResource(R.drawable.saxophone);
                break;
            case "flute": goodsImageView.setImageResource(R.drawable.flute);
                break;
            default:
             goodsImageView.setImageResource(R.drawable.guitar2);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }


}