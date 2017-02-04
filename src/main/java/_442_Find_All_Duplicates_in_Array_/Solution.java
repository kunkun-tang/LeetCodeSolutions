package _442_Find_All_Duplicates_in_Array_;

import java.util.List;
import java.util.ArrayList;

public class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> retList = new ArrayList<>();
    for(int num: nums) {
      int remain = num%(nums.length+1);
      int index = remain-1;
      nums[index] += nums.length + 1;
    }
    for(int i=0; i<nums.length; i++) {
      if(nums[i] > 2*(nums.length + 1)) retList.add(i+1);
    }
    return retList;
  }
}
