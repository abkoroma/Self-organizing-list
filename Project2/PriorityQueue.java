
public interface PriorityQueue<V, P> {
	
	/**
	* Clears or initializes the sequence of discrete priorities
	* ordered from highest priority to lowest priority.
	*
	* Each constructor must call this method exactly once.
	*/
	void clearPriorities();
	/**
	* Appends a new lowest priority to the priorities sequence.
	*
	* This method must be called after the clear operation is called
	* but before any value accessors or mutators are called.
	* @param priority The priority to append
	*/
	void appendPriority(P priority);
	/**
	* Adds a new value with a given priority behind
	* all other values with the same or higher priority
	* and before all values with a lower priority.
	* @param value A value to add
	* @param priority A priority for the value
	*/
	void enqueue(V value, P priority);
	/**
	* Removes the oldest value with the highest priority.
	* @return The value to be removed
	*/
	V dequeue();
	/**
	* Accesses the oldest value with the highest priority.
	* @return The value to be accessed
	*/
	V peek();
	/**
	* Determines whether the priority queue has no values.
	* @return Whether the priority queue is empty
	*/
	boolean isEmpty();
	/**
	* Neatly represents the values in the priority
	* queue in descending order of priority with both
	* their values and priorities.
	*/
	String toString();

}
