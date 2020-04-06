package com.example.fooddatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity  extends AppCompatActivity {

    private TextView dishView;
    private TextView countryView;
    private TextView typeView;

    @Override
    public void
    onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        dishView = findViewById(R.id.dishView);
        countryView = findViewById(R.id.countryView);
        typeView = findViewById(R.id.typeView);

        DatabaseManager dbm = new DatabaseManager(this);
        Intent i = getIntent();
        String title = i.getStringExtra("DISH");
        String[] entry = dbm.get(title);
        dishView.setText(entry[0]);
        countryView.setText(entry[1]);
        typeView.setText(entry[2]);

    }

    public void editPressed(View v){
        Intent i = new Intent(this, AddActivity.class);
        i.putExtra("ADD", false);
        i.putExtra("DISH", dishView.getText().toString());
        i.putExtra("COUNTRY", countryView.getText().toString());
        i.putExtra("TYPE", typeView.getText().toString());
        startActivity(i);
    }
}
