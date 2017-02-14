package _306_Additive_Number;

public class Solution_Bad {
  public boolean isAdditiveNumber(String num) {
    if(num == null || num.length() < 3) return false;
    char[] array = num.toCharArray();
    int len = array.length;
    for(int i=1, j=1; i< len-1 && j < len;) {
      if(i == j) {
        j++; i=1;
      }
      String left = num.substring(0,i);
      String mid = num.substring(i,j);
      String rightStart = num.substring(j,j+1);
      if(  (left.length()>1 && left.charAt(0) == '0')
          || (mid.length()>1 && mid.charAt(0) == '0') ) {
        i++; continue;
      }
      long leftNum = Long.parseLong(left);
      long midNum = Long.parseLong(mid);
      long target = leftNum + midNum;
      int numDig = target==0? 1: numDigist(target);
      // System.out.println("numDig = " + numDig);
      if(numDig > 1 && rightStart.charAt(0) == '0') {
        i++; continue;
      }
      if(j + numDig <= len) {
        String currStr = num.substring(j, j+numDig);
        String targetString = Long.toString(target);
        // System.out.println("leftNum = " + leftNum);
        // System.out.println("midNum = " + midNum);

        // System.out.println("targetString = " + targetString);
        // System.out.println("currStr = " + currStr);
        if(currStr.equals(targetString)) {
          boolean ret = isAdditiveNumber(num, i, j, j + numDig);
          if(ret == true) return true;
        }
      }
      i++;
    }
    return false;
  }

  public boolean isAdditiveNumber(String num, int i, int j, int k) {
    if(k == num.length()) return true;
    int len = num.length();
    String left = num.substring(i, j);
    String mid = num.substring(j, k);
    String rightStart = num.substring(k,k+1);
    long leftNum = Long.parseLong(left);
    long midNum = Long.parseLong(mid);
    long target = leftNum + midNum;
    int numDig = target==0? 1: numDigist(target);
    if(numDig>1 && rightStart.charAt(0) == '0') return false;
    if(k + numDig <= len) {
      String currStr = num.substring(k, k+numDig);
      String targetString = Long.toString(target);
      if(currStr.equals(targetString)) {
        return isAdditiveNumber(num, j, k, k + numDig);
      }
    }
    return false;
  }

  public int numDigist(long num) {
    if(num == 0) return 0;
    return 1+ numDigist(num/10);
  }
}
