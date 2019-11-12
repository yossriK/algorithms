
// A Java program for Prim's Minimum Spanning Tree (MST) algorithm. 
// The program is for adjacency matrix representation of the graph 

import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class MST {
	// Number of vertices in the graph
	private int V;
	private static FileWriter writer;
	private static PrintWriter out1;
	public void setV(int num) {

		this.V = num;
	}

	// creating default MST
	public MST(int nomOfVertices) {

		setV(nomOfVertices); // setting the number of vertices to be in the MST
	}

	// A utility function to find the vertex with minimum key
	// value, from the set of vertices not yet included in MST
	int minKey(int key[], Boolean mstSet[]) {
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}

		return min_index;
	}

	// A utility function to print the constructed MST stored in
	// parent[]
	void printMST(String name,int parent[], int n, int graph[][]) {
		try {
			// initilazing the printWriter
			out1 = new PrintWriter( new FileWriter(name));
			
			
			System.out.println("display of the MST just created \nEdge \tWeight");
			out1.println("Edge \tWeight");
			
			for (int i = 1; i < V; i++) {
		
				out1.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]); // writinng to the MST text file
				System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
				
				
			}
			System.out.println(" writing the MST to file done successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			out1.close();
						
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	// Function to construct and print MST for a graph represented
	// using adjacency matrix representation
	void primMST(int neighbourSize, int graphSIze,int graph[][]) {
		
		String outputFileName=neighbourSize+"x"+neighbourSize+"_ data-MST_out.txt";
		// Array to store constructed MST
		int parent[] = new int[V];

		// Key values used to pick minimum weight edge in cut
		int key[] = new int[V];

		// To represent set of vertices not yet included in MST
		Boolean mstSet[] = new Boolean[V];

		// Initialize all keys as INFINITE
		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		// Always include first 1st vertex in MST.
		key[0] = 0; // Make key 0 so that this vertex is
					// picked as first vertex
		parent[0] = -1; // First node is always root of MST

		// The MST will have V vertices
		for (int count = 0; count < V - 1; count++) {
			// Pick thd minimum key vertex from the set of vertices
			// not yet included in MST
			int u = minKey(key, mstSet);

			// Add the picked vertex to the MST Set
			mstSet[u] = true;

			// Update key value and parent index of the adjacent
			// vertices of the picked vertex. Consider only those
			// vertices which are not yet included in MST
			for (int v = 0; v < V; v++)

				// graph[u][v] is non zero only for adjacent vertices of m
				// mstSet[v] is false for vertices not yet included in MST
				// Update the key only if graph[u][v] is smaller than key[v]
				if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
		}

		// print the constructed MST
		printMST(outputFileName,parent, V, graph);
	}

}