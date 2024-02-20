package adityaverma;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] price = {100, 80, 60, 70, 60, 75, 85};

        System.out.println(Arrays.toString(calculateSpan(price, price.length)));
    }
    public static int[] calculateSpan(int price[], int n) {
        price = nextGreaterElementToLeft(price);
        for (int i = 0; i < n; i++) {
            price[i] = i - price[i];
        }
        return price;
    }

    static int[] nextGreaterElementToLeft(int[] nums) {
        int n = nums.length;
        Stack<Map.Entry<Integer, Integer>> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!stack.empty() && stack.peek().getKey() <= nums[i]) stack.pop();
            nums[i] = stack.isEmpty() ? -1 : stack.peek().getValue();
            stack.push(Map.entry(num, i));
        }
        return nums;
    }
}
