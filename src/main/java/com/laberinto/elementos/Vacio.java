package com.laberinto.elementos;

import java.awt.Color;

import javax.swing.border.LineBorder;

public class Vacio  extends Elemento{

    public Vacio( ) {
        super(3);
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(Color.WHITE));
        this.setOpaque(true);
    }
    
}
