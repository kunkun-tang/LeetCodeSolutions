package _448_Find_All_Numbers_Disappered;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Solution {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    int len = nums.length;
    IntStream.range(0, nums.length).forEach( i -> {
      nums[ (nums[i] -1 ) % len] += len;
    });

    List<Integer> list = new ArrayList<Integer> ();
    IntStream.range(0, nums.length).forEach( i -> {
      if(nums[i] <= len) list.add(i+1);
    });

    return list;
  }
}
