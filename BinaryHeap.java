import java.util.Arrays;

public class BinaryHeap implements PriorityQueue {  
   private static final int DEFAULT_CAPACITY = 10;
   private int size;
   private double[] arr;
   
   public BinaryHeap() {
      arr = new double[DEFAULT_CAPACITY];
      size = 0;
   }
   
   public BinaryHeap(int size) {
      arr = new double[size];
      size = 0;
   }
   
   public boolean isEmpty() {
      return size == 0;
   }
   
   public int size() {
      return size;
   }
   
   public double findMin() {
      if (isEmpty()) {
         throw new EmptyPQException("Priority queue is empty.");
      }
      return arr[1];
   }
   
   public void insert(double x) {
      if (size == arr.length - 1) {
         resize();
      }   
      size++;
      int i = percolateUp(size, x);
      arr[i] = x;
   }
   
   private int percolateUp(int hole, double x) {
      while (hole > 1 && x < arr[hole / 2]) {
         arr[hole] = arr[hole / 2];
         hole = hole / 2;
      }
      return hole;
   }
   
   public double deleteMin() {
      if (isEmpty()) {
         throw new EmptyPQException("Priority queue is empty.");
      }   
      double ans = arr[1];
      int hole = percolateDown(1, arr[size]);
      arr[hole] = arr[size];
      size--;
      return ans;
   }
   
   private int percolateDown(int hole, double x) {
      int target;
      
      while (2 * hole <= size) {
         int left = 2 * hole;
         int right = left + 1;
         
         if (right > size || arr[left] < arr[right]) {
            target = left;
         } else {
            target = right;
         }   
         if (arr[target] < x) {
            arr[hole] = arr[target];
            hole = target;
         } else {
            break;
         }
      }   
      return hole;
   }
   
   public void makeEmpty() {
      arr = new double[10];
      size = 0;
   }
   
   private void resize() {
      final double[] newHeap = new double[arr.length * 2];
      for (int i = 0; i <= size; i++) {
         newHeap[i] = arr[i];
      }
      arr = newHeap;
   }
}
