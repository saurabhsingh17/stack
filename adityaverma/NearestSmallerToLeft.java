package adityaverma;

import java.util.Arrays;
import java.util.Stack;

import static adityaverma.NearestSmallerToRight.nextSmallerElement;

public class NearestSmallerToLeft {

    public static void main(String[] args) {
        int[] num = {2,1,5,6,2,3};
        System.out.println(Arrays.toString(nextSmallerElementToLeft(num)));
    }
    static int[] nextSmallerElementToLeft(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!stack.empty() && stack.peek() >= nums[i]) stack.pop();
            nums[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num);
        }
        return nums;
    }

}
