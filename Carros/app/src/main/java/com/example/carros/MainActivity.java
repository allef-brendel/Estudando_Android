package com.example.carros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Carros> carros;
    CarrosAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listView = new ListView(this);
        setContentView(listView);

        carros = new ArrayList<>();
        carros.add(new Carros("Celta", 2010, 1, true, false));
        carros.add(new Carros("Uno", 2012, 2, true, false));
        carros.add(new Carros("Fiesta", 2009, 3, false, true));
        carros.add(new Carros("Gol", 2014, 0, true, false));

        adapter = new CarrosAdapter(this, carros);
        listView.setAdapter(adapter);
    }
}
