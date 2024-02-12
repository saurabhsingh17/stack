import java.util.*;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] arr = {89,62,70,58,47,47,46,76,100,70};
        int[] result = nextGreaterElement(arr);
        for (int i = 0; i<arr.length;i++){
            if(result[i] != -1){
                result[i] = result[i] - i;
            }
            else result[i] = 0;

        }
        System.out.println(Arrays.toString(result));
    }
    static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Map.Entry<Integer,Integer>> stack = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            int no = nums[i];
            while(!stack.isEmpty() && stack.peek().getKey() <= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1: stack.peek().getValue();
            Map.Entry<Integer,Integer> entry = new HashMap.SimpleEntry<>(nums[i],i);
            stack.push(entry);
        }
        return result;
    }
}
