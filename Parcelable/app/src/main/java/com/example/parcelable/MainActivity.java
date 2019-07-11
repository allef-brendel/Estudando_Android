package com.example.parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = findViewById(R.id.botao);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cliente cliente = new Cliente("Zezin",53);
                Intent intent3 = new Intent(MainActivity.this, Tela2.class);
                intent3.putExtra("cliente",cliente);
                startActivity(intent3);
            }
        });

        }
    }

