/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.dequeue;

/**
 *
 * @author Mr.Smart
 */
public class DEqueue {

    Node front;
    Node rear;

    class Node {

        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            next = prev = null;
        }
    }

    public void insertlast(int data) {
        if (rear == null) {
            front = rear = new Node(data);
            front.prev = rear.prev = null;
        } else {
            Node newNode = new Node(data);
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;

        }
    }

    public void removeLast() {
        Node current = front;
        while (current.next != null) {
            current = current.next;
        }
        current.prev.next = null;
    }

    public void insertFirst(int data) {
        if (rear == null) {
            return;
        }
        Node newNode = new Node(data);
        newNode.next = front;
        front.prev = newNode;
        front = newNode;
    }

    public void removingFirst() {
        if (front == null) {
            return;
        }

        front = front.next;
        front.prev = null;
    }

    public void println() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data + "---->");
            current = current.next;
        }
        System.out.println("null..");
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        DEqueue q = new DEqueue();
        q.insertlast(4);
        q.insertlast(5);
        q.insertlast(6);
        q.insertlast(7);
        q.insertlast(8);
        q.insertlast(9);
        q.println();
        System.out.println("after delting the last node...");
        q.removeLast();
        q.println();
        System.out.println("insert at the satrting..");
        q.insertFirst(90);
        q.println();
        System.out.println("delting at the satrting..");
        q.removingFirst();
        q.println();

    }
}
