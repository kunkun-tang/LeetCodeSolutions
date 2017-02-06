package _438_Find_All_Anagrams;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    Set<String> set = new HashSet<>();
    List<Integer> list = new ArrayList<>();
    generateAllAnagrams(set, "", p);
    int pLen = p.length();
    for(int i=0; i<s.length()-pLen+1; i++)
      if(set.contains(s.substring(i, i+pLen)))
        list.add(i);
    return list;
  }

  public void generateAllAnagrams(Set<String> set, String curr, String remainP) {
    if(remainP == null || remainP.length() == 0) {
      set.add(curr);
      return;
    }
    for (int i=0; i<remainP.length(); i++) {
      char currChar = remainP.charAt(i);
      if (i>0 && currChar == remainP.charAt(i-1))
        continue;
      generateAllAnagrams(set, curr+currChar, remainP.substring(0, i) + remainP.substring(i+1, remainP.length()));
    }
  }
}

