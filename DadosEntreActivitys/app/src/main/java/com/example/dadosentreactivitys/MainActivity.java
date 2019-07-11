package com.example.dadosentreactivitys;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private EditText email;
    private Button tela1;
    private Button tela2;

    public static final int COSTANTE_TELA_1 = 1;
    public static final int COSTANTE_TELA_2 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nome);
        email = findViewById(R.id.email);
        tela1 = findViewById(R.id.tela1);
        tela2 = findViewById(R.id.tela2);

        tela1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("nome", nome.getText().toString());
                bundle.putString("email", email.getText().toString());

                Intent intent = new Intent(MainActivity.this, Tela1.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, COSTANTE_TELA_1);
            }
        });

        tela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("nome", nome.getText().toString());
                bundle.putString("email", email.getText().toString());

                Intent intent = new Intent(MainActivity.this, Tela2.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, COSTANTE_TELA_2 );
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == COSTANTE_TELA_1){
            Bundle bundle = data.getExtras();
            if (bundle != null){
                String msg = bundle.getString("msg");
                Toast.makeText(this, "Tela1 >> Resultado: "+ resultCode+" |Msg: "+ msg, Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == COSTANTE_TELA_2){
            Bundle bundle = data.getExtras();
            if (bundle != null){
                String msg = bundle.getString("msg");
                Toast.makeText(this, "Tela2 >> Resultado: "+ resultCode+" |Msg: "+ msg, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
