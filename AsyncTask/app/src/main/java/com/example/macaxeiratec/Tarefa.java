package com.example.macaxeiratec;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Tarefa extends AsyncTask<String, String, Bitmap> {

    private ProgressDialog progress;
    private Context context;
    private TarefaInterface tarefaTi;

    public Tarefa(Context context, TarefaInterface tarefaTi){
        this.context = context;
        this.tarefaTi = tarefaTi;
    }


    @Override
    protected void onPreExecute() {
        progress = new ProgressDialog(context);
        progress.setMessage("Carregando Imagem...");
        progress.show();
    }

    @Override
    protected void onPostExecute(Bitmap aVoid) {
        tarefaTi.depoisDoDownload(aVoid);
        progress.dismiss();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        progress.setMessage(values[0]);
    }

    @Override
    protected Bitmap doInBackground(String... voids) {
        Bitmap img = null;

        try{
            publishProgress("Carregando...");
            URL url = new URL(voids[0]);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            InputStream input = conexao.getInputStream();
            img = BitmapFactory.decodeStream(input);
            publishProgress("Imagem Carregada");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;
    }
}
