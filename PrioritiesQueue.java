/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.prioritiesqueue;

/**
 *
 * @author Mr.Smart
 */
public class PrioritiesQueue {

    private int max;
    private int array[];
    private int item;
    private int size;

    PrioritiesQueue(int size) {
        this.size = size;
        array = new int[size];
        item = max = 0;
    }

    public void addData(int data) {

        int j;
        if (item == 0) {
            array[item++] = data;
        } else {
            for (j = item - 1; j >= 0; j--) {
                if (data < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }

            }
            if (item != size) {
                array[j + 1] = data;
                item++;
            } else {
                System.out.println("OverFlow....." + data);
            }
        }
    }

    //descending order
    public void addData2() {

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    item = array[i];
                    array[i] = array[j];
                    array[j] = item;
                }
            }
        }
    }

    public void range(int x, int y) {
        for (int i = 0; i < size; i++) {
            if (array[i] > x && array[i] < y) {

                System.out.print(array[i] + "  ");

            } 
        }
    }

    public int getMax() {
        return array[--size];
    }

    public int removeMax() {

        return array[size];
    }

    public void printValues() {

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "-->");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        PrioritiesQueue queue = new PrioritiesQueue(10);
        queue.addData(6);
        queue.addData(4);
        queue.addData(2);
        queue.addData(9);
        queue.addData(3);
        queue.addData(8);
        queue.addData(5);
        queue.addData(10);
        queue.addData(11);
        queue.addData(12);
        queue.addData(13);

        queue.printValues();
        System.out.println("desending order...");
        queue.addData2();
        queue.printValues();
        queue.range(6, 10);
        /*  System.out.println("maximum value..." + queue.getMax());
        System.out.println("remove maximum value..." + queue.removeMax());
        queue.printValues();
        System.out.println("desending order...");
        queue.addData2();
        queue.printValues();*/
    }
}
