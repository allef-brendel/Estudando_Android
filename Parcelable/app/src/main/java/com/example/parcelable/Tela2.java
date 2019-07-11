package com.example.parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {

    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null){
            Cliente cliente = bundle.getParcelable("cliente");
            if (cliente != null){
               String text = (String.format("Nome: %s / Idade: %d", cliente.nome , cliente.codigo ));
               textView.setText(text);
            }else{
                String nome = intent.getStringExtra("nome");
                int idade = intent.getIntExtra("idade",-1);
                textView.setText(String.format("Nome: %s / Idade: %d", nome, idade));
            }

        }
    }
}
