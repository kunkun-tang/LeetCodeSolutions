package _454_4Sum_II;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Solution {
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    Arrays.sort(A);
    Arrays.sort(B);
    Arrays.sort(C);
    Arrays.sort(D);

    Map<Integer, Integer> numCount = new HashMap<Integer, Integer> ();

    int ret = 0;
    for(int i: A)
      for (int j: B) {
        int target = 0 - i - j;
        if(!numCount.containsKey(target)) {
          numCount.put(target, twoSum(target, C, D));
        }
        ret += numCount.get(target);
      }
    return ret;
  }

  public int twoSum(int target, int [] C, int[] D) {
    int i = 0, j = D.length - 1, ret = 0;
    while (i < C.length && j >=0) {
      if (C[i] + D[j] == target) {
        int timesA = 1, timesB=1;
        while(i+1 < C.length && C[i] == C[i+1]) {
          i ++;
          timesA ++;
        }
        while(j-1 >=0 && D[j] == D[j-1]) {
          j --;
          timesB ++;
        }
        ret += timesA*timesB;
        i++; j--;
      }
      else if (C[i] + D[j] > target) j--;
      else i++;
    }
    return ret;
  }
}
