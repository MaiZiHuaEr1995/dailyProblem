package leetcode;

import java.util.Stack;

public class FinalPrices {
    public static void main(String[] args) {

    }

//    给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
//
//    商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
//
//    请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
    public int[] finalPrices(int[] prices) {
        for(int i = 0; i < prices.length; i++){
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] <= prices[i]){
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    public int[] finalPrices2(int[] prices) {
        int length = prices.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[length];
        for(int i = length - 1; i >= 0; i--){
            // 获取原始价格
            int price = prices[i];
            while(!stack.isEmpty() && stack.peek() <= price){
                // 如果栈不为空，栈顶元素小于当前的价格，弹出栈顶元素
                res[i] = stack.pop();
            }
            if (stack.isEmpty()){
                // 如果i位置的价格，在右侧有小于price[i]的最靠近它的就是stack的栈顶元素
                res[i] = price - stack.peek();
            } else {
                res[i] = price;
            }
            stack.push(i);
        }
        return res;
    }
}
