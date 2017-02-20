package _313_super_ugly_num_;

import java.util.ArrayList;
import java.util.List;

/**
 * The idea comes from {@link _264_Ugly_Num_II.Solution}
 */
public class Solution {
  public int nthSuperUglyNumber(int n, int[] primes) {
    int[] primeDP = new int[primes.length];
    List<Integer> list = new ArrayList<>();
    list.add(1);
    int curr = 1;
    while(curr++ < n) {
      int min = Integer.MAX_VALUE;
      for(int i=0; i<primeDP.length; i++) {
        min = Math.min(min, list.get(primeDP[i]) * primes[i]);
      }
      for(int i=0; i<primeDP.length; i++) {
        if( min == list.get(primeDP[i]) * primes[i]) primeDP[i] ++;
      }
      list.add(min);
    }
    return list.get(list.size() - 1);
  }
}