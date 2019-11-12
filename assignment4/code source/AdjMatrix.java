import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AdjMatrix {
	private static PrintWriter writer;
	private int[][] adjMatrix;
	private int adjMatSize;
	private static int neighbourSize;

	public AdjMatrix(int neighbourSize,int size) {

		adjMatrix = new int[size][size];
		adjMatSize = size;
		this.neighbourSize=neighbourSize;
	}
/**
 *  populates the adjacency matrix
 * @param mat ArrayListMatrix instance holding all the neighbouring matrices
 */
	public void populate(ArrayListMatrix mat) {
		
		for (int i = 0; i < adjMatSize; i++) { // i am sure this can be summed to half as the matrix will be a copy of
												// itself
			for (int j = 0; j < adjMatSize; j++) {
				Integer[][] mat1 = mat.getAt(i);
				Integer[][] mat2 = mat.getAt(j);
//				int sum1=sumMat(mat1);		// was thinking of implementing a sum method for each one, then diff= sum1-sum2
//				int sum2=sumMat(mat2);  	// but the sum is O(n^2) and i am calling it twice compared to get Difference that is called once
				int diff = getDifference(mat1, mat2);
				adjMatrix[i][j] = (diff);
			}

		}

	}

	/**
	 * 
	 * 
	 * @param mat1: matrix 1
	 * @param mat2: matrix2
	 * @return: difference between sum of each matrices
	 */
	public int getDifference(Integer[][] mat1, Integer[][] mat2) {
		int diff = 0;
		for (int i = 0; i < mat1.length; i++) { // traverses rows
			for (int j = 0; j < mat2.length; j++) { // traverses set of columns in that row
				diff += java.lang.Math.abs(mat1[i][j] - mat2[i][j]);
			}
		}

		return java.lang.Math.abs(diff);

	}
	/**
	 * displays the matrux on the counsel
	 * 
	 */
	public void display() {
	
		System.out.println("Edge \tWeight");
		for (int i = 1; i < adjMatSize + 1; i++) {
			for (int j = 1; j < adjMatSize + 1; j++) {
				System.out.println(i + " - " + j + "\t" + adjMatrix[i - 1][j - 1]);
			}
			System.out.println();
		}
	}

	public int[][] getGraph() {

		return adjMatrix;
	}
  
	
	/**
	 * writes the adjacency matrix to specified file
	 */
	public void writeToFile() {
		try {
			String outFileName=neighbourSize+"x"+neighbourSize+"_ data-GRAPH_out.txt";
			writer = new PrintWriter(new FileWriter(outFileName));
			writer.println("Edge \tWeight");
			for (int i = 1; i <adjMatSize + 1; i++) {
				for (int j = 1; j < adjMatSize + 1; j++) {
					writer.println(i + " - " + j + "\t" + adjMatrix[i - 1][j - 1]);
					writer.flush();
		
				}
				writer.println();
			}
			System.out.println(" writing the adjacency matrix to file done successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
