package com.example.onsaveinstacestate;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaImgs implements Serializable {

    public ArrayList<Bitmap> img;
    public static final String KEY = "imagens";

    public ListaImgs(ArrayList<Bitmap> img){
        this.img = img;
    }

}
