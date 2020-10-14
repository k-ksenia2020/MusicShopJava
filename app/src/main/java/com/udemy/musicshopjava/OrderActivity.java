package com.udemy.musicshopjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    String[] addresses = {"rajasranee@gmail.com"};
    String subject = "Order from Music Shop";
    String emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setTitle("Your Order");

        Intent receivedOrderIntent = getIntent();
        String userName = receivedOrderIntent.getStringExtra("userNameForIntent");
        String goodsName = receivedOrderIntent.getStringExtra("goodsName");
        int quantity = receivedOrderIntent.getIntExtra("quantity", 0);
        double orderPrice = receivedOrderIntent.getDoubleExtra("orderPrice", 0);
        double price = receivedOrderIntent.getDoubleExtra("price", 0);

        emailText = "Customer's Name: " + userName + "\n" +
                "Good's title: " + goodsName + "\n" +
                "Quantity: " + quantity + "\n" +
                "Item price: " + price + "\n" +
                "Total Price: " + orderPrice;
        TextView orderTextView = findViewById(R.id.orderTextView);
        orderTextView.setText(emailText);

        findViewById(R.id.submitOrderBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, addresses);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, emailText);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }

        });
    }
}