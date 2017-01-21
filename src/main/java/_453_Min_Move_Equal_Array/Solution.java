package _453_Min_Move_Equal_Array;


public class Solution {
  public int minMoves(int[] nums) {
    if(nums.length <=1) return 0;
    int len = nums.length, ret = 0, min= Integer.MAX_VALUE;
    for(int i=0; i<len; i++)
      if(nums[i] < min) min = nums[i];

    for(int i=0; i<len; i++) {
      ret += nums[i] - min;
    }
    return ret;
  }
}
