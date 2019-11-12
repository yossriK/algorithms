import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

public class Demo {

	static BinaryTree tree = new BinaryTree();
	static String fileName;

	public static void main(String[] args) throws FileNotFoundException {
		boolean state = fillTree();
		if (state == true) {
			System.out.println("**Tree built successfully");
			displayStas(); // functionality to be relpaced with number 3 in assignmnet
			Scanner scan = new Scanner(System.in);
			
			while (true) {
				System.out.println(" you can choose from following options");
				displayMenu();
				String input = scan.nextLine();
				switch (input) {
				case "1":
					searchTree();
					continue;
				case "2":
					print();
					continue;
				case "3":
					System.out.println("program exited");
					java.lang.System.exit(1);

				}

			}
		}
	}

	// displaying the status of the tree, which is referred to by number 3 in the assignment

	public static void displayStas() {
		// total number of words be like
		System.out.println("**total number of words in " + fileName + ", is " + tree.size);

	

		// to display the repeated words
		System.out.println("**The word(s) that occur(s) most often are");
		tree.displayMoreOften(tree.root);
		
		// displaying number of unique words in the array
		tree.displayNomUnique();
		System.out.println();
		// displaying the depth
		int maxDepth = tree.getMaxDepth();
		System.out.println("**depth of the tree is: " + maxDepth);
		System.out.println();

	}
	
	// called from main function, responsible for filling the tree with data from the textfile
	public static boolean fillTree() throws FileNotFoundException {
		try {

			String word;
			Scanner scan = new Scanner(System.in);
			System.out.println(" Enter the input file name");
			fileName = scan.nextLine().trim();
			File input = new File(fileName);
			Scanner scanner = new Scanner(input);
			
			// while there exists words in the text file
			while (scanner.hasNext()) {
				scanner.useDelimiter("\\W"); // delimeter to only work for alphanumeric char

				word = scanner.next().toLowerCase();
				if (word.length() > 0)
					tree.add(word);
			}
		} catch (FileNotFoundException e) {
			System.out.println(" File not found, program terminated");

			return false;

		}

		return true;
	}
	
	// search tree function
	public static void searchTree() {
		tree.search();

	}

	// displaying a menu the user can choose from to print the BST or search for a word
	public static void displayMenu() {
		System.out
				.println(" Menu\n" + "1. search for a specific word in the tree\n" + "2. display tree\n" + "3. break");

	}

	
	// asks the user to input the way they want to print their tree, and calls the printing method accordingly
	public static void print() {

		System.out.println(" Enter  the BST traversal method(1=IN-ORDER, 2=PRE-ORDER, 3=POST-ORDER ) ");
		Scanner scan = new Scanner(System.in);

		String input = scan.nextLine();
		switch (input) {
		case "1":
			System.out.println(" IN-ORDER output");
			tree.inOrder(tree.root);
			System.out.println();
			break;
		case "2":
			System.out.println(" PRE-ORDER output");
			tree.preOrder(tree.root);
			System.out.println();
			break;
		case "3":
			System.out.println(" POST-ORDER output");
			tree.postOrder(tree.root);
			System.out.println();
			break;

		}
	}
}