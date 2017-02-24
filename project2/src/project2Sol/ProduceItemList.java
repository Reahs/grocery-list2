package project2Sol;

import java.util.Iterator;
public class ProduceItemList {
	
	private ProduceItemNode first = new ProduceItemNode (null);
	private ProduceItemNode last = first;
	private int length = 0;
	
	// get the number of elements in the list
	public int getLength(){
		return length;
	}
	
	//append method
	public void append(ProduceItem d){
		ProduceItemNode node = new ProduceItemNode(d);
		last.next = node;
		last = node;
		++length;
	}
	
	// prepend method
	public void prepend(ProduceItem d) {
		ProduceItemNode node = new ProduceItemNode(d);
		node.next = first.next;
		first.next = node;
		if(first == last) last = node;
		++length;
	}
	
	// toString method
	public String toString(){
		ProduceItemNode p = first.next;
		String returnString = "";
		while(p != null){
			returnString += p.data + " ";
		    p = p.next;	
	}
	 return returnString;	
} 
	
	// equal object
	public boolean equals(Object other){
		if (other == null || getClass () !=other.getClass()|| length != ((ProduceItemList)other).length)
			return false;
		
		ProduceItemNode nodeThis = first;
		ProduceItemNode nodeOther = ((ProduceItemList)other).first;
		while (nodeThis != null){
			if (nodeThis.data != nodeOther.data)
				return false;
		    nodeThis = nodeThis.next;
     	    nodeOther = nodeOther.next;
			
	    }// while
	      return true;
	}
	
    // Linked list iterator will go through the list from the first node
	public Iterator<ProduceItem> iterator()
	   {
	      return new LinkedListIterator(first);
	   }

}	
	
	
