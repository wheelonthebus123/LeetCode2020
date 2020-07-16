public class BestTimetoBuyandSellStock_121 {
    public int maxProfit(int[] prices) {
        int maxP = 0, buy = Integer.MAX_VALUE;
        for(int p : prices)
        {
            maxP = Math.max(maxP, p-buy);
            buy = Math.min(buy, p);
        }
        return maxP;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}