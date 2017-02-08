package _424_Longest_Repeat_Character_Replacement;

// http://blog.csdn.net/junchen1992/article/details/52964091
// includes the detailed explanation.
public class Solution {
  public int characterReplacement(String s, int k) {
    if(s == null || s.length() == 0) return 0;
    else if (s.length() == 1 ) return 1;
    int[] map = new int[26];
    int left =0, right = 0, max = 0;
    char[] chArr = s.toCharArray();
    map[chArr[0] - 'A'] ++;
    while (right < chArr.length) {
      int currMax = findMax(map);
      // System.out.println("left = " + left + "  right =" + right + " currMax=" + currMax);
      if (right - left + 1 - currMax <= k) {
        if(right - left + 1 > max) max = right - left + 1;
        right ++;
        if(right < chArr.length)
          map[chArr[right] - 'A'] ++;
      } else {
        map[chArr[left] - 'A'] --;
        left ++;
      }
    }
    return max;
  }

  public int findMax(int[] a) {
    int max = 0;
    for(int curr: a) {
      if(curr > max) max = curr;
    }
    return max;
  }
}
