/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.copytree;

/**
 *
 * @author Mr.Smart
 */
public class CopyTree {

    Node root;

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

    public Node copy(Node root) {
        if (root == null) {
            return null;
        }
        Node copy = new Node(root.data);
        copy.left = copy(root.left);
        copy.right = copy(root.right);
        return copy;
    }

    public void Inorder(Node current) {
        if(current == null)
            return;
        Inorder(current.left);
        System.out.print(current.data+" ");    
       Inorder(current.right);
    }
    
    public void leftHighest(Node current){
        if(current == null)
            return;
        while(current.right !=null){
            current = current.right;
        }
        System.out.println("left subtree greatest value..." + current.data);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        CopyTree tree = new CopyTree();
        tree.insertData(40);
        tree.insertData(30);
        tree.insertData(50);
        tree.insertData(25);
        tree.insertData(35);
        tree.insertData(45);
        tree.insertData(60);
        System.out.println("original tree...");
        tree.Inorder(tree.root);
        
        Node cp = tree.copy(tree.root);
        System.out.println("copy tree....");
        tree.Inorder(cp);
        tree.leftHighest(cp.left);

    }
}
