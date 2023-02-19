package model;

import java.util.Iterator;

// PriorityList objects store a collection of elements as an indexed list.
public class ArrayPriorityList<E> implements PriorityList<E>, Iterable<E> {
  private Object[] data;
  private int n;

  // Create an empty list with zero elements
  public ArrayPriorityList(int initialCapacity) {
    data = new Object[initialCapacity];
    n = 0;
  }  
 
  public void insertElementAt(int index, E el) throws IllegalArgumentException {
    if (index < 0 || index > size())
      throw new IllegalArgumentException();
    if (shouldGrowArray()) 
      gowArray();
    makeRoomAt(index);
    addAt(index, el);
 }  
  
  public void gowArray() {
    
    Object[] temp = new Object[data.length + 20];
    for (int i = 0; i < n; i++)
      temp[i] = data[i];
    data = temp;
  }

  private boolean shouldGrowArray() {
     return n == data.length;
  }
  
  private void addAt(int index, E el) {
    data[index] = el;
    n++;
  }

  private void makeRoomAt(int index) {
    for (int j = n; j > index; j--)
      data[j] = data[j - 1];
  }


  // Return the number of elements currently in this PriorityList
  public int size() {
    return n;
  }

  // If possible, return a reference to the element at the given index.
  @SuppressWarnings("unchecked")
  public E getElementAt(int index) throws IllegalArgumentException {
    if (index < 0 || index >= size())
      throw new IllegalArgumentException();
    Object o = data[index];
    return (E) o;
  }

  // If possible, remove the element at the given index.
  public void removeElementAt(int index) throws IllegalArgumentException {
    if (index < 0 || index >= size())
      throw new IllegalArgumentException();
    for (int j = index; j < n; j++)
      data[j] = data[j + 1];
    n--;
  }

  // If possible, move the element at index to index + 1.
  public void lowerPriorityOf(int index) throws IllegalArgumentException {
    if (index < 0 || index >= size())
      throw new IllegalArgumentException();
    if (index == size() - 1)
      return;
    if (index < size() - 1)
      swap(index, index + 1);
  }

  private void swap(int index, int i) {
    Object temp = data[index];
    data[index] = data[i];
    data[i] = temp;
  }

  // If possible, move the element at index to index - 1.
  public void raisePriorityOf(int index) throws IllegalArgumentException {
    if (index < 0 || index >= size())
      throw new IllegalArgumentException();

    if (index > 0)
      swap(index, index - 1);
  }

  // Return an array of objects that is the size of this Priority list and in
  // the same order. If there are no elements, return new Object[0].
  public Object[] toArray() {
    if (n == 0)
      return new String[0];

    Object[] temp = new Object[n];

    for (int i = 0; i < temp.length; i++)
      temp[i] = data[i];

    return temp;
  }

  // If possible, move the element at the given index to the end of this list.
  public void moveToLast(int index) throws IllegalArgumentException {
    if (index < 0 || index >= size())
      throw new IllegalArgumentException();
    Object temp = data[index];
    for (int j = index; j < n; j++)
      data[j] = data[j + 1];
    data[n - 1] = temp;
  }

  // If possible, move the element at the given index to the front of this list.
  public void moveToTop(int index) {
    if (index < 0 || index >= size())
      throw new IllegalArgumentException();
    Object temp = data[index];

    for (int j = index; j > 0; j--)
      data[j] = data[j - 1];

    data[0] = temp;
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public Iterator<E> iterator() {
    return new ArrayIter();
  }
  
  private class ArrayIter implements Iterator<E> {

    int index = 0;
    
    @Override
    public boolean hasNext() {
      return index < size();
    }

    @Override
    public E next() {
      @SuppressWarnings("unchecked")
      E temp = (E) data[index];
      index++;
      return temp;
    }  
    
  }
}