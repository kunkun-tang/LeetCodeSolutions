package _215_Kth_Largest_Elem_in_Array_;

import java.util.PriorityQueue;

public class Solution_PriorityQueue {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int num: nums) {
      if(pq.size() <k) pq.add(num);
      else {
        int head = pq.peek();
        // System.out.println("head =" + head + " num=" + num);
        if(num>head) {
          pq.poll();
          pq.add(num);
        }
      }
    }
    return pq.peek();
  }
}
