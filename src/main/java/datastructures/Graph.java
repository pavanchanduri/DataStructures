package datastructures;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    /**
     * Add a vertex to the graph
     * The method works as follows:
     * 1. Check if the vertex already exists in the adjacency list (adjList).
     * 2. If the vertex does not exist (i.e., adjList.get(vertex) returns null), it adds the vertex to the adjList with an empty ArrayList as its value.
     * 3. If the vertex already exists, the method returns false, indicating that the vertex was not added.
     * 4. If the vertex is successfully added, the method returns true.
     * 
     * @param vertex the vertex to be added
     * @return true if the vertex was added, false otherwise
     */
    public boolean addVertex(String vertex) {
        if(adjList.get(vertex)==null) {
            adjList.put(vertex, new ArrayList<>()); //This adds something like {"A", []}
            return true;
        }
        return false;
    }

    /**
     * Add an edge between two vertices in the graph
     * The method works as follows:
     * 1. It first checks if the two vertices are the same. If they are, it returns immediately without adding an edge (to avoid self-loops).
     * 2. It then checks if both vertices exist in the adjacency list (adjList).
     * 3. If both vertices exist, it checks if an edge already exists between them by checking if vertex2 is in the adjacency list of vertex1.
     * 4. If the edge does not exist, it adds vertex2 to the adjacency list of vertex1 and vice versa (since this is an undirected graph).
     * 5. If either vertex does not exist in the adjacency list, the method does nothing.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    public void addEdge(String vertex1, String vertex2) {
        if(vertex1.equals(vertex2)) return;
        if(adjList.get(vertex1)!=null && adjList.get(vertex2)!=null) {
            if(!adjList.get(vertex1).contains(vertex2)) {
                adjList.get(vertex1).add(vertex2);
            }
            if(!adjList.get(vertex2).contains(vertex1)) {
                adjList.get(vertex2).add(vertex1);
            }
        }
    }

    /**
     * Remove an edge between two vertices in the graph
     * The method works as follows:
     * 1. It first checks if both vertices exist in the adjacency list (adjList).
     * 2. If both vertices exist, it removes vertex2 from the adjacency list of vertex1 and vice versa (since this is an undirected graph).
     * 3. If either vertex does not exist in the adjacency list, the method returns false.
     * 4. If the edge is successfully removed, the method returns true.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     * @return true if the edge was removed, false otherwise
     */
    public boolean removeEdge(String vertex1, String vertex2) {
        if(adjList.get(vertex1)!=null && adjList.get(vertex2)!=null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    /**
     * Remove a vertex from the graph
     * The method works as follows:
     * 1. It iterates through the adjacency list of the vertex to be removed.
     * 2. For each adjacent vertex, it removes the vertex to be removed from its adjacency list.
     * 3. Finally, it removes the vertex itself from the main adjacency list (adjList).
     *
     * @param vertex the vertex to be removed
     */
    public void removeVertex(String vertex) {
        for(String otherVertex: adjList.get(vertex)) {
            adjList.get(otherVertex).remove(vertex);
        }
        adjList.remove(vertex);
    }

    /**
     * Print the graph
     */
    public void printGraph() {
        System.out.println(adjList);
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addEdge("A","B");
        graph.addEdge("A","C");
        graph.addEdge("C","D");
        graph.addEdge("A","D");
        graph.addEdge("B","D");
        graph.printGraph();
        graph.removeVertex("D");
        graph.printGraph();
    }
}
