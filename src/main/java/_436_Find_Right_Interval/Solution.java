package _436_Find_Right_Interval;

import utils.Interval;
import java.util.Comparator;
import java.util.Arrays;

public class Solution {
  public int[] findRightInterval(Interval[] intervals) {

    Pair[] pairs = new Pair[intervals.length];
    int[] ret = new int[intervals.length];
    for(int i=0; i<intervals.length; i++) {
      pairs[i] = new Pair(i, intervals[i]);
    }

    Arrays.sort(pairs, new Comparator<Pair>(){
      public int compare(Pair o1, Pair o2) {
        return o1.interval.start - o2.interval.start;
      }
    });

    for(int i=0; i<pairs.length; i++) {
      int target = pairs[i].interval.end;
      int retVal = binarySearch(target, pairs, i+1, pairs.length-1);
      pairs[i].res = retVal;
    }

    Arrays.sort(pairs, new Comparator<Pair>(){
      public int compare(Pair o1, Pair o2) {
        return o1.index - o2.index;
      }
    });

    for(int i=0; i<pairs.length; i++) {
      ret[i] = pairs[i].res;
    }

    return ret;
  }

  public int binarySearch(int target, Pair[] pairs, int st, int finish) {
    if(st > finish) return -1;
    int mid = st + (finish - st)/2;
    int curr = pairs[mid].interval.start;
    if (curr < target) return binarySearch(target, pairs, mid+1, finish);
    else {
      if(st == finish || curr == target) return pairs[mid].index;
      else {
        int recursiveVal = binarySearch(target, pairs, st, mid-1);
        if(recursiveVal == -1) return mid;
        else return recursiveVal;
      }
    }
  }

  public class Pair{
    int index;
    Interval interval;
    int res;
    public Pair(int index, Interval interval) {
      this.index = index;
      this.interval = interval;
    }
  }
}

