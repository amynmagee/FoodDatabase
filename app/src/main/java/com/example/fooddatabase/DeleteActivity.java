package com.example.fooddatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteActivity  extends AppCompatActivity {

    public EditText searchBar;

    @Override
    public void
    onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        searchBar = findViewById(R.id.searchBar);

    }

    public void deleteFood (View v){
        String delete = searchBar.getText().toString();
        DatabaseManager dbm = new DatabaseManager(this);
        dbm.delete(delete);
        finish();

    }
}