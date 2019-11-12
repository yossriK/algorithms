import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Demo {

	private static AdjMatrix matrix; // aka the graph
	private static ArrayListMatrix matList; // what i read from the file
	// static matList list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(" please enter the name of your file to be read");
		
		Scanner scan = new Scanner((System.in));
		String fileName= scan.nextLine();
		Scanner scan1= new Scanner( new FileReader(fileName));
		int matSize = Integer.parseInt(scan1.next()); // size of matrix in arraylist read from file

		scan1.nextLine();// skip one line
		
		// number of vertices in the graph
		int nomOfNeighbour = Integer.parseInt(scan1.nextLine());// size of the adjacency matrix

		// reading the matrices from input files, and constructing an array list holding all neighbours of matrices
		matList = new ArrayListMatrix(matSize, nomOfNeighbour);
		matList.construct(fileName);

		

		// the code following here is regarding creating an adjacency matrix 
		
		matrix = new AdjMatrix(matSize,nomOfNeighbour);			// creates new matrix
		matrix.populate(matList); 						// populates matrix with all those differences
		// matrix.display();							// displays my values saved in the matrix on the counsel
		matrix.writeToFile();							// writing the matrix to file
		
		
		
		// creatng new MST 
		MST t = new MST(nomOfNeighbour);
		t.primMST(matSize,nomOfNeighbour,matrix.getGraph());			// populating MST and writing the MST into file

	}
}
