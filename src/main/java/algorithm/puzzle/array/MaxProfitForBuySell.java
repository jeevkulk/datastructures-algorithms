package algorithm.puzzle.array;

public class MaxProfitForBuySell {
    public static void main(String[] args) {
        MaxProfitForBuySell maxProfitForBuySell = new MaxProfitForBuySell();

        int[] arr = new int[]{14, 12, 70, 15, 99, 65, 21, 90};
        System.out.println(maxProfitForBuySell.getMaxProfit(arr));
    }

    private int getMaxProfit(int[] arr) {
        int maxProfit = Integer.MIN_VALUE;
        int lowestPriceTillThatDay = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int profit = 0;
            if (arr[i] > lowestPriceTillThatDay) {
                profit = arr[i] - lowestPriceTillThatDay;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            } else {
                lowestPriceTillThatDay = arr[i];
            }
        }
        return maxProfit;
    }

}
