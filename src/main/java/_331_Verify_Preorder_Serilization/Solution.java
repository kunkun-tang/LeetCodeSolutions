package _331_Verify_Preorder_Serilization;

import java.util.Stack;

public class Solution {
  public boolean isValidSerialization(String preorder) {
    if(preorder == null) return false;
    String[] strArr = preorder.split(",");
    Stack<String> st = new Stack<> ();
    for(int i=0; i< strArr.length; i++) {
      String curr = strArr[i];
      while(curr.equals("#") && st.size() > 0 && st.peek().equals("#")) {
        st.pop();
        if(st.isEmpty()) return false;
        st.pop();
      }
      st.push(curr);
    }
    return st.size() == 1 && st.peek().equals("#");
  }
}
