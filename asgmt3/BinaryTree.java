import java.util.Scanner;
/**
 * 
 * @author yossri 
 *	BST module, stores string of words in it from a text file, and counts how many
 *	times each word has been repeated. the word of smaller size goes to the left
 */
public class BinaryTree {

	Node root;			// head node in the tree
	public int size = 0; // total number of words, can be number of nodes
	int countOccur; // number of unique words
	int height; // max height of the tree

	// default constructor of the tree
	BinaryTree() {

		root = null;
		size = 0;
		countOccur = 0;
	}

	// adding a node to the tree
	public void add(String word) {
		root = addRec(root, word);
	}

	// recursive function that traverses the BST based on the size of the word, that
	//decides if should go to the left or the right of specific node
	public Node addRec(Node head, String word) {

		if (head == null) {
			head = new Node(word);
			size++;
			return head;

		}

		if (word.compareTo(head.word) < 0)
			head.left = addRec(head.left, word);

		else if (word.compareTo(head.word) > 0)
			head.right = addRec(head.right, word);

		else if (word.compareTo(head.word) == 0)
			head.freq++;

		return head;
	}

			
	// in-ORDER printing of the BEST
	public void inOrder(Node T) {

		if (T == null)
			return;
		inOrder(T.left);

		System.out.print(T.word + " ");

		inOrder(T.right);

	}
	// pre-ORDER printing of the BEST
	public void preOrder(Node T) {

		if (T == null)
			return;

		System.out.print(T.word + " ");
		preOrder(T.left);
		preOrder(T.right);

	}
	// post-ORDER printing of the BEST
	public void postOrder(Node T) {

		if (T == null)
			return;

		postOrder(T.left);
		postOrder(T.right);
		System.out.print(T.word + " ");

	}

	
	// searching for a word,
	// there is no return value, the word is printed in the same function if found
	// it calls another recursive function searchTree that does the logic that returns node containing the word
	public void search() {
		System.out.println(" please enter the word you are looking for");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine().trim();
		Node n = searchTree(name, this.root);

		if (n != null)
			System.out.println(" found it -," + n.word + ",- and it appears: " + n.freq + " times");
		else
			System.out.println("Not found");
	}
	// recursive function that searches the tree for a word, and returns the node according to the
	// word, else returns null
	public Node searchTree(String name, Node T) {

		if (T == null || T.word.compareTo(name) == 0)
			return T;

		if (name.compareTo(T.word) < 0)
			return searchTree(name, T.left);

		return searchTree(name, T.right);

	}
	// calls maxD that does the logic to calculate max depth of the tree
	public int getMaxDepth() {

		return maxD(this.root);

	}
 
	// calculating depth of the tree
	public int maxD(Node node) {

		if (node == null)
			return 0;
		else {
			// compute the depth of each subtree
			int lDepth = maxD(node.left);
			int rDepth = maxD(node.right);
			// use the larger one
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}

	}

	
	// called from Demo class, and it displays the words that occurred more than one time
	public void displayMoreOften( Node node) {
		if (node == null)
			return;

		displayMoreOften(node.left);
		displayMoreOften(node.right);
		if(node.freq>1) {
			System.out.println(">"+node.word + " = " +node.freq);
			countOccur++;
		}	
	}
	
	// called from Demo class, it displays the number of unique words, i.e the number of words
	// that were not repeated 
	public void displayNomUnique() {
		int unique=this.size-this.countOccur;
		System.out.println();
		System.out.println("**Number of unique words is " + unique);
		
		
	}
}
