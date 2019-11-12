
public class Link {
	public String name;
	public Link next;
	
	public Link( String name) {
		this.name=name;
		next=null;
	}
	
	public void displayLink() {
		
		System.out.print( name +" ");
	}
	
	
	
	public String getLink() {
		
		return name+" ";
	}
}
