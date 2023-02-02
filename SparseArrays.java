/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.sparsearrays;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mr.Smart
 */
public class SparseArrays {
    
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
    // Write your code here
    int count=0;
    List<Integer> arr = new ArrayList<Integer>();
    for(int i =0 ; i < queries.size() ; i++){
        for(int j = 0 ; j < strings.size() ; j++){
            if(queries.get(queries.indexOf(i))==strings.get(strings.indexOf(j)))
            count++;
        }
        arr.add(count);
    }
    
    return arr;
    }


    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        List<String> string = new ArrayList<String>();
        List<String> quries = new ArrayList<String>();
        List<Integer> array = new ArrayList<Integer>();
        string.add("def");
        string.add("de");
         string.add("fgh");
         
         quries.add("def");
         quries.add("lmn");
         quries.add("fgh");
         
        array = matchingStrings(string , quries);
        for(int i =0 ; i < array.size()-1 ; i++){
            System.out.print(array.get(i)+ " ");
        }
    }
}
