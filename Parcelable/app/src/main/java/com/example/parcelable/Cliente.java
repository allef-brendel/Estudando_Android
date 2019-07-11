package com.example.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class Cliente implements Parcelable {

    public String nome;
    public int codigo;


    public Cliente(String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nome);
        parcel.writeInt(codigo);
    }

    private Cliente(Parcel in) {
        nome = in.readString();
        codigo = in.readInt();
    }

    public static final Parcelable.Creator<Cliente> CREATOR = new Parcelable.Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
}
