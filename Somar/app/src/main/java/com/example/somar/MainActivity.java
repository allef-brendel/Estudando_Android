package com.example.somar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviarFormulario(View view){

        nome = findViewById(R.id.numero1);
        email = findViewById(R.id.numero2);

        Bundle bundle = new Bundle();
        bundle.putString("nome", nome.getText().toString());
        bundle.putString("email", email.getText().toString());

        Intent intent = new Intent(this,RecebeFormulario.class);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
