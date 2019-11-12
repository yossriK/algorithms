import java.util.Arrays;

// my own implemented ArrayList
public class ArrayList {

    private SinglyLinkedList[] list;// array of SinglyLinkedLists
	private int size=0;
	
	// constructor of the ArrayList,list A is the parameter
	public ArrayList(String[] r) {
		list= new SinglyLinkedList[r.length];
		
		this.build(r);
	}
	// returns actual occupied size of the list
	public int getSize() {
		return size;
	}
	 // adding new SinglyLinkedList object to the ArrayList list
	public void add(SinglyLinkedList e) {
		if(listDoesNotExist(e)) { // checking if the SinglyLinkedList doesnt already exist in
								// the ArrayList
				list[size]=e;
				size++;
		}
	
		
	}
	
	// building the ArrayList of SinglyLinkedList of anagrams
	public void build(String []r)
	{
		for( int i=0;i<r.length;i++) {
			SinglyLinkedList temp= new SinglyLinkedList(r[i]);
			for(int j=i+1;j<r.length;j++) {
				if(sortString(r[i]).compareTo(sortString(r[j]))==0) // if the word is an angram then its added to the SinglyLinkedlist
					temp.add(r[j]);
			}
			this.add(temp); // the SinglyLinkedList is then added to the the ArrayList list
			
		}
		
	}
	
	  // sorts the word alphabetically to be compared to other words to check if they are anagrams
    public static String sortString(String inputString) 
    { 
        // convert input  
        // string to char array 
        char tempArray[] =  
             inputString.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray); 
          
        // return new sorted string 
        return new String(tempArray); 
    } 
    
    
    // test code to print my list
//    public void display() {
//    	for (int i=0;i<size;i++) {
//    		list[i].displaySinglyList();
//    		
//    	}
//    	
//    }
    	
    	
// boolean check if a SinglyLinkedList of anagrams already exists or not
     boolean listDoesNotExist(SinglyLinkedList e) {
    	
    	 if(size==0)
    		 return true;
    	 for( int i=0;i<size;i++) {
 			if(sortString(list[i].head.name).compareTo(sortString(e.head.name))==0) {// if the first shit exists, dont add it
 				return false;
 			}
    	 }
 			
    	 return true;
    	 }
     
     // returns SinglyLinkedList object at index i of ArrayList list ( list B)
     public SinglyLinkedList getIndex(int i) {
    	 return list[i];
    	 
    	 
     }
     
     
 
 }
     
    