/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.dequeuearray;

/**
 *
 * @author Mr.Smart
 */
public class DEqueueArray {

    private int array[];
    private int size;
    private int front;
    private int rear;

    DEqueueArray(int size) {
        this.size = size;
        array = new int[size];
        front = -1;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    boolean isFull() {
        return ((front == 0 && rear == size - 1) || front == rear + 1);
    }

    public void insertLast(int data) {

        if (isFull()) {
            System.out.println("OverFlow...");
            return;
        }
        array[rear++] = data;

    }

    public void println() {
        for (int i = 0; i < rear; i++) {
            System.out.print(array[i] + "--->");
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        DEqueueArray de = new DEqueueArray(10);
        de.insertLast(4);
        de.insertLast(5);
        de.insertLast(3);
        de.insertLast(7);
        de.insertLast(9);
        de.insertLast(2);
        de.insertLast(1);
        de.println();

    }
}
