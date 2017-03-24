package _334_Increasing_Triplet_Subsequence;

public class Solution {
  public boolean increasingTriplet(int[] nums) {
    if(nums == null || nums.length < 3) return false;
    int len = nums.length;
    for(int i=0; i<=len-3; i++) {
      if(nums[i] < nums[i+1] && nums[i+1] < nums[i+2]) return true;
    }

    int curr = Math.min(nums[0], nums[1]), curr2 = Integer.MIN_VALUE;
    int i = 2;
    while(i < nums.length) {
      if(curr2 == Integer.MIN_VALUE) {
        if(nums[i] > curr)
          curr2 = nums[i];
        else
          curr = nums[i];
      } else {
        if(nums[i] > curr2)
          return true;
        else {
          if(nums[i] > curr) {
            curr2 = nums[i];
          } else {
            if(i+1 < len && nums[i] < nums[i+1]) {
              if(nums[i+1] > curr2) return true;
              curr = nums[i];
              curr2 = Integer.MIN_VALUE;
            }
          }
        }
      }
      i++;
    }
    return false;
  }
}
