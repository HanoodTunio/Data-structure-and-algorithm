/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.bstarray;

/**
 *
 * @author Mr.Smart
 */
public class BSTarray {

    private int root;
    private int array[];
    private int size;

    BSTarray(int size) {
        this.size = size;
        array = new int[size];
        root = -1;
    }

    public int parent(int i) {
        return i / 2;
    }

    public int leftChild(int i) {
        return i * 2;
    }

    public int rightChild(int i) {
        return 2 * i + 1;
    }

    public void swiftUp(int i) {
        while (i > 0 && array[parent(i)] < array[i]) {
            int temp = array[parent(i)];
            array[parent(i)]=array[i];
            array[i] = temp;
            i = parent(i);
        }
    }

    public void swiftDown(int i) {
        int maxindex = i;
        int l = leftChild(i);
        if (l < size && array[l] > array[maxindex]) {
            maxindex = l;
        }

        int r = rightChild(i);
        if (r < size && array[r] > array[maxindex]) {
            maxindex = r;
        }

        if (i != maxindex) {
            int temp = array[i];
            array[i] = array[maxindex];
            array[maxindex] = temp;
            swiftDown(maxindex);
        }
    }

    public void isert(int data) {
        root = root + 1;
        array[root] = data;
        swiftUp(root);
    }

    public int extractMax() {
        int result = array[0];
        array[0] = array[root];
        root = root - 1;
        swiftDown(0);
        return result;
    }

    public int remove(int i) {
        int temp = array[i];
        array[i] = Integer.MAX_VALUE;
        swiftUp(i);
        extractMax();
        return temp;
    }

    public void changePrioriy(int i, int p) {
        int oldp = array[i];
        array[i] = p;
        if (p > oldp) {
            swiftUp(i);
        } else {
            swiftDown(i);
        }
    }

    void printValue(){
         for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "---->");
        }
         System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        BSTarray obj = new BSTarray(9);
        obj.isert(5);
        obj.isert(7);
        obj.isert(8);
        obj.isert(4);
        obj.isert(3);
        obj.isert(100);
        obj.isert(40);
        obj.isert(20);
        obj.isert(31);
        obj.printValue();
        System.out.println("Extract Maximum value.......");
        System.out.println(obj.extractMax());
        System.out.println("After extracting the maximum value....");
        obj.printValue();
       /* System.out.println(obj.remove(3));
        obj.printValue();*/
       obj.changePrioriy(3, 300);
       System.out.println("after changing the priority.....");
       obj.printValue();
    }
}
