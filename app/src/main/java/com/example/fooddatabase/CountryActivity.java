package com.example.fooddatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CountryActivity  extends AppCompatActivity {

    public EditText searchBar;

    @Override
    public void
    onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);setContentView(R.layout.activity_country);

        searchBar = findViewById(R.id.searchBar);

    }

    public void searchDB(View v){
        Intent i = new Intent(this, CountryViewActivity.class);
        String country = searchBar.getText().toString();
        i.putExtra("COUNTRY", country);
        startActivity(i);
    }

}
