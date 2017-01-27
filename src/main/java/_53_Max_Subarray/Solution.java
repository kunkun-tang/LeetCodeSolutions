package _53_Max_Subarray;

import java.util.stream.IntStream;
import java.util.Arrays;

public class Solution {
  public int maxSubArray(int[] nums) {
    int[] dp = new int [nums.length];
    dp[0] = nums[0];
    IntStream.range(1, nums.length).forEach( i -> {
      dp[i] = dp[i-1] + nums[i]> nums[i] ? dp[i-1] + nums[i] : nums[i];
    });
    return Arrays.stream(dp).reduce(Integer.MIN_VALUE, Integer::max);
  }
}
