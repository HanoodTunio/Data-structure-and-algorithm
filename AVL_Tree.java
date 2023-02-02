/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.avl_tree;

/**
 *
 * @author Mr.Smart
 */
public class AVL_Tree {

    Node root;

    class Node {

        Node right;
        Node left;
        int data;

        Node(int data) {
            this.data = data;
            right = left = null;
        }
    }

    public int balancedFactor(Node current) {
        if (root == null) {
            return 0;
        }
        int left =  balancedFactor(current.left);
        int right =  balancedFactor(current.right);

        return left - right;
    }

    public Node rr_Rotation(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left = temp;
        return temp;
    }

    public Node ll_Rotation(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        temp.right = temp;
        return temp;
    }

    public Node lr_Roatation(Node root) {
        Node temp = root.left;
        root.left = ll_Rotation(temp);
        return rr_Rotation(root);
    }

    public Node rl_Roatation(Node root) {

        Node temp = root.right;
        root.right = rr_Rotation(temp);
        return ll_Rotation(root);
    }

    public int treeHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int right = treeHeight(root.right);
        int left = treeHeight(root.left);
        int max_height = Math.max(left, right);
        return max_height + 1;
    }

    public void insert(int data) {
        if (root == null) {
            return;
        }

    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
