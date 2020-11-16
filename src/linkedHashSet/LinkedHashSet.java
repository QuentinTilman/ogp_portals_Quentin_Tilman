package linkedHashSet;

import collections.HashMap;
import collections.Set;

/**
 * @author QT
 *
 */
public class LinkedHashSet implements Set{

	/**
	 * @invar | buckets != null
	 * @representationObject
	 */
	private HashMap buckets;
	/**
	 * @representationObject
	 */
	private Node sentinel;
	private int size;

	private class Node {
		/**
		 * @invar | (element == null) == (this == sentinel)  
		 * @invar | previous != null
		 * @invar | next != null
		 * @invar | next.previous == this
		 * @invar | previous.next == this
		 * 
		 * @peerObject
		 */
		private Node previous;
		private Object element;
		/** @peerObject */
		private Node next;
		}
	
	/**
	 * @pre | 0 < capacity
	 * @post size() == 0
	 */
	public LinkedHashSet(int capacity) {
		this.buckets = new HashMap(capacity);
		this.sentinel = new Node();
		sentinel.next = sentinel;
		sentinel.previous = sentinel;
		this.size = 0;
	}
	
	@Override
	/**
	 * @inspect | this
	 * @creates | result
	 * @post | result != null
	 * 
	 */
	public Object[] toArray() {
		Object[] array = new Object[size];
		Object[] result = new Object[size];
		Node node = sentinel.next;
		for(int i = 0; i < size; i++) {
			array[i] = node.element;
			node= node.next;
		}
		System.arraycopy(array, 0, result, 0, size);
		return result;
	}

	@Override
	/**
	 * @post | result == toArray().length
	 */
	public int size() {
		return size;
	}

	@Override
	/**
	 * @inspects | this
	 */
	public boolean contains(Object value) {
		return buckets.get(value) != null;
	}

	@Override
	/**
	 * @throws IllegalArgumentException | value == null
	 * @post | old(contains(value)) ? contains(value) && old(size()) == size()  : contains(value) && size() == old(size()) + 1 
	 */
	public void add(Object value) {
		if(value == null)
			throw new IllegalArgumentException("Value may not be null");
		if(contains(value))
			return;
		Node node = new Node();
		node.element = value;
		node.previous = sentinel.previous;
		sentinel.previous.next = node;
		sentinel.previous = node;
		buckets.put(value, node);
		size ++;
	}

	@Override
	/**
	 * @post | old(contains(value)) ? !contains(value) && size() == old(size()) - 1 : !contains(value) && old(size()) == size() 
	 */
	public void remove(Object value) {
		if(!contains(value))
			return;
		Node node = (Node) buckets.get(value);
		node.next.previous = node.previous;
		node.previous.next = node.next;
		buckets.remove(value);
		size--;
	}	
}
