package _310_Min_Height_Tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;

public class Solution_Bad {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if(n<1) return null;
    else if(n == 1) {
      List<Integer> list = new ArrayList<Integer>();
      list.add(0); return list;
    }
    int[] nodeDegree = new int[n];
    Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
    for(int i=0; i<edges.length; i++) {
      edgeMap.putIfAbsent(edges[i][0], new HashSet<Integer>());
      edgeMap.putIfAbsent(edges[i][1], new HashSet<Integer>());

      edgeMap.get(edges[i][0]).add(edges[i][1]);
      edgeMap.get(edges[i][1]).add(edges[i][0]);

      nodeDegree[edges[i][0]] ++;
      nodeDegree[edges[i][1]] ++;
    }
    for(;;){
      Set<Integer> curr = new HashSet<>();
      for(int i=0; i<n; i++) {
        if(nodeDegree[i] == 1) curr.add(i);
      }
      List<Integer> retList = checkIfMet(curr, edgeMap, nodeDegree);
      if(retList != null && retList.size() >0) return retList;
    }
  }


  public List<Integer> checkIfMet(Set<Integer> curr, Map<Integer, Set<Integer>> edgeMap, int[] nodeDegree) {
    if(curr.size() < 2) return null;
    Set<Integer> nextNode = new HashSet<Integer> ();
    for(Integer i: curr) {
      Set<Integer> nextNodeSet = edgeMap.get(i);
      int next = (Integer) nextNodeSet.toArray()[0];
      // System.out.println(" i =" + i + "  next ="+next);
      nodeDegree[i] --;
      nodeDegree[next] --;
      nextNode.add(next);
    }

    if(nextNode.size() == 1) return new ArrayList<Integer>(nextNode);

    List<Integer> nextNodeList = new ArrayList<>(nextNode);
    boolean ret = true;
    Set<Integer> finalRet = new HashSet<>();
    for(int i=0; i<nextNodeList.size(); i++)
      for(int j=i+1; j<nextNodeList.size(); j++) {
        int left = nextNodeList.get(i), right = nextNodeList.get(j);
        if(edgeMap.get(left).contains(right) == true) {
          finalRet.add(left);finalRet.add(right);
        }
        else {
          ret = false;
          break;
        }
      }

    for(Integer i: curr) {
      Set<Integer> nextNodeSet = edgeMap.get(i);
      if(nextNodeSet!= null && nextNodeSet.size() >0) {
        int next = (Integer) nextNodeSet.toArray()[0];
        edgeMap.get(next).remove(i);
      }
      edgeMap.remove(i);
      System.out.println("i = " + i);
    }
    if(ret == true)
      return new ArrayList<Integer> (finalRet);
    else return null;
  }
}
