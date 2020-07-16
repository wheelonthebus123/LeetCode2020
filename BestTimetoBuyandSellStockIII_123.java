public class BestTimetoBuyandSellStockIII_123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] forward = new int[n];
        int[] backward = new int[n];
        
        int buyP = prices[0];
        for(int i=1; i<n; ++i)
        {
            forward[i] = Math.max(forward[i], prices[i]-buyP);
            buyP = Math.min(buyP, prices[i]);
        }

        int sellP = prices[n-1];
        for(int i=n-2; i>=0; --i)
        {
            backward[i] = Math.max(backward[i], sellP-prices[i]);
            sellP = Math.max(sellP, prices[i]);
        }

        int ret = 0;
        for(int i=0; i<n-1; ++i)
        {
            ret = Math.max(ret, forward[i]+backward[i+1]);
        }

        return Math.max(ret, Math.max(forward[n-1], backward[0]));
    }
    public static void main(String[] args) {
        System.out.println("Hi");
    }
}