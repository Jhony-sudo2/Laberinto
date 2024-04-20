package com.laberinto.elementos;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.laberinto.Main;

public abstract class Elemento  extends JLabel{
    private int Tipo;
    private ImageIcon imagenDefecto;

    public Elemento(int Tipo){
        this.Tipo = Tipo;
    }

    public ImageIcon getDefecto(){
        return this.imagenDefecto;
    }

    public int getTipo(){
        return this.Tipo;
    }

    public void setTipo(int tmp){
        this.Tipo = tmp;
    }

    public void CambiarImagen(){
        this.setIcon(imagenDefecto);
    }

    public void AsignarImagen(String nombre){
        this.imagenDefecto = createImageIcon(nombre);
        this.setIcon(this.imagenDefecto);
    }

    public void Ejecutar(){

    }
    protected ImageIcon createImageIcon(String path) {
        // Crear un ImageIcon desde una ruta de archivo
        URL imgURL = Main.class.getClassLoader().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("No se pudo encontrar el archivo de imagen: " + path);
            return null;
        }
    }
}
