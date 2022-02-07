/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras1parcial.DoubleLinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author david
 */
public class DoubleLinkedList<E> {

    private DoubleNodo<E> last;

    public boolean addFirst(E contenido) {
        DoubleNodo<E> nuevo = new DoubleNodo<>(contenido);
        if (isEmpty()) {
            last = nuevo;
            return true;
        }
        last.getNext().setPrevious(nuevo);
        nuevo.setNext(last.getNext());
        nuevo.setPrevious(last);
        last.setNext(nuevo);
        return true;
    }

    public boolean addLast(E contenido) {
        DoubleNodo<E> nuevo = new DoubleNodo<>(contenido);
        if (isEmpty()) {
            addFirst(contenido);
            return true;
        }

        last.getPrevious().setNext(nuevo);
        nuevo.setNext(last);
        nuevo.setPrevious(last.getPrevious());
        last.setPrevious(nuevo);
        last = nuevo;
        return true;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public int size() {
        int contador = 1;
        for (DoubleNodo<E> n = last; n != n.getPrevious(); n = n.getNext()) {
            contador++;
        }
        return contador;
    }

    public boolean add(int index, E contenido) {
        DoubleNodo<E> nodo = new DoubleNodo<>(contenido);
        if (index > this.size()) {
            return false;
        }
        if (index == 0) {

            addFirst(contenido);

        }
        if (index == size()) {
            addLast(contenido);
        }
        int tmp = 0;
        for (DoubleNodo<E> n = last.getNext(); tmp < index - 1; n = n.getNext()) {
            if (tmp == index - 1) {
                n.getNext().setPrevious(nodo);
                n.setNext(nodo);
                nodo.setNext(n.getNext());
                nodo.setPrevious(n);
            }
            tmp++;
        }
        return true;
    }

    public boolean remove(int index) {
        if (index > size()) {
            return false;
        }
        if (index == 0) {
            removeFirst();
        }
        if (index == size()) {
            removeLast();
        }
        int tmp = 0;
        for (DoubleNodo<E> n = last.getNext(); tmp < index - 1; n = n.getNext()) {
            if (tmp == index - 1) {
                n.getNext().getNext().setPrevious(n);
                n.setNext(n.getNext().getNext());
                return true;
            }
        }
        return false;
    }

    public boolean removeFirst() {
        if (size() == 1) {
            last = null;
            return true;
        }
        last.getNext().getNext().setPrevious(last);
        last.setNext(last.getNext().getNext());
        return true;
    }

    public boolean removeLast() {
        int tmp = 0;
        int index = size();
        for (DoubleNodo<E> n = last.getNext(); tmp < index - 1; n = n.getNext()) {
            if (tmp == index - 1) {
                n.setNext(null);
                last = n;
                return true;
            }
        }
        return false;
    }

    public E get0() {
        return last.getNext().getContenido();
    }

    public E getN() {
        return last.getContenido();
    }

    public E get(int index) {
        if (index > size()) {
            return null;
        }
        int tmp = 0;
        for (DoubleNodo<E> n = last.getNext(); tmp < index; n = n.getNext()) {
            if (tmp == index) {
                return n.getContenido();
            }
        }
        return null;
    }

    public void imprimir() {
        for (DoubleNodo<E> n = last.getNext(); n != last; n = n.getNext()) {
            System.out.print(" " + n.getContenido());
        }
        System.out.println("");
    }

    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            DoubleNodo<E> n = last.getNext();

            @Override
            public boolean hasNext() {
                return n.getNext() != null;
            }

            @Override
            public E next() {
                return n.getContenido();
            }
        };
        return it;
    }

    public DoubleNodo<E> getLast() {
        return last;
    }

    public void setLast(DoubleNodo<E> last) {
        this.last = last;
    }

}
