/**
 * 
 * @author yossri
 * Class Node characterizes what the BST is made up of
 * 
 * contains left and right nodes, string word to save data in, and frequency of
 * each word
 */
class Node implements Comparable<Node> {

	Node right, left;
	String word;
	int freq;

	Node(String word) {

		right = left = null;
		this.word = word;
		freq = 1;

	}

	public int compareTo(Node node) {

		return this.word.compareTo(node.word);
	}

}