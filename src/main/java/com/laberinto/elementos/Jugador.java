package com.laberinto.elementos;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.border.LineBorder;

public class Jugador extends Elemento{
    private int Fila;
    private int Columna;
    public Jugador() {
        super(1);
        this.setBackground(Color.BLACK);
        this.setBorder(new LineBorder(Color.WHITE));
        this.setOpaque(true);
    }
    

    public int getFila() {
        return Fila;
    }


    public void setFila(int fila) {
        Fila = fila;
    }


    public int getColumna() {
        return Columna;
    }


    public void setColumna(int columna) {
        Columna = columna;
    }


    public void Mover(KeyEvent tecla){

    }

    

    
}
