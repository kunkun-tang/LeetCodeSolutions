package _454_4Sum_II;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Solution2 {
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

    Map<Integer, Integer> counts = new HashMap<>();
    for (int i: A)
      for (int j: B) {
        int sum = i + j;
        counts.put(sum, counts.getOrDefault(sum, 0) + 1);
      }

    int ret = 0;
    for (int i: C)
      for (int j: D) {
        int target = 0- i - j;
        ret += counts.getOrDefault(target, 0);
      }
    return ret;
  }
}
