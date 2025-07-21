/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoed;

/**
 *
 * @author Nicole Venegas
 */

public class ListaUsuarios {
    private NodoUsuario cabeza;

    public ListaUsuarios() {
        cabeza = null;
    }

    public void agregarUsuario(String nombre) {
        NodoUsuario nuevo = new NodoUsuario(nombre);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoUsuario actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public void mostrarUsuarios() {
        NodoUsuario actual = cabeza;
        while (actual != null) {
            System.out.println(actual.nombre);
            actual = actual.siguiente;
        }
    }
    public int getCantidad() {
        int count = 0;
        NodoUsuario actual = cabeza;
        while (actual != null) {
            count++;
             actual = actual.siguiente;
    }
    return count;
}
    
    public String get(int index) {
    NodoUsuario actual = cabeza;
    int contador = 0;
    while (actual != null) {
        if (contador == index) {
            return actual.nombre;
        }
        contador++;
        actual = actual.siguiente;
    }
    return null; 
}

    
    public class NodoUsuario {
    public String nombre;
    public NodoUsuario siguiente;

    public NodoUsuario(String nombre) {
        this.nombre = nombre;
        this.siguiente = null;
    }
}
}

        
   


