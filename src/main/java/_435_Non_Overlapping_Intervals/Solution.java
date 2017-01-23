package _435_Non_Overlapping_Intervals;

import java.util.Arrays;
import java.util.Comparator;

class Interval {
  int start;
  int end;
  Interval() { start = 0; end = 0; }
  Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
  public int eraseOverlapIntervals(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>(){
      public int  compare(Interval o1, Interval o2) {
        return o1.end-o2.end;
      }
    });

    int max = 0;
    for(int i=0; i<intervals.length;) {
      int j = i+1;
      for(;j<intervals.length;j++) {
        if(isIntercept(intervals[i], intervals[j])) continue;
        else break;
      }
      i = j;
      max ++;
    }

    return intervals.length-max;
  }

  public boolean isIntercept(Interval i1, Interval i2) {
    return i1.end-i2.start >0;
  }
}
