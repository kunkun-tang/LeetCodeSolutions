package _307_Range_Query_Mutable;

public class NumArray {

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

  public NumArray(int[] nums) {
    if(nums != null && nums.length > 0) {
      root = create (nums, 0, nums.length-1);
    }
  }

  public TreeNode create(int[] nums, int left, int right) {
    if(left > right) return null;
    if(left == right) {
      return new TreeNode(left, left, nums[left]);
    } else {
      TreeNode curr = new TreeNode(left, right, 0);
      int mid = left + (right - left)/2;
      curr.leftChild = create(nums, left, mid);
      curr.rightChild = create(nums, mid+1, right);
      curr.sum = curr.leftChild.sum + curr.rightChild.sum;
      return curr;
    }
  }

  public void update(int i, int val) {
    updateValue(root, i, val);
  }

  public void updateValue(TreeNode root, int index, int val) {
    //         System.out.println("=== i =" + index + " offset =" + offset);
    // System.out.println("root.start =" + root.start);
    // System.out.println("root.end =" + root.end);
    if(root.start == root.end) {
      root.sum = val;
      return;
    }
    int mid = root.start + (root.end-root.start)/2;
    if(index<= mid)
      updateValue(root.leftChild, index, val);
    else
      updateValue(root.rightChild, index, val);
    root.sum = root.leftChild.sum + root.rightChild.sum;
  }

  public int sumRange(int i, int j) {
    return query(root, i, j);
  }

  public int query(TreeNode root, int i, int j) {
    // System.out.println("=== i =" + i + " j =" + j);
    // System.out.println("root.start =" + root.start);
    // System.out.println("root.end =" + root.end);
    if(i== root.start && j == root.end) return root.sum;
    else {
      int mid = root.start + (root.end - root.start)/2;
      if(mid>= j) {
        return query(root.leftChild, i, j);
      } else if (mid < i) {
        return query(root.rightChild, i, j);
      } else {
        return query(root.leftChild, i, mid) + query(root.rightChild, mid+1, j);
      }
    }
  }
}
