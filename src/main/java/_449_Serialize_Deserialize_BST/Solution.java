package _449_Serialize_Deserialize_BST;

import utils.TreeNode;

public class Solution{

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuffer bf = new StringBuffer();
    preOrder(root, bf);
    return bf.toString();
  }

  public void preOrder(TreeNode root, StringBuffer bf) {
    if (root == null) {
      bf.append("#,"); return;
    }
    bf.append(Integer.toString(root.val) + ",");
    preOrder(root.left, bf);
    preOrder(root.right, bf);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    int [] index = new int[1];
    TreeNode root = deserialize(data, index);
    return root;
  }

  public TreeNode deserialize(String data, int[] index) {
    if (data.charAt(index[0]) == '#'){
      index[0] +=2;
      return null;
    }
    int high = getValueLowDigits(data, index[0]);
    String val = data.substring(index[0], high);
    TreeNode curr = new TreeNode(Integer.parseInt(val));
    index[0] = high + 1;
    curr.left = deserialize(data, index);
    curr.right = deserialize(data, index);
    return curr;
  }

  public int getValueLowDigits(String data, int i) {
    int j=i;
    for(; j<data.length(); j++) {
      if(data.charAt(j) == ',') break;
    }
    return j;
  }
}
