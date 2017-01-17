package _456_132Pattern;

public class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3) return false;
        for(int j=0, min=Integer.MAX_VALUE; j<nums.length-1 ; j++) {
            min = Math.min(min, nums[j]);

            if(nums[j] > min)
                for (int k=nums.length-1; k>j; k--) {
                    if(nums[k] > min && nums[k] < nums[j]) return true;
                }
        }
        return false;
    }
}