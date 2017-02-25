package _75_Sort_colors_;

public class Solution {
  public void sortColors(int[] nums) {
    if (nums == null || nums.length == 0) return;
    else if (nums.length == 1) return;

    int l=0, r=nums.length-1;

    while(l<r) {
      // for(int i=0; i<nums.length; i++)
      //     System.out.print(nums[i] + " ");
      // System.out.print("\n");

      if(nums[l] == 1 && nums[r] == 1) {
        int tempL = l, tempR = r;
        while(tempL<tempR)
          if(nums[tempL] == 1 && nums[tempR] == 1) {
            tempL ++; tempR --;
          } else break;
        if(tempL == tempR && nums[tempL] == 1) return;
        if(tempL>tempR) return;
        swap(nums, l, tempR);
        if(tempR != tempL)
          swap(nums, r, tempL);
      } else {
        if(nums[l] > nums[r]) {
          swap(nums, l, r);
        }
        if(nums[l] == 0) l++;
        if(nums[r] == 2) r--;
      }
    }

  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
