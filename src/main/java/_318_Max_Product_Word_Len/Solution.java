package _318_Max_Product_Word_Len;

public class Solution {
  public int maxProduct(String[] words) {
    int[] num = new int[words.length];
    int curr = 0;
    for(String word: words) {
      char[] array = word.toCharArray();
      for(char ch: array) {
        num[curr] = num[curr] | (1<< (ch-'a'));
      }
      curr ++;
    }
    int ret = 0;
    for(int i=0; i<words.length-1; i++)
      for(int j=i+1; j< words.length; j++) {
        if( (num[i] & num[j]) == 0) {
          int currLen = words[i].length() * words[j].length();
          ret = ret > currLen ? ret : currLen;
        }
      }
    return ret;
  }
}