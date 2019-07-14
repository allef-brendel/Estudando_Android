package com.example.myexpandableadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExpandableListView listView = findViewById(R.id.expandableListView);

        List<String> listPe = new ArrayList<>();
        listPe.add("Caruaru");
        listPe.add("Recife");
        listPe.add("Petrolina");
        listPe.add("Olinda");

        List<String> listPb = new ArrayList<>();
        listPb.add("Sousa");
        listPb.add("João Pessoa");
        listPb.add("Rio Tinto");
        listPb.add("Campina Grande");

        Map<String, List<String>> dados = new HashMap<>();
        dados.put("PE",listPe);
        dados.put("PB",listPb);

        listView.setAdapter(new MeuExpandableAdapter(dados));
    }
}