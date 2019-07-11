package com.example.onsaveinstacestate;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private ArrayList<Bitmap> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            ListaImgs listaImgs = (ListaImgs) savedInstanceState.getSerializable(ListaImgs.KEY);
            arrayList = listaImgs.img;
        }

        if(arrayList == null || arrayList.size()==0){
            Log.i("msg: ","entrei 1");
            loadImg();

        }else{
            Log.i("msg: ","entrei 2");
            buildImg();
        }
    }

    //BAIXAR IMAGENS DA WEB
    private void loadImg() {

        new Thread(){
            @Override
            public void run() {
                try{

                    for (int i = 0; i < 10; i++){

                        URL url = new URL("https://www.thiengo.com.br/img/system/logo/logo-thiengo-calopsita-70x70.png");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        InputStream input = connection.getInputStream();
                        arrayList.add(BitmapFactory.decodeStream(input));
                    }

                }catch (IOException e){

                }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            buildImg();
                        }
                    });

            }
        }.start();
    }

    //COLOCANDO AS IMAGENS NO LAYOUT
    public void buildImg(){
        LinearLayout linearLayout = findViewById(R.id.linearlayout);

        for (int i = 0; i<arrayList.size(); i++){
            ImageView imageView = new ImageView(getBaseContext());
            imageView.setImageBitmap(arrayList.get(i));
            linearLayout.addView(imageView);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable(ListaImgs.KEY, new ListaImgs(arrayList));
    }
}
