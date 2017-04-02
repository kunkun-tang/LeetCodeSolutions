package _357_Count_Num_with_Unique_Digits;

public class Solution {
  public int countNumbersWithUniqueDigits(int n) {
    if(n == 0) return 1;
    else if(n == 1) return 10;
    else if (n == 2) return 91;

    int ret = 91;
    for(int i=3; i<=n; i++) {
      ret += func(i);
    }
    return ret;
  }

  public int func(int num) {
    int ret = 9;
    for(int i=0; i<num-1; i++)
      ret *= (9-i);
    return ret;
  }
}

