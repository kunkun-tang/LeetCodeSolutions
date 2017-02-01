package _447_Num_of_Boomerangs;

import java.util.Map;
import java.util.HashMap;


public class Solution {
  public int numberOfBoomerangs(int[][] points) {
    //  pt_ID,   <distance, list<Neighbors>>
    Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();

    for(int i=0; i<points.length; i++) {
      map.put(i, new HashMap<Integer, Integer>());
    }

    for(int i=0; i<points.length; i++)
      for(int j=i+1; j<points.length; j++) {
        int dist = getDistanceSquare(points[i], points[j]);
        map.get(i).putIfAbsent(dist, 0);
        map.get(j).putIfAbsent(dist, 0);
        int i_num = map.get(i).get(dist);
        int j_num = map.get(j).get(dist);
        map.get(i).put(dist, i_num+1);
        map.get(j).put(dist, j_num+1);
      }

    int ret = 0;
    for (Map.Entry<Integer, Map<Integer, Integer>> entry : map.entrySet()) {
      Map<Integer, Integer> innerMap = entry.getValue();
      for (Map.Entry<Integer, Integer> innerEntry : innerMap.entrySet()) {
        ret += permutation2(innerEntry.getValue());
      }
    }
    return ret;
  }

  public int permutation2(int n) {
    return n * (n-1);
  }

  public int getDistanceSquare(int[] pt1, int[] pt2) {
    int res = (pt1[0] - pt2[0]) * (pt1[0] - pt2[0]) + (pt1[1] - pt2[1]) * (pt1[1] - pt2[1]);
    return res;
  }
}
