package _322_Coin_Change;

import java.util.Arrays;

public class TLE_Solution {
  public int coinChange(int[] coins, int amount) {
    if(coins == null) return -1;
    if(amount == 0) return 0;
    Arrays.sort(coins);
    int[] dp = new int[amount+1];
    return coinChange(coins, amount, dp);
  }

  public int coinChange(int[] coins, int amount, int[] dp) {
    if(dp[amount] > 0) return dp[amount];
    for(int i = coins.length - 1; i>=0; i--) {
      int currCoin = coins[i];
      if(amount < currCoin) continue;
      if(amount == currCoin) return 1;
      else {
        int next = coinChange(coins, amount - currCoin, dp);
        if(next == -1) continue;
        if(dp[amount] == 0) dp[amount] = next + 1;
        else dp[amount] = Math.min(next + 1, dp[amount]);
      }
    }
    return dp[amount] > 0 ? dp[amount] : -1;
  }
}
