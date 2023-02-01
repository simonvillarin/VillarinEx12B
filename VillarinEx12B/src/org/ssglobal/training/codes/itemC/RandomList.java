package org.ssglobal.training.codes.itemC;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Random;

public class RandomList<E> extends AbstractList<E> {

	@SuppressWarnings("unchecked")
	private E[] elementData = (E[]) new Object[0];

	@Override
	public int size() {
		return elementData.length;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean addAll(Collection<? extends E> c) {
		try {
			E[] source = (E[]) c.toArray((E[]) new Object[] {});
			E[] temp = (E[]) new Object[elementData.length + source.length];
			System.arraycopy(elementData, 0, temp, 0, elementData.length);
			System.arraycopy(source, 0, temp, elementData.length, source.length);
			elementData = temp;
			temp = null;
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException, NegativeArraySizeException {
		if (index >= elementData.length) {
			throw new IndexOutOfBoundsException();
		}

		if (index < 0) {
			throw new NegativeArraySizeException();
		}

		E value = elementData[index];
		return value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E element) {
		Random random = new Random();
	    int randomNumber = random.nextInt(elementData.length + 1);
		
		try {
			E[] temp = (E[]) new Object[elementData.length + 1];

			if (elementData.length > 0 && randomNumber == 0) {
				System.arraycopy(elementData, 0, temp, randomNumber + 1, elementData.length - randomNumber);
				temp[randomNumber] = element;
			} else if (elementData.length > 0 && randomNumber == elementData.length) {
				System.arraycopy(elementData, 0, temp, 0, elementData.length);
				temp[randomNumber] = element;
			} else if (elementData.length > 0) {
				System.arraycopy(elementData, 0, temp, 0, randomNumber);
				temp[randomNumber] = element;
				System.arraycopy(elementData, randomNumber, temp, randomNumber + 1, elementData.length - randomNumber);
			} else {
				temp[randomNumber] = element;
			}
			elementData = temp;
			temp = null;
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) {
		try {
			int occurence = 0;
			for (E lookup : elementData) {
				if (lookup.equals(o)) {
					occurence++;
				}
			}

			E[] temp = (E[]) new Object[elementData.length - occurence];
			int j = 0;
			for (E lookup : elementData) {
				if (lookup.equals(o)) {
					continue;
				}

				temp[j] = lookup;
				j++;
			}

			elementData = temp;
			temp = null;
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) throws IndexOutOfBoundsException, NegativeArraySizeException {
		if (index >= elementData.length) {
			throw new IndexOutOfBoundsException();
		}

		if (index < 0) {
			throw new NegativeArraySizeException();
		}

		E[] temp = (E[]) new Object[elementData.length - 1];
		E value = elementData[index];
		
		int i = 0;
		for (E lookup : elementData) {
			if (lookup.equals(value)) {
				continue;
			}

			temp[i] = lookup;
			i++;
		}
		
		elementData = temp;
		temp = null;
		return value;
	}
}
