package com.example.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements JogoDaVelhaView.JogoDaVelhaListener, View.OnClickListener {

    JogoDaVelhaView jogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jogo = findViewById(R.id.jogoDaVelha);
        jogo.setListener(this);

        findViewById(R.id.botaoReiniciar).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        jogo.reiniciarJogo();
    }

    @Override
    public void fimDeJogo(int vencedor) {
        String mensagem;

        switch (vencedor){
            case JogoDaVelhaView.XIS:
                mensagem = "X é o vencedor";
                break;
            case JogoDaVelhaView.BOLA:
                mensagem = "O é o vencedor";
                break;
            default:
                mensagem = "Empatou!";
        }
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}
