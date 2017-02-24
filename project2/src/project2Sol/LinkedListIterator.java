package project2Sol;
import java.util.Iterator;

public class LinkedListIterator implements Iterator<ProduceItem> {

	ProduceItemNode first = null;

	public LinkedListIterator(ProduceItemNode first) {
		this.first = first;
	} // constructor

	@Override
	public boolean hasNext() {
		if (this.first == null || this.first.next == null) {
			return false;  // either first or first pointer to next is null, return false,otherwise return true.
		}
		return true;
	}

	@Override
	public ProduceItem next() {
		first = first.next;
		return first.data; 
	}

}
