package _264_Ugly_Num_II;

import java.util.List;
import java.util.ArrayList;

public class Solution {
  public int nthUglyNumber(int n) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    int t2=0, t3=0, t5=0;
    int curr = 1;
    while(curr++<n) {
      int min = Math.min(list.get(t2)*2, Math.min(list.get(t3)*3, list.get(t5)*5));
      if(min == list.get(t2) * 2) t2 ++;
      if (min == list.get(t3) * 3) t3 ++;
      if (min == list.get(t5) * 5) t5 ++;
      list.add(min);
    }
    return list.get(list.size() - 1);
  }
}