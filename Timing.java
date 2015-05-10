// Morgan Evans, 1124703, mnevans

public class Timing {
   public static final int NUM_TIMINGS = 5;

   public static void main(String[] args) {
      
      // uncomment the desired heap to be timed
      BinaryHeap heap = new BinaryHeap();
      //ThreeHeap heap = new ThreeHeap();
      //MyPQ heap = new MyPQ();
      
      for(int i = 1; i <= NUM_TIMINGS; ++i) {
         // start the time taken to insert and delete values from the heap
         long startTime = System.nanoTime();  
         
         // uncomment the loop to be timed as desired
         
         /*
         for (int j = 0; j <= 10; j++) {
            heap.insert(j);
         } 
         */

         /*
         for (int j = 0; j <= 100; j++) {
            heap.insert(j);
         }
         */
         
         /*
         for (int j = 0; j <= 1000; j++) {
            heap.insert(j);
         }
         */
         
         /*
         for (int j = 0; j <= 10000; j++) {
            heap.insert(j);
         } 
         */

         for (int k = 0; k <= heap.size(); k++) {
            heap.deleteMin();
         }
         
         // stop the time taken to insert and delete minimum values from the heap
         long endTime = System.nanoTime();

         // total time taken inserting and deleting values from the selected heap
         long elapsedTime = endTime - startTime;
         
         System.out.println("This took " + elapsedTime + " nanoseconds to insert and delete "
                            + i + " values.");
      }         
   }
}
