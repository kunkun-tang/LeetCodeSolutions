package _451_Sort_Char_Freq;

import java.util.Arrays;


public class Solution {

  public class Pair {
    int index;
    int count;
    public Pair(int index, int count) {
      this.index = index;
      this.count = count;
    }
  }

  public String frequencySort(String s) {
    if(s == null) return null;
    int[] counts = new int[100];
    for(int i=0; i<s.length(); i++) {
      counts[s.charAt(i)-' '] ++;
    }
    Pair[] pairs = new Pair[100];
    for (int i=0; i<100; i++) {
      pairs[i] = new Pair(i, counts[i]);
    }
    Arrays.sort(pairs, (p1, p2) -> p2.count - p1.count);
    StringBuffer sb = new StringBuffer();
    for(int i=0; i<100; i++) {
      if(pairs[i].count > 0) {
        char curr = (char) (' ' + pairs[i].index);
        sb.append(repeatCharNtimes(curr, pairs[i].count));
      }
    }
    return sb.toString();
  }

  public String repeatCharNtimes(char curr, int n) {
    char[] repeat = new char[n];
    for(int i=0; i<n; i++) repeat[i] = curr;
    return new String(repeat);
  }
}
