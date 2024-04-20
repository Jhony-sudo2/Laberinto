package com.laberinto.tablero;
import java.awt.Color;
import java.awt.event.KeyEvent;
import com.laberinto.elementos.Elemento;
import com.laberinto.elementos.Jugador;
import com.laberinto.elementos.Oro;
import com.laberinto.elementos.Pared;
import com.laberinto.elementos.Vacio;
import javax.swing.JPanel;

public class Tablero {
    private int numeroFilas;
    private int numeroColumnas;
    private int anchofigura;
    private int altofigura;
    private int[][] Laberinto;
    private Elemento[][] Tablero;
    private JPanel Contenedor;
    private Jugador jugador = new Jugador();

    public Tablero(int filas,int columnas,JPanel contLabel){
        this.Contenedor = contLabel;
        this.numeroColumnas = columnas;
        this.numeroFilas = filas;
        this.Laberinto = new int[filas][columnas];
        this.Tablero = new Elemento[filas][columnas];
        anchofigura = 40;
        altofigura = 40;
    }

    public void pintar(){
        int [][] tmp = GenerarLaberinto();
        for(int i=0;i<numeroFilas;i++){
            for(int x=0;x<numeroColumnas;x++){
                int valor = tmp[i][x];
                if(valor == 1){
                    Tablero[i][x] = new Pared();
                    Tablero[i][x].setBounds(x*40,i*40, anchofigura,altofigura);
                    Contenedor.add(Tablero[i][x]);
                }else if(valor == 0){
                    Tablero[i][x] = new Vacio();
                    Tablero[i][x].setBounds(x*40,i*40, anchofigura,altofigura);
                    Contenedor.add(Tablero[i][x]);
                }else if(valor == 2){
                    jugador.setBounds(x*40,i*40,anchofigura,altofigura);
                    Tablero[i][x] = jugador;
                    jugador.setFila(i);
                    jugador.setColumna(x);
                    Contenedor.add(Tablero[i][x]);
                }else if(valor == 3){
                    Tablero[i][x] = new Oro();
                    Tablero[i][x].setBounds(x*40,i*40, anchofigura,altofigura);
                    Contenedor.add(Tablero[i][x]);
                }
            }
        }
    }

    public void Mover(KeyEvent tecla){
        int nuevaFila = jugador.getFila();
        int nuevaColumna = jugador.getColumna();
        //Izquierda
        if(tecla.getKeyCode() == 37){
            nuevaColumna -= 1;
        //Derecha
        } else if(tecla.getKeyCode() == 39){
            nuevaColumna += 1;
        //Abajo
        } else if(tecla.getKeyCode() == 40){
            nuevaFila += 1;
        //Arriba
        } else if(tecla.getKeyCode() == 38){
            nuevaFila -= 1;
        }
        // Verificar si la nueva posición está dentro de los límites del tablero
        if (nuevaFila >= 0 && nuevaFila < Tablero.length && nuevaColumna >= 0 && nuevaColumna < Tablero[0].length) {
            // Verificar si la nueva posición es una pared
            if (Tablero[nuevaFila][nuevaColumna].getTipo() == 0) {
                System.out.println("NO SE PUEDE MOVER, ES PARED");
            } else {
                // Actualizar la posición del jugador en el tablero
                Tablero[jugador.getFila()][jugador.getColumna()].setBackground(Color.WHITE);;
                jugador.setFila(nuevaFila);
                jugador.setColumna(nuevaColumna);
                Tablero[nuevaFila][nuevaColumna].setBackground(Color.BLACK);
                // Volver a dibujar la interfaz de usuario para reflejar el movimiento del jugador
                Contenedor.repaint();
            }
        } else {
            System.out.println("NO SE PUEDE MOVER, FUERA DE LOS LÍMITES DEL TABLERO");
        }
    }

    public int[][] getLaberinto(){
        return this.Laberinto;
    }

    public int[][] GenerarLaberinto(){
        int tmp[][] =
            {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            { 1,2,0,0,1,0,0,0,0,0,0,1,1,1,0,0,1,1,3,0,0,1,1},
            { 1,1,1,0,1,0,1,0,1,1,1,0,0,0,1,0,0,0,1,1,0,1,1},
            { 1,1,0,0,0,0,1,0,0,1,0,0,1,0,1,0,1,0,0,1,0,1,1},
            { 1,1,0,1,1,1,1,0,1,0,0,1,1,0,1,0,0,1,0,1,0,1,1},
            { 1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,1,0,0,1,0,1,1},
            { 1,1,1,0,1,0,1,1,1,1,0,0,0,0,1,0,3,1,0,1,0,1,1},
            { 1,1,0,0,0,1,0,0,0,1,0,1,1,1,0,0,1,0,0,1,0,1,1},
            { 1,1,0,1,1,0,0,1,0,1,0,0,0,0,0,1,0,0,1,1,0,1,1},
            { 1,1,0,1,0,0,1,1,0,1,0,1,1,1,1,0,0,1,0,0,0,1,1},
            { 1,1,0,0,0,1,1,1,0,1,0,3,0,0,3,1,0,0,0,1,0,1,1},
            { 1,1,0,1,0,0,0,1,0,0,0,1,1,1,1,0,0,1,0,1,0,0,1},
            { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
        Laberinto = tmp;
        return tmp;
    }

}
