package _215_Kth_Largest_Elem_in_Array_;


public class Solution_QuickSelect {
  public int findKthLargest(int[] nums, int k) {

    int target = nums.length - k;
    int low = 0, high = nums.length-1;
    while(low <= high) {
      int ret = partition(nums, low, high);
      if(target == ret) return nums[ret];
      else if (target > ret) low = ret + 1;
      else high = ret - 1;
    }
    return -1;
  }

  public int partition(int[] nums, int low, int high) {
    int pivot = nums[high], leftIndex = low;
    for(int i=low; i<high; i++) {
      if(nums[i] <= pivot) {
        swap(nums, leftIndex, i); leftIndex++;
      }
    }
    if(leftIndex <= high)
      swap(nums, leftIndex, high);
    return leftIndex;
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
