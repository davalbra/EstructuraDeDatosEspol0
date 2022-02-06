/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras1parcial.TDALinkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author david
 */
public class LinkedList<E> {

    private Nodo<E> first;
    private Nodo<E> last;

    public boolean addFirst(E contenido) {
        Nodo<E> nuevo = new Nodo<>(contenido);
        if (isEmpty()) {
            first = nuevo;
            last = nuevo;
            return true;
        }

        nuevo.setNext(first);
        first = nuevo;
        return true;
    }

    public boolean addLast(E contenido) {
        Nodo<E> nuevo = new Nodo<>(contenido);
        if (isEmpty()) {
            first = nuevo;
            last = nuevo;
            return true;
        }

        last.setNext(nuevo);
        last = nuevo;
        return true;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        int contador = 0;
        for (Nodo<E> n = first; n != null; n = n.getNext()) {
            contador++;
        }
        return contador;
    }

    public Map<LinkedList<E>, Integer> contarDistintosEnSublistas(int k) {
        Map<LinkedList<E>, Integer> mapa = new HashMap<>();

        for (Nodo<E> n = first; n != null; n = n.getNext()) {
            if (cantidadRestante(n) >= k) {
                LinkedList<E> revisar = contenido(k, n);
                mapa.put(revisar, contarUnicos(revisar));
            }
        }
        return mapa;
    }

    public int contarUnicos(LinkedList<E> lista) {
        Set<E> set = new HashSet<>();
        for (Nodo<E> n = lista.getFirst(); n != null; n = n.getNext()) {
            set.add(n.getContenido());
        }
        return set.size();
    }

    public LinkedList<E> contenido(int i, Nodo<E> nodo) {
        LinkedList<E> listaReturn = new LinkedList<>();
        for (Nodo<E> n = nodo; listaReturn.size() < i; n = n.getNext()) {
            listaReturn.addLast(n.getContenido());
        }
        return listaReturn;
    }

    public int cantidadRestante(Nodo<E> nodo) {
        int cantidad = 0;
        for (Nodo<E> n = nodo; n != null; n = n.getNext()) {
            cantidad++;
        }
        return cantidad;
    }

    public void imprimir() {
        for (Nodo<E> n = first; n != null; n = n.getNext()) {
            System.out.print(" " + n.getContenido());
        }
        System.out.println("");
    }

    public Nodo<E> getFirst() {
        return first;
    }

    public void setFirst(Nodo<E> first) {
        this.first = first;
    }

    public Nodo<E> getLast() {
        return last;
    }

    public void setLast(Nodo<E> last) {
        this.last = last;
    }

    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            Nodo<E> n = first;

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

}
