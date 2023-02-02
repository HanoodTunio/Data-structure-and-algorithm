/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graphusinglist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mr.Smart
 */
public class GraphUsingLIst {

    /**
     * @param args the command line arguments
     */
    private Map<String, ArrayList<String>> graph;
    private int numOfVertices;
    private int numOfEdges;

    GraphUsingLIst() {
        graph = new HashMap<>();
        numOfVertices = 0;
    }

    //get number of vertices
    int getNumberOfVertices() {
        return numOfVertices;
    }

    //get number of edges
    int getNumberOfEdges() {
        return numOfEdges;
    }

    // implement add vertices method..
    public void addVertex(String vertex) {
        graph.put(vertex, new ArrayList<String>());
        numOfVertices++;
    }

    // implement add edges 
    void addEdges(String vertex1, String vertex2, boolean byDirection) {
        if (!graph.containsKey(vertex1)) {
            addVertex(vertex1);
        }

        if (!graph.containsKey(vertex2)) {
            addVertex(vertex2);
        }

        graph.get(vertex1).add(vertex2);
        numOfEdges++;
        if (byDirection == true) {
            graph.get(vertex2).add(vertex1);
            numOfEdges++;
        }
    }

    // has a vertex
    public void hasVertex(String vertex) {
        if (graph.containsKey(vertex)) {
            System.out.println("the graph contains " + vertex + " as a vertex..");
        } else {
            System.out.println("the graph doesnot contains " + vertex + " as a vertex..");
        }
    }
    
    //get neigbour
    
    ArrayList<String> getNeighbour(String vertex){
        ArrayList<String> list = new ArrayList<String>();
        
        for(String key : graph.keySet()){
            if(graph.get(key).contains(vertex))
                list.add(key);
        }
        list.addAll((graph.get(vertex)));
        return list;
    }
    // print graph
    public void print(){
        for(String key : graph.keySet()){
            System.out.println(key+ " " + graph.get(key));
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        GraphUsingLIst g = new GraphUsingLIst();
        g.addEdges("dadu", "Larkana", false);
        g.addEdges("Larkana", "Sukkur", false);
        g.addEdges("Sukkur", "Kashmor", false);
        g.addEdges("Kashmor", "Moro", false);
        g.addEdges("Hyderababd", "Hala", false);
        g.addEdges("Hyderababd", "Milawali", false);
        g.addEdges("dadu", "Sehwan", false);
        g.addEdges("Krachi", "DAdu", false);
        g.addEdges("dadu", "Larkana", false);
        g.print();
         System.out.println("Neighbour of Dadu are " + g.getNeighbour("Dadu"));
        System.out.println("Neighbour of Karachi are " + g.getNeighbour("Karachi"));
    }

}
