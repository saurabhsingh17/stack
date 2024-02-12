import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementToLeft {
    public static void main(String[] args) {
        int[] nums = {1,3,2,4};
        System.out.println(Arrays.toString(nextGreaterElementToLeft(nums)));
    }

    static int[] nextGreaterElementToLeft(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!stack.empty() && stack.peek() <= nums[i]) stack.pop();
            nums[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num);
        }
        return nums;
    }
}
