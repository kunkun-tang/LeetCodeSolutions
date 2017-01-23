package _450_Delete_Node_in_BST;

import utils.TreeNode;

public class Solution {
  public TreeNode deleteNode(TreeNode root, int key) {
    TreeNode node = find(root, key);
    if(node == null) return root;

    TreeNode parent = findParent(root, node);
    TreeNode target = getTargetNode(node, parent);
    if(node.left == null && node.right == null)
      target = null;
    else if (node.left == null) target = node.right;
    else if (node.right == null) target = node.left;
    else {
      TreeNode leftNode = node.left;
      TreeNode iterNode = node.right;
      while(iterNode.left!= null) {
        iterNode = iterNode.left;
      }
      iterNode.left = leftNode;
      target = node.right;
    }
    return root;
  }

  public TreeNode getTargetNode(TreeNode node, TreeNode parent) {
    if(parent == null) return node;
    else if (parent.val > node.val) return parent.left;
    else return parent.right;
  }

  public TreeNode find(TreeNode root, int key) {
    if(root == null) return null;

    if(root.val == key) return root;
    else if (root.val > key) return find(root.left, key);
    else return find(root.right, key);
  }


  public TreeNode findParent(TreeNode root, TreeNode node) {
    if(root == node) return null;
    int div = root.val - node.val;
    if(div > 0){
      if(root.left == node) return root;
      return findParent(root.left, node);
    } else {
      if(root.right == node) return root;
      return findParent(root.right, node);
    }
  }
}

