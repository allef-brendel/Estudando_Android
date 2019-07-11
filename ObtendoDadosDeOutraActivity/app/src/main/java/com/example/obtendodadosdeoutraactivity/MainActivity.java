package com.example.obtendodadosdeoutraactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ESTADO = 1;
    private static final String STATE_ESTADO = "estado";

    private Button botao1;
    private String estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao1 = findViewById(R.id.botao1);

        if (savedInstanceState != null) {
            estado = savedInstanceState.getString(STATE_ESTADO);
            botao1.setText(estado);
        }

        botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TelaSelecaoActivity.class);
                intent.putExtra(TelaSelecaoActivity.EXTRA_ESTADO, estado);
                startActivityForResult(intent, REQUEST_ESTADO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUEST_ESTADO) {
            estado = data.getStringExtra(TelaSelecaoActivity.EXTRA_RESULTADO);
            if (estado != null) {
                botao1.setText(estado);
            }
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_ESTADO, estado);
    }
}
