public class CoinChange2_518 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount + 1];
        dp[0][0] = 1;

        for(int i=1; i<=coins.length; ++i){
            dp[i][0] = 1;
            for(int j=1; j<=amount; ++j){
                dp[i][j] = dp[i-1][j] //do no use coins[i-1]
                    + (j>=coins[i-1] ? dp[i][j-coins[i-1]] : 0); //use at least one coins[i-1]
            }
        }

        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}