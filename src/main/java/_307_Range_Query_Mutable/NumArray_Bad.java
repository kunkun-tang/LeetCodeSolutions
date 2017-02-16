package _307_Range_Query_Mutable;

public class NumArray_Bad {

  class TreeNode{
    int start;
    int end;
    int sum;
    TreeNode leftChild;
    TreeNode rightChild;
    public TreeNode(int left, int right, int sum){
      this.start=left;
      this.end=right;
      this.sum=sum;
    }
  }

  TreeNode root;
  int[] nums;

  public NumArray_Bad(int[] nums) {
    if(nums != null && nums.length > 0) {
      this.nums = nums;
      int[] sum = new int[nums.length];
      sum[0] = nums[0];
      for(int i=1; i<nums.length; i++)
        sum[i] = sum[i-1] + nums[i];
      root = create (nums, sum, 0, nums.length-1);
    }
  }

  public TreeNode create(int[] nums, int[] sum, int left, int right) {
    if(left > right) return null;
    if(left == right) {
      return new TreeNode(left, left, nums[left]);
    } else {
      TreeNode curr = new TreeNode(left, right, sum[right] - sum[left] + nums[left]);
      int mid = left + (right - left)/2;
      curr.leftChild = create(nums, sum, left, mid);
      curr.rightChild = create(nums, sum, mid+1, right);
      return curr;
    }
  }

  public void update(int i, int val) {
    int offset = val - nums[i];
    updateValue(root, i, offset);
  }

  public void updateValue(TreeNode root, int index, int offset) {
    //         System.out.println("=== i =" + index);
    // System.out.println("root.start =" + root.start);
    // System.out.println("root.end =" + root.end);
    root.sum += offset;
    int ret = leftOrRight(root, index);
    if(ret == 1) updateValue(root.leftChild, index, offset);
    else if (ret == -1) updateValue(root.rightChild, index, offset);
    else return;
  }

  public int leftOrRight(TreeNode root, int i) {
    if(root.leftChild != null) {
      if(i >= root.leftChild.start && i <= root.leftChild.end) return 1;
    }
    if(root.rightChild != null) {
      if(i >= root.rightChild.start && i <= root.rightChild.end) return -1;
    }
    return 0;
  }

  public int sumRange(int i, int j) {
    return query(root, i, j);
  }

  public int query(TreeNode root, int i, int j) {
    // System.out.println("=== i =" + i + " j =" + j);
    // System.out.println("root.start =" + root.start);
    // System.out.println("root.end =" + root.end);
    if(i> root.end || j < root.start) return 0;
    if(i <= root.start && j >= root.end) return root.sum;
    else {
      int retLeft = 0, retRight = 0;
      if(root.leftChild != null) {
        retLeft = query(root.leftChild, i, j);
      }
      if(root.rightChild != null) {
        retRight = query(root.rightChild, i, j);
      }
      // System.out.println("retLeft =" +retLeft);
      // System.out.println("retRight =" + retRight);
      return retLeft + retRight;
    }
  }
}


