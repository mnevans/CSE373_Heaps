import java.util.Arrays;

public class ThreeHeap {
   private static final int DEFAULT_CAPACITY = 10; 
   private int size;
   private double[] threeHeap;
   
   public ThreeHeap() {
      threeHeap = new double[DEFAULT_CAPACITY];
      size = 0;
   }
   
   public ThreeHeap(int size) {
      threeHeap = new double[size];
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
      return threeHeap[1];
   }
   
   public void insert(double x) {
      if (size == threeHeap.length - 1) {
         resize();
      }   
      size++;
      threeHeap[size] = x;
      int i = percolateUp(size, x);
   }
   
   private int percolateUp(int hole, double x) {
      
      while (hole > 1 && x < threeHeap[(hole + 1) / 3]) {
         threeHeap[hole] = threeHeap[(hole + 1) / 3];
         hole = (hole + 1) / 3;
      }
      return hole;
   }
   
   public double deleteMin() {
      if (isEmpty()) {
         throw new EmptyPQException("Priority queue is empty.");
      }   
      double ans = threeHeap[1];
      int hole = percolateDown(1, threeHeap[size]);
      threeHeap[hole] = threeHeap[size];
      size--;
      return ans;
   }
   
   private int percolateDown(int hole, double x) {
      
      while (3 * hole <= size) {
         int left = 3 * hole - 1;
         int middle = 3 * hole;
         int right = middle + 1;
         int target = 0;
         
         if (right <= size) {
            if (threeHeap[right] <= threeHeap[middle] && threeHeap[right] <= threeHeap[left]) {
               target = right;
            } else if (threeHeap[middle] <= threeHeap[right] 
                      && threeHeap[middle] <= threeHeap[left]) {
               target = middle;
            } else {
               target = left; 
            } 
         }     
         
         if (right > size) {
            if (threeHeap[left] < threeHeap[middle]) {
               target = left;
            } else {
               target = middle;
            } 
         }  
            
         if (threeHeap[target] < x) {
            threeHeap[hole] = threeHeap[target];
            hole = target;
         } else {
            break;
         }
      }   
      return hole;
   }
   
   public void makeEmpty() {
      threeHeap = new double[10];
      size = 0;
   }
   
   private void resize() {
      final double[] newHeap = new double[threeHeap.length * 2];
      for (int i = 0; i <= size; i++) {
         newHeap[i] = threeHeap[i];
      }
      threeHeap = newHeap;
   }
}
