/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras1parcial;

import estructuras1parcial.TDALinkedList.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
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

    public static PriorityQueue<Integer> eliminarEnesimoMasGrande(PriorityQueue<Integer> queue, int n) {
        int size = queue.size();
        PriorityQueue<Integer> newQueue = new PriorityQueue<>((a, b) -> b - a);
        Integer tmp = null;
        for (int i = 0; i < size; i++) {
            if (i + 1 == n) {
                tmp = queue.poll();
            }
            Integer b = queue.poll();
            if (b != null) {
                newQueue.offer(b);
            }
        }
        if (tmp != null) {
            newQueue = validacion(newQueue, tmp);
        }
        return newQueue;
    }

    public static PriorityQueue<Integer> validacion(PriorityQueue<Integer> queue, int number) {
        int size = queue.size();
        PriorityQueue<Integer> newQueue1 = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < size; i++) {
            Integer b = queue.poll();
            if (b != number) {
                newQueue1.offer(b);
            }
        }
        return newQueue1;
    }

}
