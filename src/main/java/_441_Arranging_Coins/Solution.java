package _441_Arranging_Coins;


public class Solution {
  public int arrangeCoins(int n) {
    long n_long = (long) n;
    long base = (long)Math.sqrt((double)n);
    for(long i= base; true; i++) {
      if(getResults(i+1) > n_long || getResults(i+1) < getResults(i)) return (int)i;
    }
  }

  public long getResults(long n) {
    return n * (n+1) / 2;
  }
}
