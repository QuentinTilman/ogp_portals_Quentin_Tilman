package linkedHashSet;

import collections.HashMap;
import collections.Set;

public class LinkedHashSet implements Set{

	private HashMap buckets;
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
	
	public LinkedHashSet(int capacity) {
		this.buckets = new HashMap(capacity);
		this.sentinel = new Node();
		sentinel.next = sentinel;
		sentinel.previous = sentinel;
		this.size = 0;
	}
	
	@Override
	public Object[] toArray() {
		Object[] result = new Object[size];
		Node node = sentinel.next;
		for(int i = 0; i < size; i++) {
			result[i] = node.element;
			node= node.next;
		}
		return result;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(Object value) {
		return buckets.get(value) != null;
	}

	@Override
	/**
	 * @throws IllegalArgumentException | value == null
	 * @post | old(contains(value)) ? contains(value) && size() == old(size()) + 1 : contains(value) && old(size()) == size() 
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
