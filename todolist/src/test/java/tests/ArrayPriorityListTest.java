package tests;

/** 
 * Unit test for ArrayPriorityList.
 * 
 *@author Rick Mercer and Farrah Rodriguez
*/

// Using
import static org.junit.Assert.*; // Using JUnit 4
// import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.Test;

// We must import files when in a different package
import model.ArrayPriorityList;

public class ArrayPriorityListTest {

  @Test
  public void testToArrayReturnsACloneOfTheInstanceVariable() {
    ArrayPriorityList<Integer> list = new ArrayPriorityList<Integer>(10);

    list.insertElementAt(0, 77);
    list.insertElementAt(1, 88);
    list.insertElementAt(2, 99);

    Object[] result = list.toArray();
    // Make sure the new array built in toArray has capacity == n
    assertEquals(3, result.length);
    // Make sure the elements and indexes match in the Object[]
    assertEquals(77, result[0]);
    assertEquals(88, result[1]);
    assertEquals(99, result[2]);

    // Make sure you did simply not return a reference to data
    // because a change to result should NOT affect data
    result[0] = 12345678;
    result[1] = Integer.MAX_VALUE;
    result[2] = Integer.MIN_VALUE;
    assertEquals(77, (int) list.getElementAt(0));
    assertEquals(88, (int) list.getElementAt(1));
    assertEquals(99, (int) list.getElementAt(2));
  }

  @Test
  public void testRemoveElementAt() {
    ArrayPriorityList<Integer> list = new ArrayPriorityList<Integer>(10);

    list.insertElementAt(0, 77);
    list.insertElementAt(1, 88);
    list.insertElementAt(2, 99);
    list.insertElementAt(3, 100);

    list.removeElementAt(1);

  }

  @Test
  public void testLowerPriorityOf() {
    ArrayPriorityList<Integer> list = new ArrayPriorityList<Integer>(10);

    list.insertElementAt(0, 100);
    list.insertElementAt(1, 90);
    list.insertElementAt(2, 80);
    list.insertElementAt(3, 70);

    list.lowerPriorityOf(1);

    Object[] result = list.toArray();
    assertEquals(100, result[0]);
    assertEquals(80, result[1]);
    assertEquals(90, result[2]);
    assertEquals(70, result[3]);

  }

  @Test
  public void testRaisePriorityOf() {
    ArrayPriorityList<Integer> list = new ArrayPriorityList<Integer>(10);

    list.insertElementAt(0, 100);
    list.insertElementAt(1, 90);
    list.insertElementAt(2, 80);
    list.insertElementAt(3, 70);

    list.raisePriorityOf(1);

    Object[] result = list.toArray();
    assertEquals(90, result[0]);
    assertEquals(100, result[1]);
    assertEquals(80, result[2]);
    assertEquals(70, result[3]);
  }

  @Test
  public void testMoveToLast() {
    ArrayPriorityList<Integer> list = new ArrayPriorityList<Integer>(10);

    list.insertElementAt(0, 100);
    list.insertElementAt(1, 90);
    list.insertElementAt(2, 80);
    list.insertElementAt(3, 70);

    list.moveToLast(1);

    Object[] result = list.toArray();
    assertEquals(100, result[0]);
    assertEquals(80, result[1]);
    assertEquals(70, result[2]);
    assertEquals(90, result[3]);

  }

  @Test
  public void testMoveToLastFinalElement() {
    ArrayPriorityList<Integer> list = new ArrayPriorityList<Integer>(10);

    list.insertElementAt(0, 100);
    list.insertElementAt(1, 90);
    list.insertElementAt(2, 80);
    list.insertElementAt(3, 70);

    list.moveToLast(1);

    Object[] result = list.toArray();
    assertEquals(100, result[0]);
    assertEquals(80, result[1]);
    assertEquals(70, result[2]);
    assertEquals(90, result[3]);

  }

  @Test
  public void testMoveToTop() {
    ArrayPriorityList<Integer> list = new ArrayPriorityList<Integer>(10);

    list.insertElementAt(0, 100);
    list.insertElementAt(1, 90);
    list.insertElementAt(2, 80);
    list.insertElementAt(3, 70);

    list.moveToTop(1);

    Object[] result = list.toArray();
    assertEquals(90, result[0]);
    assertEquals(100, result[1]);
    assertEquals(80, result[2]);
    assertEquals(70, result[3]);

  }

  // Add many more @Tests

}
// End unit test for PriorityList