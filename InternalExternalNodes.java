/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.internalexternalnodes;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Mr.Smart
 */
public class InternalExternalNodes {

    Node root;

    class Node {

        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            right = null;
            left = null;
        }
    }

    public void insertData(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        } else {
            Node newNode = new Node(data);
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

    public void printInternalNodes(Node root) {
        // Using a queue for a level order traversal
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {

            // Check and pop the element in
            // the front of the queue
            Node curr = q.peek();
            q.remove();

            // The variable flag keeps track of
            // whether a node is an internal node
            boolean isInternal = false;

            // The node has a left child
            if (curr.left != null) {
                isInternal = true;
                q.add(curr.left);
            }

            // The node has a right child
            if (curr.right != null) {
                isInternal = true;
                q.add(curr.right);
            }

            // In case the node has either a left
            // or right child or both print the data
            if (isInternal == true) {
                System.out.print(curr.data + " ");
            }
        }
        
        System.out.println( " ");
    }

    public void printExternalNodes(Node root) {
        if (root == null) {
            return;
        } else {
            if(root.right == null && root.left == null){
                System.out.print(root.data+"  ");
            }
            else
                printExternalNodes( root.left);
                printExternalNodes( root.right);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        InternalExternalNodes tree = new InternalExternalNodes();
        tree.insertData(15);
        tree.insertData(10);
        tree.insertData(20);
        tree.insertData(8);
        tree.insertData(12);
        tree.insertData(16);
        tree.insertData(25);
        tree.printInternalNodes(tree.root);
        tree.printExternalNodes(tree.root);
    }
}
