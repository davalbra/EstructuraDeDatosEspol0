/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras1parcial.TDAList;

/**
 *
 * @author david
 */
public class List<E> {

    int effectiveSize;
    int maxapacity;
    E[] contenido;

    public List() {
        maxapacity = 10;
        effectiveSize = 0;
        contenido = (E[]) new Object[10];
    }

    public void imprimir() {
        for (int i = 0; i < effectiveSize; i++) {
            System.out.print(" " + contenido[i]);
        }
        System.out.println("");
    }

    public void addFirst(E content) {
        if (effectiveSize == maxapacity) {
            addCapacity();
        }
        for (int i = effectiveSize; i >= 0; i--) {
            contenido[i + 1] = contenido[i];
        }
        contenido[0] = content;
        effectiveSize++;
    }

    public void addLast(E content) {
        if (effectiveSize == maxapacity) {
            addCapacity();
        }
        contenido[effectiveSize] = content;
    }

    public boolean add(int index, E content) {
        if (index > effectiveSize) {
            return false;
        }
        if (index == 0) {
            addFirst(content);
            return true;
        }
        if (index == effectiveSize) {
            addLast(content);
            return true;
        }
        for (int i = effectiveSize; i < index; i--) {
            contenido[i + 1] = contenido[i];
        }

        contenido[index] = content;
        return true;
    }

    public void removeFirst() {
        for (int i = 0; i < effectiveSize; i++) {
            contenido[i] = contenido[i + 1];
        }
        effectiveSize--;
    }

    public void removeLast() {
        effectiveSize--;
    }

    public boolean remove(int index) {
        if (index > effectiveSize) {
            return false;
        }
        if (index == 0) {
            removeFirst();
            return true;
        }
        if (index == effectiveSize) {
            removeLast();
            return true;
        }
        for (int i = index; i < effectiveSize; i++) {
            contenido[i] = contenido[i + 1];
        }
        effectiveSize--;
        return true;
    }

    public boolean IsEmpty() {
        return effectiveSize == 0;
    }

    public int size() {
        return effectiveSize;
    }

    public void addCapacity() {
        maxapacity = maxapacity * 2;
        E[] tmp = (E[]) new Object[maxapacity];
        for (int i = 0; i < 10; i++) {
            tmp[i] = contenido[i];
        }
        contenido = tmp;
    }
}
