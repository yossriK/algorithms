import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;


public class Test {
	  static String [] myArr;
	  
	
	
	public static void main( String []args) throws Throwable {
		 // checks for correct argument input
		if (args.length != 2) {
		    System.err
			    .println("Insufficent or too many arguments entered. Program Terminated.");
		    System.exit(1);
		}
		//reading the names of the input and output files
		String input= args[0];
		String output=args[1];
		boolean check= readFile(input);
		if(check==true) 
			System.out.println(" reading into array from "+input +" done succesfully");
		else
			System.out.println(" reading into array failed");
			
		// sorting the array, 
		mergeSort(myArr);
		// creating my ArrayList, list B using my input string array
		ArrayList list=new ArrayList(myArr);
	
		// writing list B to the output file
		writeToFile(list,output);
		
		
	}

	// my mergeSort algorithm to sort list A
	public static void mergeSort(String[] names) {
        if (names.length > 1) {
            String[] left = new String[names.length / 2];
            String[] right = new String[names.length - names.length / 2];

            for (int i = 0; i < left.length; i++) {
                left[i] = names[i];
            }

            for (int i = 0; i < right.length; i++) {
                right[i] = names[i + names.length / 2];
            }

            mergeSort(left);
            mergeSort(right);
            merge(names, left, right);
        }
    }

    public static void merge(String[] names, String[] left, String[] right) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < names.length; i++) {
            if (b >= right.length || (a < left.length && left[a].compareToIgnoreCase(right[b]) < 0)) {
                names[i] = left[a];
                a++;
            } else {
                names[i] = right[b];
                b++;
            }
        }
    }
    // this function responsible for writing file data into the array
    @SuppressWarnings("unused")
	public static boolean readFile( String input) throws FileNotFoundException {
    	File in=new File(input);
		Scanner scan = new Scanner(in);
		if(scan==null) {
			return false;
		}
		int nomOfLines=0;
		// counting how many number of lines in the text file initialize list A on that basis
		while(scan.hasNext())
		{
	
			scan.next();
			nomOfLines++;
		}
		scan.close();
		myArr= new String[nomOfLines];
		scan=new Scanner(in);
		int i=0;
		// filling list A with all the words from input text file
		while(scan.hasNext())
		{
			myArr[i]=scan.next();
			i++;
		}
		scan.close();
    	
    	
    	return true;
    }
    
  // the function responsible of writing list  B to the output file
    @SuppressWarnings("unused")
	public static  void writeToFile(ArrayList list,String output) throws Throwable  {
   	 BufferedWriter writer = new BufferedWriter(new FileWriter(output));
   	 if( writer==null) {
   		 System.out.println(" writing to "+ output+ " was unsuccessful");
   	 }
   	 for( int i=0;i< list.getSize();i++) {
   		 writer.write( list.getIndex(i).getLinkedList());
   	 	 writer.newLine();
   	 }
   	    
   	 
   	writer.close();	
   	System.out.println(" writing to "+ output+ " was successful");
    }
   	
    
  
}
