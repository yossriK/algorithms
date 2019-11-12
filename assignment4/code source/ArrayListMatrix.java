import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListMatrix {
	private int matSize;
	private  int listSize;
	
	private ArrayList<Integer[][]> matrixList;

	public ArrayListMatrix( int matSize, int listSize) {
		matrixList = new ArrayList<Integer[][]>();
		this.matSize=matSize;
		this.listSize= listSize;

	}

	public void construct(String textFileName) throws IOException {
		Scanner scan1 = new Scanner(new FileReader(textFileName));
		int matSize = Integer.parseInt(scan1.next()); // size of matrix in arraylist
		//System.out.println(matSize);
		scan1.nextLine();// skip one line
		int nomOfMat = Integer.parseInt(scan1.nextLine());
		scan1.nextLine();// skip one line
		scan1.nextLine();// skip one line
		 
		int i = 0;
		//System.out.println(scan1.nextLine());// at this point i am at 1

		while (scan1.hasNext() && i<listSize) {
			scan1.skip("[ \t]*");  	// skipping all white places in the beginning of hte file
			Integer[][] t = new Integer[matSize][matSize];
			
			String numbers=scan1.nextLine();
			while(!( numbers.length()>3)) 		 // i am assuming it to stop the while once we hit that matrix line
			{
				numbers=scan1.nextLine();
			}
			
			for (int z = 0; z < matSize; z++) {	
				
				String [] line= numbers.trim().split(" ");
				
				for (int j = 0; j < line.length; j++) {
					if(line[j].length()>0)
						t[z][j] = Integer.parseInt(line[j]);
					
				}
				if(scan1.hasNext())
					numbers=scan1.nextLine();
			}
			matrixList.add(t);
			i++; // keeps track of matrices added to the fucking file
		
			
		}

	}

	public void display() {
		int i=1;
		Iterator it = matrixList.iterator();
		while (it.hasNext()) {
			Integer[][] t = (Integer[][]) it.next();
			System.out.println(i);
			for (int z = 0; z < matSize; z++) {
				for (int j = 0; j < matSize; j++) {
					System.out.print(t[z][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			i++;
		}
	}
	
	
	public Integer[][] getAt(int i) {
		return matrixList.get(i);
		
		
		
	}
}
