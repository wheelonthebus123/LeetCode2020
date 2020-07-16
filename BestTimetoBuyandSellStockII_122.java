public class BestTimetoBuyandSellStockII_122 {
    public int maxProfit(int[] prices) {
        int r = 0;
        for(int i=1; i<prices.length; ++i)
        {
            if(prices[i]>prices[i-1])
                r += prices[i]-prices[i-1];
        }
        return r;
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}