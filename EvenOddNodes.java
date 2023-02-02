/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.evenoddnodes;

/**
 *
 * @author Mr.Smart
 */
public class EvenOddNodes {

    Node root;
    int evenSum = 0;
    int oddSum = 0;

    class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            right = null;
            left = null;
        }
    }

    public void insertData(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }

                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void evenNode(Node root) {
        if (root == null) {
            return;
        }

        if (root.data % 2 == 0) {
            System.out.print(root.data + "  ");
            evenSum = evenSum + root.data;
        }
        evenNode(root.right);
        evenNode(root.left);
       
    }
    
    public void evenSum(){
        System.out.println();
         System.out.println("the sum of even numbers...  ");
        System.out.println(evenSum + "  ");
    }

    public void oddSum(){
        System.out.println();
         System.out.println("the sum of odd numbers...  ");
        System.out.println(oddSum + "  ");
    }
    public void OddNode(Node root) {
        if (root == null) {
            return;
        }

        if (root.data % 2 != 0) {
            System.out.print(root.data + "  ");
            oddSum = oddSum+root.data;
        }
        OddNode(root.right);
        OddNode(root.left);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        EvenOddNodes tree = new EvenOddNodes();
        tree.insertData(40);
        tree.insertData(30);
        tree.insertData(50);
        tree.insertData(25);
        tree.insertData(35);
        tree.insertData(45);
        tree.insertData(60);
        System.out.println("Even numbers...");
        tree.evenNode(tree.root);
        tree.evenSum();
        System.out.println(" ");
        System.out.println("Odd numbers...");

        tree.OddNode(tree.root);
        tree.oddSum();
    }
}
