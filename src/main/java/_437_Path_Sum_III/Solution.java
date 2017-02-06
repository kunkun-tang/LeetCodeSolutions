package _437_Path_Sum_III;

import java.util.ArrayList;
import java.util.List;
import utils.TreeNode;

public class Solution {
  public int pathSum(TreeNode root, int sum) {
    int [] ret = new int[1];
    List<Integer> list = new ArrayList<Integer> ();
    pathSum(root, list, ret, sum);
    return ret[0];
  }

  public void pathSum(TreeNode root, List<Integer> list, int[] ret, int sum) {
    if (root == null) return;
    else {
      int currVal = root.val;
      if(sum == currVal) ret[0] ++;
      List<Integer> copyList = new ArrayList<>();
      for(Integer i: list) {
        copyList.add( new Integer(i + currVal));
        if(i + currVal == sum) ret[0] ++;
      }
      copyList.add(currVal);
      pathSum(root.left, copyList, ret, sum);
      pathSum(root.right, copyList, ret, sum);
    }
  }
}

