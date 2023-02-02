/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bydirctionalgraph;

/**
 *
 * @author Mr.Smart
 */
public class ByDirctionalGraph {

    /**
     * @param args the command line arguments
     */
    private int noOfVertex;
    private int noOfEdges;
    private int array[][];
    int size;

    // constructuctr to initialize...
    ByDirctionalGraph(int size) {
        noOfVertex = size;
        noOfEdges = 0;
        this.size = size;
        array = new int[size][size];

    }

    // add vertexs
    public void addVertex() {
        size++;
        //copying elements from prev array to new rray
        int[][] newArray = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                newArray[i][j] = array[i][j];
            }
        }
        noOfVertex++;
        array = newArray;
    }

    //add edges between two vertices
    public void addEdge(int x, int y) {
        if (x >= size || y >= size) {
            System.out.println("Vertex does not Exits in Matrix..!!");
        } else {
            array[x][y] += 1;
            noOfEdges++;
        }
    }

    //get numbr of edges
    public int getNoOfEdges() {
        return noOfEdges;
    }

    //get number of vertex
    public int getNoOfVertex() {
        return noOfVertex;
    }

    // number of out going edges
    public int noOfOutGoingEdges(int vertex) {
        int count = 0;
        if (vertex >= size || vertex == 1) {
            System.out.println("Vertex does not exist....");
        }
        for (int i = 0; i < size; i++) {
            if (array[i][vertex] > 0) {
                count += array[i][vertex];
            }
        }
        return count;
    }

    // number of incoming edges
    public int noOfInComingEdges(int vertex) {
        int count = 0;
        if (vertex >= size || vertex > 0) {
            System.out.println("vertex doesnot exist..");
        }
        for (int i = 0; i < size; i++) {
            if (array[i][vertex] > 0) {
                count += array[i][vertex];
            }
        }
        return count;
    }

    // print graph
    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        ByDirctionalGraph graph = new ByDirctionalGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.print();
        System.out.println("adding new vertex...");
        graph.addVertex();
        graph.addEdge(1, 5);
        graph.print();
        System.out.println("no of edges in graph.." + graph.noOfOutGoingEdges(1));
        System.out.println("no of edges in graph.." + graph.noOfInComingEdges(1));
        System.out.println("no of edges in graph.." + graph.noOfOutGoingEdges(3));
        System.out.println("no of edges in graph.." + graph.noOfInComingEdges(3));

    }

}
