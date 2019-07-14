package com.example.autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> list = new ArrayList<String>();
        list.add("Caruaru");
        list.add("Cabo de Santo Agostinho");
        list.add("Recife");
        list.add("São Paulo");
        list.add("Santos");
        list.add("Santa Cruz");

        MeuAutoCompleteAdapter adapter = new MeuAutoCompleteAdapter(this, android.R.layout.simple_dropdown_item_1line, list);
        AutoCompleteTextView actv = findViewById(R.id.autoCompleteTextView);
        actv.setAdapter(adapter);
    }
}
