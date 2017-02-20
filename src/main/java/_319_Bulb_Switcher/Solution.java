package _319_Bulb_Switcher;

public class Solution {
  public int bulbSwitch(int n) {
    if (n <= 0) return 0;
    return (int)Math.sqrt(n);
  }
}