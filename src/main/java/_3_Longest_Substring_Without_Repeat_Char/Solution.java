package _3_Longest_Substring_Without_Repeat_Char;

public class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) return 0;
    if(s.length() == 1) return 1;
    int[] hash = new int[256]; //character hash
    for(int i=0 ;i<256; i++) hash[i] = -1;

    int left = 0, right = 0, max = 0;
    while(right < s.length()) {
      char rightCurr = s.charAt(right);
      if(hash[rightCurr] == -1) hash[rightCurr] = right;
      else {
        // System.out.println("left = " + left + " right =" + right);
        if(right -left > max) max = right - left;
        int repeatIndex = hash[rightCurr];
        if( repeatIndex+1 > left )
          left = repeatIndex + 1;
        hash[rightCurr] = right;
      }
      right ++;
    }

    return right - left > max ? right-left: max;

  }
}
