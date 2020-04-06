package com.example.fooddatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = findViewById(R.id.scrollView);
        scrollView.removeAllViewsInLayout();
        DatabaseManager dbm = new DatabaseManager(this);
        ArrayList<String> list = dbm.getDish();
        GridLayout grid = new GridLayout (this);
        grid.setColumnCount(1);
        grid.setRowCount(list.size());
        for(String title : list) {
            TextView text = new TextView(this);
            text.setText(title);
            text.setTextSize(40);
            text.setClickable(true);
            text.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent i = new Intent(getApplicationContext(), ViewActivity.class);
                    i.putExtra("DISH", ((TextView) view).getText().toString());
                    startActivity(i);
                }
            });
            grid.addView(text);
        }
        scrollView.addView(grid);
    }

    public void addDish(View v){
        Intent i = new Intent(this, AddActivity.class);
        i.putExtra("ADD", true);
        startActivity(i);
    }

    public void searchCountry(View v){
        Intent i = new Intent(this, CountryActivity.class);
        startActivity(i);
    }
    public void deleteDish (View v){
        Intent i = new Intent(this, DeleteActivity.class);
        startActivity(i);
    }

}