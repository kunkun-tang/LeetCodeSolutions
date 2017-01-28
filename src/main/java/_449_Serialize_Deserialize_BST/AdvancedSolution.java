package _449_Serialize_Deserialize_BST;

import utils.TreeNode;


/**
 * The Advanced Solution will make string serialized more compact, as BST
 * is able to distinguish null node easily. This solution leverages lower bound and upper bound
 * to detect if the next value is a subtree or in other branches.
 */
public class AdvancedSolution {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuffer bf = new StringBuffer();
    preOrder(root, bf);
    return bf.toString();
  }

  public void preOrder(TreeNode root, StringBuffer bf) {
    if (root == null) {
      return;
    }
    bf.append(Integer.toString(root.val) + ",");
    preOrder(root.left, bf);
    preOrder(root.right, bf);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    int [] index = new int[1];
    TreeNode root = deserialize(data, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    return root;
  }

  public TreeNode deserialize(String data, int[] curr, int minBound, int maxBound) {
    if(curr[0] >= data.length()) {
      return null;
    }
    int high = getValueLowDigits(data, curr[0]);
    String val = data.substring(curr[0], high);
    int intVal = Integer.parseInt(val);
    if(intVal > minBound && intVal < maxBound){
      TreeNode node = new TreeNode(intVal);
      curr[0] = high + 1;
      node.left = deserialize(data, curr, minBound, intVal);
      node.right = deserialize(data, curr, intVal, maxBound);
      return node;
    } else return null;
  }

  public int getValueLowDigits(String data, int i) {
    int j=i;
    for(; j<data.length(); j++) {
      if(data.charAt(j) == ',') break;
    }
    return j;
  }

}
