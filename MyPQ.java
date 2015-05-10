// Morgan Evans, 1124703, mnevans

import java.util.Arrays;

public class MyPQ implements PriorityQueue {
  
   private static final int DEFAULT_CAPACITY = 10;
   private int size;
   private double[] array;
   
   // create a new array of default capacity
   public MyPQ() {
      array = new double[DEFAULT_CAPACITY];
      size = 0;
   }
   
   // create a new array with a predetermined size
   public MyPQ(int size) {
      array = new double[size];
      size = 0;
   }
   
   // return true if the array is empty
   public boolean isEmpty() {
      return size == 0;
   }
   
   // return the number of elements in the array
   public int size() {
      return size;
   }
   
   // find and return the minimum value in the array
   public double findMin() {
      if (isEmpty()) {
         throw new EmptyPQException("Priority queue is empty.");
      }
      double min = array[0];
      for (int i = 0; i <= size; i++) {
         if (array[i] < min) {
            min = array[i];
         }
      }
      return min;
   }
   
   // insert a new value into the array
   public void insert(double x) {
      if (size == array.length - 1) {
         resize();
      }   
      if (size == 0) {
         array[size] = x;
      } else {
         double first = array[0];
         
         if (x >= first) {
            array[size] = x;
         } else {
            array[size] = first;
            array[0] = x;  
         }
      }
      size++;            
   }
   
   // delete the minimum value from the array
   public double deleteMin() {
      if (isEmpty()) {
         throw new EmptyPQException("Priority queue is empty.");
      }   
      double min = array[0];
      double first = array[1];
      int index = 1;
      
      for (int i = 0; i <= size; i++) {
         if (array[i] <= first) {
            first = array[i];
            index = i;
         }
      }
      array[0] = array[index];
      array[index] = array[size - 1];
      size--;
      return min;
   }
   
   // empty the array
   public void makeEmpty() {
      array = new double[10];
      size = 0;
   }
   
   // resize the array to being twice as large once it becomes full
   private void resize() {
      final double[] newHeap = new double[array.length * 2];
      for (int i = 0; i < size; i++) {
         newHeap[i] = array[i];
      }
      array = newHeap;
   }
}
