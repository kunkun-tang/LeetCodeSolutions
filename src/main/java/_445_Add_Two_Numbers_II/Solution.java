package _445_Add_Two_Numbers_II;

import utils.ListNode;

public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode revL1 = reverseListNode(l1);
    ListNode revL2 = reverseListNode(l2);

    boolean offset = false, exit = false;
    ListNode tail = null;
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
        currNode.next = tail;
        tail = currNode;
      }
    }
    return tail;
  }


  public ListNode reverseListNode(ListNode node) {

    ListNode next = node.next;
    node.next = null;
    while(next !=null) {
      ListNode nextNext = next.next;
      next.next=node;
      node = next;
      next = nextNext;
    }
    return node;
  }
}

