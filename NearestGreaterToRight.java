import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterToRight {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        System.out.println(Arrays.toString(nextGreaterElement(a)));
    }

    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                if (stack.peek() > nums[i]) {
                    result[i] = stack.peek();
                } else {
                    while (!stack.isEmpty() && stack.peek() < nums[i]) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        result[i] = -1;
                    } else {
                        result[i] = nums[i];
                    }
                }
            }
            stack.push(nums[i]);
        }
        return result;
    }
}
