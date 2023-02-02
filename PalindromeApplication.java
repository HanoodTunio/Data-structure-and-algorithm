/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.palindromeapplication;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Mr.Smart
 */
public class PalindromeApplication {

    /*Node head;
    Node tail;

    class Node {

        int data;
        Node next;


        Node(int data) {
            this.data = data;
            next  = null;
        }
    }

    public void addFirst(int data) {
        if (head == null) {
            head=tail=new Node(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next=head;
        head = newNode;
    }
    
    public void addLast(int data){
        if(head== null){
            head=tail=new Node(data);
            return;
        }
         Node newNode = new Node(data);
        tail.next=newNode;
        tail=newNode;
    }
    
    public void printData(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data+"--->");
        }
        System.out.println("null.");
    }*/
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner input = new Scanner(System.in);
        System.out.println("enter any string to check that the he string is palindrome or not...");
        String string = input.nextLine();
        Stack st1 = new Stack();
        Queue queue = new LinkedList();
        Deque de = new LinkedList();
         boolean yes=true;
        
       /* for (int i = 0; i < string.length(); i++) {
            st1.add(string.charAt(i));
            queue.add(string.charAt(i));
        }
        boolean yes=true;
       
        while(!st1.isEmpty() && !queue.isEmpty()){
            if(! st1.pop().equals(queue.remove())){
                yes=false;
            }
        }*/
        if(yes){
            System.out.println("the string is Palindrome...");
        }
        else
            System.out.println("the string is not Palindrome...");
       
    }
}
