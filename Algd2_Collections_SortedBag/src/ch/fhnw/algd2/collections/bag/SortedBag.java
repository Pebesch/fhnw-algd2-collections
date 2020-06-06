package ch.fhnw.algd2.collections.bag;

import java.util.Arrays;

import ch.fhnw.algd2.collections.MyAbstractCollection;

public class SortedBag<E extends Comparable<E>> extends MyAbstractCollection<E> {

	public static final int DEFAULT_CAPACITY = 100;
	private int capacity;
	private Object[] data;
	private int size;

	public SortedBag() {
		this(DEFAULT_CAPACITY);
	}

	public SortedBag(int capacity) {
		this.capacity = capacity;
		data = new Object[capacity];
		size = 0;
	}

	@Override
	public boolean add(E e) {
		if(e == null) throw new NullPointerException();
		if(size == capacity) throw new IllegalStateException();
		int pos = Arrays.binarySearch(data,0,size,e);
		if (pos < 0)
			pos = -(pos + 1);
		for (int i = size; i > pos; --i){
			data[i] = data[i-1];
		}
		data[pos] = e;
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		int pos = Arrays.binarySearch(data, 0, size, o);
		if(pos < 0) {
			return false;
		} else {
			for(int i = pos; i < size - 1; i++) {
				data[i] = data[i + 1];
			}
			size--;
			return true;
		}
	}

	@Override
	public boolean contains(Object o) {
		if(o == null) throw new NullPointerException();
		return find(o) >= 0;
	}


	@Override
	public Object[] toArray() {
		return Arrays.copyOf(data, size());
	}

	@Override
	public int size() {
		return size;
	}

	private int find(Object o) {
		try {
			for(int i = 0; i < size; i++) {
				if(((E)o).compareTo((E)data[i]) == 0) return i;
			}
		} catch (ClassCastException e) {
			throw e;
		}
		return -1;
	}

	public static void main(String[] args) {
		SortedBag<Integer> bag = new SortedBag<Integer>();
		bag.add(2);
		bag.add(1);
		System.out.println(Arrays.toString(bag.toArray()));
	}

}
