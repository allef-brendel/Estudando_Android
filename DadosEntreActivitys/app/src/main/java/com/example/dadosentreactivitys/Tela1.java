package com.example.dadosentreactivitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tela1 extends AppCompatActivity {

    private TextView textNome;
    private TextView textEmail;
    private Button aceitar;
    private Button rejeitar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        textNome = findViewById(R.id.nometela1);
        textEmail = findViewById(R.id.emailtela1);
        aceitar = findViewById(R.id.buttontela1);
        rejeitar = findViewById(R.id.buttontela11);

        Intent intent = getIntent();

        if (intent != null){
            Bundle bundle = intent.getExtras();

            if (bundle != null){
                String nome = bundle.getString("nome");
                String email = bundle.getString("email");

                textNome.setText("Nome: "+nome);
                textEmail.setText("Email: "+email);
            }
        }

        aceitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aceitou();
            }
        });

        rejeitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rejeitou();
            }
        });

    }
    public void aceitou(){
        Intent intent1 = new Intent();
        intent1.putExtra("msg", "Aceitou");

        setResult(1, intent1);
        finish();
    }

    public void rejeitou(){
        Intent intent1 = new Intent();
        intent1.putExtra("msg", "Rejeitou");

        setResult(2, intent1);
        finish();
    }

}
