package _367_Valid_Perfect_Square;

public class Solution {
  public boolean isPerfectSquare(int num) {
    long numCopy = (long) num;
    if(num == 1) return true;
    if(num== 2 || num == 3) return false;
    long start = 1, end = num/2;
    while(start <= end) {
      long mid = start + (end-start)/2;
      if(mid * mid == numCopy) return true;
      if(mid * mid < 0 || mid * mid > numCopy) {
        end = mid-1;
      } else {
        start = mid + 1;
      }
    }
    return false;
  }
}

