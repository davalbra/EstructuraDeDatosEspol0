/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras1parcial.DoubleLinkedList;

/**
 *
 * @author david
 */
public class DoubleNodo<E> {

    E contenido;
    DoubleNodo<E> next;
    DoubleNodo<E> previous;
    public DoubleNodo(E contenido) {
        this.contenido = contenido;
        this.next = this;
        this.previous=this;
    }

    public E getContenido() {
        return contenido;
    }

    public void setContenido(E contenido) {
        this.contenido = contenido;
    }

    public DoubleNodo<E> getNext() {
        return next;
    }

    public void setNext(DoubleNodo<E> next) {
        this.next = next;
    }

    public DoubleNodo<E> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNodo<E> previous) {
        this.previous = previous;
    }
    
    
}
