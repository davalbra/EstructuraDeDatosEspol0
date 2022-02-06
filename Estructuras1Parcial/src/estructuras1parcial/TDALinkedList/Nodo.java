/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras1parcial.TDALinkedList;

/**
 *
 * @author david
 */
public class Nodo<E> {

    E contenido;
    Nodo<E> next;

    public Nodo(E contenido) {
        this.contenido = contenido;
        this.next = null;
    }

    public E getContenido() {
        return contenido;
    }

    public void setContenido(E contenido) {
        this.contenido = contenido;
    }

    public Nodo<E> getNext() {
        return next;
    }

    public void setNext(Nodo<E> next) {
        this.next = next;
    }
    
    
}
