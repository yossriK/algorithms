 // my own implemented SinglyLinkedList
public class SinglyLinkedList {

	int size;
	Link head;
	
	// constructor of the SinglyLinkedList
	public SinglyLinkedList(String name) {
		head =new Link(name);
		size=1;
		
		
	}
	// adding Links to the SinglyLinkedList, already in alphabetical order
	public void add( String name) {
		Link e= new Link(name);
		if(head==null) {
			head=e;
			size++;
		}
		
		if(head!=null) {
		Link newLink=head;  // traverse and add them in order
		while((newLink.next!=null) )
			newLink=newLink.next;
		
		e.next=newLink.next;
		newLink.next=e;
		
		
		size++;
		}
		
	}
	
	 // test code used to display the linked list
//	public void displaySinglyList() {
//		Link current=head;
//		while(current!=null){
//			current.displayLink();
//			current=current.next;
//		}
//		System.out.println();
//	}
	
	// returns the anagrams stored in this SinglyLinkedList
	 public String getLinkedList() {
		 Link current=head;
		 String listContent ="";
		 while(current!=null){
			listContent+=current.getLink();
			current=current.next;
		} 
		
		return listContent;
	 }
}
