package com.example.macaxeiratec;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements TarefaInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void depoisDoDownload(Bitmap bitmap) {
        ImageView iv = findViewById(R.id.image_baixada);
        iv.setImageBitmap(bitmap);
    }

    public void baixarImagem(View view){
        Tarefa tarefa = new Tarefa(this,this);
        tarefa.execute("https://pbs.twimg.com/profile_images/2295635216/yg5b32xx85jydlhzx18x_400x400.jpeg","test");
    }
        /*final ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("Carregando Imagem...");
        progress.show();


        new Thread(){
            public void run(){
                Bitmap img = null;
                try{
                    URL url = new URL("https://pbs.twimg.com/profile_images/2295635216/yg5b32xx85jydlhzx18x_400x400.jpeg");
                    HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                    InputStream input = conexao.getInputStream();
                    img = BitmapFactory.decodeStream(input);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                final Bitmap imgAux = img;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progress.setMessage("Imagem Carregada");
                        ImageView iv = findViewById(R.id.image_baixada);
                        iv.setImageBitmap(imgAux);
                        progress.dismiss();
                    }
                });

            }
        }.start();
    }*/

}
