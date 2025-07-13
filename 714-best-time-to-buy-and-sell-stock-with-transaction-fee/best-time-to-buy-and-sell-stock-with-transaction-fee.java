class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int buy = -prices[0];
        int sell = 0;

        for (int i = 1; i < prices.length; i++) {
            int prevBuy = buy;
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, prevBuy + prices[i] - fee);
        }
        return sell;
    }
}