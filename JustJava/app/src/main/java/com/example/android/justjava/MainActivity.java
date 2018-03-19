package com.example.android.justjava;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import static android.R.attr.name;
import static com.example.android.justjava.R.id.name_field;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the "+" button is clicked.
     */
    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this, "You cannot have more than 100 cups", Toast.LENGTH_SHORT).show();
            return;
        } else
            quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the "-" button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "You cannot have less than one cup", Toast.LENGTH_SHORT).show();
            return;
        } else
            quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox wippedCreamCheckbox = (CheckBox) findViewById(R.id.wipped_cream_checkbox);
        boolean hasWippedCream = wippedCreamCheckbox.isChecked();
        CheckBox choclateCheckbox = (CheckBox) findViewById(R.id.choclate_checkbox);
        boolean hasChoclate = choclateCheckbox.isChecked();
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        int price = calculatePrice(hasWippedCream, hasChoclate);


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order For " + name);
        intent.putExtra(Intent.EXTRA_TEXT,createOrderSummary(name, price, hasWippedCream, hasChoclate) );
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }


    }

    /**
     * Calculates the price of the order.
     */
    private int calculatePrice(boolean cream, boolean choclate) {
        int basePrice = 5;
        if (cream) basePrice += 1;
        if (choclate) basePrice += 2;
        return quantity * basePrice;
    }

    /**
     * summary of order
     *
     * @param price total price pf prder
     * @return text summary
     */
    private String createOrderSummary(String addName, int price, boolean addaWippedCream, boolean addChoclate) {
        String priceMessage = "Name: " + addName;
        priceMessage += "\nadd Wipped Cream? " + addaWippedCream;
        priceMessage += "\nadd Choclate? " + addChoclate;
        priceMessage += "\nQuntity:" + quantity;
        priceMessage = priceMessage + "\nTotal: $" + price + "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}