package adityaverma;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerToRight {
    public static void main(String[] args) {
//        int[] num = {2,1,5,6,2,3};
        int[] num = {1,1};
        int[] nsr = nextSmallerElement(num);
        int[] nsl = nextSmallerElementToLeft(num);
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            int sum = num[i] * (nsr[i] - nsl[i] - 1);
            if (sum > max) {
                max = sum;
            }
        }
        System.out.println(max);
    }

    static int[] nextSmallerElement(int[] nums) {
        int[] nsr = new int[nums.length];
        int n = nums.length;
        Stack<int[]> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            while (!stack.empty() && stack.peek()[0] >= nums[i]) stack.pop();
            nsr[i] = stack.isEmpty() ? n : stack.peek()[1];
            stack.push(new int[]{num, i});
        }
        return nsr;
    }

    static int[] nextSmallerElementToLeft(int[] nums) {
        int[] nsl = new int[nums.length];
        int n = nums.length;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!stack.empty() && stack.peek()[0] >= nums[i]) stack.pop();
            nsl[i] = stack.isEmpty() ? -1 : stack.peek()[1];
            stack.push(new int[]{num, i});
        }
        return nsl;
    }
}
