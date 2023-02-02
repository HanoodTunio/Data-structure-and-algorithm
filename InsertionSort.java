/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.insertionsort;

/**
 *
 * @author Mr.Smart
 */
public class InsertionSort {

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Insertion Sort..!!");
        int arr[] = {7, 8, 3, 1, 2};
        for (int i = 1; i < arr.length ; i++) {
            int current = arr[i];
            int j = i-1;
            while(j>=0 && current < arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1] = current;
        }

        print(arr);
    }
}
