package Algorithm.lc7;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class alg_121_BestTimeToBuyAndSellStock {
    //Runtime: 167 ms, faster than 12.15% of Java online submissions for Best Time to Buy and Sell Stock.
    //Memory Usage: 37.3 MB, less than 71.50% of Java online submissions for Best Time to Buy and Sell Stock.
    public static int maxProfit(int[] prices){
        int size = prices.length - 1;
        int answer = 0;
        for(int i = 0; i < size; i++){
            for(int j =  i + 1; j < size + 1; j++){
                answer = Math.max(answer, prices[j] - prices[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] testCase = {7,1,5,3,6,4};
        int[] testCase2 = {1,2};
        System.out.println(maxProfit(testCase2));
    }
}
