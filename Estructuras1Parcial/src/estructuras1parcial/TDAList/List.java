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
public interface List<E> {

    public boolean addFirst(E e);

    public boolean addLast(E e);

    public E removeFirst();

    public E removeLast();

    public int size();

    public void clear();

    public E get(int i);

}
