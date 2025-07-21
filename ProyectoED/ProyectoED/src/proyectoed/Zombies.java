/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoed;

import javax.swing.*;

/**
 *
 * @author Nicole Venegas
 */
public class Zombies {
    private int vida; 
    private int ataque;
    private ImageIcon imagen;
    //private String tipo;

    
    public Zombies (int vida, int ataque){
        this.vida = vida;
        this.ataque = ataque;
        this.imagen = new ImageIcon(getClass().getResource("/proyectoed/img/zombie.png"));
        
    }

    Zombies() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

   public ImageIcon getImagen() {
        return imagen;
    }

    void setFila(int fila) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setColumna(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    int getFila() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    int getColumna() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
