package _2_Add_Two_Numbers;

import utils.ListNode;

public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    boolean offset = false, exit = false;
    ListNode head = new ListNode(-1), dummyHead = head;
    ListNode revL1 = l1, revL2=l2;
    while(!exit) {
      int curr = offset==false? 0 : 1;
      if(revL1 != null && revL2 != null){
        curr += revL1.val + revL2.val;
        revL1 = revL1.next;
        revL2 = revL2.next;
      } else if (revL1 != null) {
        curr += revL1.val;
        revL1 = revL1.next;
      } else if (revL2 != null){
        curr += revL2.val;
        revL2 = revL2.next;
      } else {
        exit=true;
      }
      if(curr >= 10){
        offset = true;
        curr -= 10;
      } else offset = false;
      if( !(curr == 0 && exit==true )) {
        ListNode currNode = new ListNode(curr);
        head.next = currNode;
        head = currNode;
      }
    }
    return dummyHead.next;
  }
}
