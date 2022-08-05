import java.util.NoSuchElementException;


public class SelforganizingListPQ<V, P> implements PriorityQueue<V, P> {
	Node head;
	Node tail;
	Node priorityHead;
	Node priorityTail;
	int capacity;
	int size;
	
	public SelforganizingListPQ() {
		clearPriorities();
	}
	
	private class Node {
		
		Node next;
		V value; 
		P priority;
		
		public Node(V element, P priority) {
			this.value = element;
			this.priority = priority;
			next = null;
		}


	}

	@Override
	public void clearPriorities() {
		head = null;
		tail = null;
		priorityHead = null;
		priorityTail = null;
		size = 0;
		capacity = 0;
	}

	//Runs in linear time since we are iterating through the priority queue
	@Override
	public void appendPriority(P priority) {
		V value = null;
		
		if (isEmpty()) {
			priorityTail = new Node(null, priority);
			priorityHead = priorityTail;
			
		}
		else {
			priorityTail.next = new Node(null, priority);
			priorityTail = priorityTail.next; 
			
		}
		capacity++;	
	}
	
	//Runs in linear time we are iterating through the queue
	@Override
	public void enqueue(V value, P priority) {
		if (isEmpty()) {
			tail = new Node(value, priority);
			head = tail;
		}
		else {
			Node n = head;
			Node prev = null;
			while (n != null) {
				if (compareTo(n.priority, priority) < 0) {
					prev.next = new Node(value, priority);
					prev.next.next = n;
				}
				if (compareTo(n.priority, priority) > 0) {
					prev.next = new Node(value, priority);
					prev.next.next = n;
				}
				prev = n;
				n = n.next;
			}
			
		}
		size++;
	}
	
	//Runs in constant time because it removes the head element
	@Override
	public V dequeue() {
		
		if (isEmpty()) {
			throw new NoSuchElementException ();
		}
		if (head == null) {
			tail = null;
		}

		size--;
		
		Node tempNode = head;
		head = head.next;
		
	
		return tempNode.value;
	}
	// Runs in constant time O(1) because its not iterating through anything
	@Override
	public V peek() {
		if (isEmpty()) {
			return null;
		}
		return  head.value;
	}
	
	//Runs in constant time
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	//Runs in linear time
	@Override
	public String toString() {
   	 	String s = "[";
   	 	Node n = head;
   	 	while(n != null) {
   	 		s += n.value + ", ";
   	 		n = n.next;
   	 	}
   	 
   	 	if(s.length() > 1)
   	 		s = s.substring(0, s.length() - 2);
   	 	s += "]";
   	 	return s;
    }
	
	//Runs in linear time
	public int compareTo(P p1, P p2) {
		if(p1.equals(p2)) {
			return 0;
		}
		Node n = priorityHead;
		while (n != null) {
			if (n.equals(p1)) {
				return 1;
			}
			if (n.equals(p2)) {
				return -1;
			}
			n = n.next;
		}
		return 0;
	}
	
	public static void main(String arg[]) {
		 PriorityQueueTester.test(new SelforganizingListPQ<String, String>());
	}

}
