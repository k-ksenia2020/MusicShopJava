package com.udemy.musicshopjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setTitle("Your Order");

        Intent receivedOrderIntent = getIntent();
        String userName = receivedOrderIntent.getStringExtra("userNameForIntent");
        String goodsName =receivedOrderIntent.getStringExtra("goodsName");
        int quantity = receivedOrderIntent.getIntExtra("quantity",0);
        double orderPrice = receivedOrderIntent.getDoubleExtra("orderPrice",0);
        double price = receivedOrderIntent.getDoubleExtra("price",0)

        TextView orderTextView = findViewById(R.id.orderTextView);
        orderTextView.setText("Customer's Name: "+ userName + "\n" +
                "Good's title" + goodsName + "\n" +
                "Quantity"+ quantity+ "\n" +
                "Item price"+ price + "\n" +
                "Totel Price"+ orderPrice);

    }
}