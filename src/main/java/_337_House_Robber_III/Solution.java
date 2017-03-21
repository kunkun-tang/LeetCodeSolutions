package _337_House_Robber_III;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * follow https://discuss.leetcode.com/topic/39834/step-by-step-tackling-of-the-problem
 */
public class Solution {
  Map<TreeNode, Integer> map = new HashMap<>();
  public int rob(TreeNode root) {
    if(root == null) return 0;
    if(map.containsKey(root)) return map.get(root);
    int val = 0;
    if(root.left != null) {
      val += rob(root.left.left) + rob(root.left.right);
    }

    if(root.right != null) {
      val += rob(root.right.left) + rob(root.right.right);
    }

    int ret = Math.max(val + root.val, rob(root.left) + rob(root.right));
    map.put(root, ret);
    return ret;
  }
}
