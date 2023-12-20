//You are given an integer array prices representing the prices of various chocolates in a store.
// You are also given a single integer money, which represents your initial amount of money.
//You must buy exactly two chocolates in such a way that you still have some non-negative leftover money.
//You would like to minimize the sum of the prices of the two chocolates you buy.
//Return the amount of money you will have leftover after buying the two chocolates.
// If there is no way for you to buy two chocolates without ending up in debt, return money.
// Note that the leftover must be non-negative.
//Leetcode
import java.util.Arrays;
public class BuyTwoChocolates {

    public static void main(String args[])
    {
        int[] prices = {98,54,6,34,66,63,52,39};
        int  money = 62;

        int res = buyChoco(prices,money);
        int res2 = minimize_money_left(prices,money);
        System.out.println(res);
        System.out.println(res2);
    }
    public static int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);

        int res=money;
        if(prices[0]+prices[1]<=money){
            return money - (prices[0]+prices[1]);
        }
        return money;
    }

     public static int  minimize_money_left(int[] prices, int money)
    {
        Arrays.sort(prices);
        int i=0;
        int j= prices.length-1;
        while(prices[j]>=money){
            j--;
        }
        int bestmoney = money;
        while(i!=j){
            int tempmoney = bestmoney;
            if(prices[i]+prices[j] <=money)
            {
                tempmoney = money-(prices[i]+prices[j]);
            }

            if(bestmoney > tempmoney)
                bestmoney = tempmoney;
            j--;
        }
        return bestmoney;
    }
}
