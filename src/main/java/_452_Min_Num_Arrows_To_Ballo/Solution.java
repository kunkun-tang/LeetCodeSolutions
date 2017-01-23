package _452_Min_Num_Arrows_To_Ballo;

import java.util.Arrays;

/**
 * Just a variant of 435. Quite Easy.
 */
public class Solution {
  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, (a, b) -> a[1]-b[1]);

    int min = 0;
    for(int i=0; i<points.length;) {
      int j=i+1;
      for(;j<points.length;j++) {
        if(isHorizontalIntersect(points, i, j)) continue;
        else break;
      }
      i = j;
      min ++;
    }
    return min;
  }

  boolean isHorizontalIntersect(int[][] points, int left, int right) {
    return points[left][1] - points[right][0] >= 0;
  }
}
