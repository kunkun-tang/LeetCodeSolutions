package _365_Water_and_Jug;

import java.util.Queue;
import java.util.LinkedList;

public class Solution {
  public boolean canMeasureWater(int x, int y, int z) {
    boolean[] mark = new boolean[x + y + 1];
    boolean[] visited = new boolean[x + y + 1];
    mark[0] = true;
    mark[x] = true;
    mark[y] = true;
    mark[x+y] = true;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(Math.abs(x-y));
    while(queue.peek() != null) {
      int diff = queue.poll();
      if(visited[diff] == true) continue;
      visited[diff] = true;
      if(x+diff < mark.length)
        mark[x+diff] = true;
      if(y+diff < mark.length)
        mark[y+diff] = true;
      if(x-diff >= 0)
        mark[x-diff] = true;
      if(y-diff >= 0)
        mark[y-diff] = true;
      queue.add(Math.abs(diff-x));
      queue.add(Math.abs(diff-y));
    }
    return z<mark.length && mark[z] == true;
  }
}

