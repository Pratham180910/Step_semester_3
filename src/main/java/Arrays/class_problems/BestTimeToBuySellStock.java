package main.java.class_problems;

public class BestTimeToBuySellStock {
    static int maxProfit(int[] prices) {
        int min=prices[0];
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            int profit=prices[i]-min;
            if(profit>maxProfit)
                maxProfit=profit;
            if(prices[i]<min)
                min=prices[i];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}