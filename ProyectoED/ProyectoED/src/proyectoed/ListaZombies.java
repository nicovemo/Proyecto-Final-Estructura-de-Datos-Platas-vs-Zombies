/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoed;

/**
 *
 * @author PC-JPS01
 */
public class ListaZombies {
    
    class NodoZombie {
    Zombies zombie;
    NodoZombie siguiente;

    NodoZombie(Zombies zom) {
        this.zombie = zom;
        this.siguiente = null;
    }
}
    NodoZombie cabeza;

    public void agregar(Zombies z) {
        NodoZombie nuevo = new NodoZombie(z);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoZombie actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }
}
    

