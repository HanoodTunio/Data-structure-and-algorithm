/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.programmingprojects;

/**
 *
 * @author Mr.Smart
 */
public class ProgrammingProjects {

    private int size;
    private char array[];
    private int rear;

    ProgrammingProjects(int size) {
        this.size = size;
        array = new char[size];
        rear = -1;
    }

    public int parent(int i) {
        return i / 2;
    }

    public int leftChild(int i) {
        return i * 2;
    }

    public int rightChild(int i) {
        return i * 2 + 1;
    }

    public void swiftUp(int i) {
        while (i > 0 && (int)array[parent(i)] > (int)array[i]) {
            char temp = array[parent(i)];
            array[parent(i)] = array[i];
            array[i] = temp;
            i = parent(i);
        }
    }

    public void swiftDown(int i) {
        int maxindex = i;
        int l = leftChild(i);
        if (l < size && (int)array[l] < (int)array[maxindex]) {
            maxindex = l;
        }

        int r = rightChild(i);
        if (r < size && (int)array[r] < (int)array[maxindex]) {
            maxindex = r;
        }

        if (i != maxindex) {
            char temp = array[i];
            array[i] = array[maxindex];
            array[maxindex] = temp;
            swiftDown(maxindex);
        }
    }

    public void insertData(char data) {

        rear = rear + 1;
        array[rear] = data;
        swiftUp(rear);

    }
    
    public void printData(){
        for(int i=0 ; i < array.length ; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ProgrammingProjects tree = new ProgrammingProjects(10);
        tree.insertData('S');
        tree.insertData('C');
        tree.insertData('E');
        tree.insertData('A');
        tree.insertData('B');
         tree.insertData('D');
         tree.insertData('H');
         tree.insertData('O');
         tree.insertData('N');
         tree.insertData('T');
        tree.printData();
       

    }
}
