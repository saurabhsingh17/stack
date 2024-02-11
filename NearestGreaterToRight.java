import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterToRight {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        System.out.println(Arrays.toString(StackApproach.nextGreaterElement(a)));
        System.out.println(Arrays.toString(StackApproachOptimised.nextGreaterElement(a)));
    }
    static class StackApproach {
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
    static class StackApproachOptimised {
        static int[] nextGreaterElement(int[] nums) {
            int n = nums.length;
            Stack<Integer> stack = new Stack<>();

            for (int i = n-1; i >= 0; i--) {
                int num = nums[i];
                while (!stack.empty() && stack.peek() <= nums[i]) stack.pop();
                nums[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(num);
            }
            return nums;
        }
    }


}
