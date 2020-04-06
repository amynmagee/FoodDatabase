package com.example.fooddatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity  extends AppCompatActivity {

    private EditText dishBox;
    private EditText countryBox;
    private EditText typeBox;
    private Button addButton;
    private boolean add;

    @Override
    public void
    onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        dishBox = findViewById(R.id.dishBox);
        countryBox = findViewById(R.id.countryBox);
        typeBox = findViewById(R.id.typeBox);
        addButton = findViewById(R.id.addButton);
        Intent i = getIntent();
        add = i.getBooleanExtra("ADD", true);
        if (add) {
            addButton.setText("ADD");
        } else {
            addButton.setText("EDIT");
            dishBox.setText(i.getStringExtra("DISH"));
            countryBox.setText(i.getStringExtra("COUNTRY"));
            typeBox.setText(i.getStringExtra("TYPE"));
        }

    }
    public void addFood (View v){
        String dish = dishBox.getText().toString();
        String country = countryBox.getText().toString();
        String type = typeBox.getText().toString();
        DatabaseManager dbm = new DatabaseManager(this);
        if (add)
            dbm.insert(dish, country, type);
        else
            dbm.updateByFood(dish, country, type);

        finish();
    }
}
