package com.example.somar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RecebeFormulario extends AppCompatActivity {

    private TextView nome1;
    private TextView email2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recebe_formulario);

            nome1 = findViewById(R.id.text1);
            email2 = findViewById(R.id.text2);

            Intent intent = getIntent();

            if(intent != null){
                Bundle bundle = intent.getExtras();

                if (bundle != null) {
                    String nome = bundle.getString("nome");
                    String email = bundle.getString("email");

                    nome1.setText(nome);
                    email2.setText(email);
            }
        }
    }
}
