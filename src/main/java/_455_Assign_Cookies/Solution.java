package _455_Assign_Cookies;

import java.util.Arrays;

public class Solution {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int ret = 0;
    for(int i=0, j=0; i<g.length && j<s.length; ){
      if(s[j]>=g[i]) {
        ret++; i++; j++;
      } else j++;
    }
    return ret;
  }
}
