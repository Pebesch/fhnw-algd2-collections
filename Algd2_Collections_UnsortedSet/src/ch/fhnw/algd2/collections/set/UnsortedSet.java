package ch.fhnw.algd2.collections.set;

import java.util.Arrays;
import java.util.Set;

import ch.fhnw.algd2.collections.MyAbstractCollection;

public class UnsortedSet<E extends Comparable<E>> extends
		MyAbstractCollection<E> implements Set<E> {

	public static final int DEFAULT_CAPACITY = 100;
	private int capacity;

	private Object[] data;

	public UnsortedSet() {
		this(DEFAULT_CAPACITY);
	}

	public UnsortedSet(int capacity) {
		this.capacity = capacity;
		data = new Object[capacity];
	}

	@Override
	public boolean add(E e) {
	}

	@Override
	public boolean remove(Object o) {
	}


	@Override
	public boolean contains(Object o) {
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(data, size());
	}

	@Override
	public int size() {
		
	}

	public static void main(String[] args) {
		UnsortedSet<Integer> bag = new UnsortedSet<Integer>();
		bag.add(2);
		bag.add(2);
		bag.add(1);
		System.out.println(Arrays.toString(bag.toArray()));
	}

}
