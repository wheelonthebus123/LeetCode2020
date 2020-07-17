public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            dp[i] = -1;
            for (int c : coins) {
                if (i >= c && dp[i - c] >= 0) {
                    if (dp[i] == -1)
                        dp[i] = dp[i - c] + 1;
                    else
                        dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
       //     System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println("Hi");
        CoinChange_322 sol = new CoinChange_322();
        sol.coinChange(new int[] {1,2,5}, 11);
    }
}