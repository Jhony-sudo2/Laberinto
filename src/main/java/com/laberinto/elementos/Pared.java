package com.laberinto.elementos;

import java.awt.Color;

import javax.swing.border.LineBorder;

public class Pared extends Elemento {

    public Pared() {
        super(0);
        this.setBackground(Color.BLUE);
        this.setBorder(new LineBorder(Color.BLACK));
        this.AsignarImagen("pared.png");
        CambiarImagen();
    }
    
    
}
