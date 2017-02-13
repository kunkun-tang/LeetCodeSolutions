package _421_Max_Xor_Two_Nums_In_Array;

// https://discuss.leetcode.com/topic/63207/java-o-n-solution-using-trie
// includes the detailed explanation.
public class Solution {

  class Trie {
    Trie[] children;
    public Trie() {
      children = new Trie[2];
    }
  }

  public int findMaximumXOR(int[] nums) {

    Trie root = new Trie();
    for(int num: nums) {
      Trie currNode = root;
      for(int i=31; i>=0; i--) {
        int currBit = (num >> i) & 1;
        if(currNode.children[currBit] == null)
          currNode.children[currBit] = new Trie();
        currNode = currNode.children[currBit];
      }
    }

    int max = 0;

    for(int num: nums) {
      Trie currNode = root;
      int currMax = 0;
      for(int i=31; i>=0; i--) {
        int currBit = (num >> i) & 1;
        int need = currBit ^ 1;
        if(currNode.children[need] != null) {
          currMax += 1 << i;
          currNode = currNode.children[need];
        } else if (currNode.children[currBit] != null) {
          currNode = currNode.children[currBit];
        }
      }
      if(currMax > max) max = currMax;
    }
    return max;
  }
}