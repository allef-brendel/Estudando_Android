package com.example.carros;

public class Carros {

    public String modelo;
    public int ano;
    public int fabricante;
    public boolean gasolina;
    public boolean etanol;

    public Carros(String modelo, int ano, int fabricante, boolean gasolina, boolean etanol) {
        this.modelo = modelo;
        this.ano = ano;
        this.fabricante = fabricante;
        this.gasolina = gasolina;
        this.etanol = etanol;
    }
}
