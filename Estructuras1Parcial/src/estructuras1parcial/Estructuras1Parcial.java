/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras1parcial;

import estructuras1parcial.TDALinkedList.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author david
 */
public class Estructuras1Parcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        lista.addFirst(1);
        lista.addFirst(2);
        lista.addFirst(2);
        lista.addFirst(2);
        lista.addFirst(2);
        lista.addFirst(3);
        lista.addLast(4);
        lista.addLast(5);
        lista.addLast(6);
        lista.imprimir();
        Map<LinkedList<Integer>, Integer> mapa = lista.contarDistintosEnSublistas(2);
        for (Map.Entry<LinkedList<Integer>, Integer> entry : mapa.entrySet()) {
            entry.getKey().imprimir();
            System.out.println(" valor: " + entry.getValue());
        }

    }

    public void eliminarEnesimoMasGrande(int numero) {

        Queue<T> cola = new PriorityQueue<>();

    }

}
