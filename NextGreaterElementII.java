import java.util.Arrays;

public class NextGreaterElementII {
    static class BruteForce {

        public static int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                int firstPointer = 0;
                int secondPointer = i + 1;
                int curr = nums[i];
                while (secondPointer != n && nums[secondPointer] <= curr) {
                    secondPointer++;
                }
                if (secondPointer == n) {
                    while (firstPointer != i && nums[firstPointer] <= curr) {
                        firstPointer++;
                    }
                    if (nums[firstPointer] > curr) {
                        result[i] = nums[firstPointer];
                    } else {
                        result[i] = -1;
                    }
                } else {
                    result[i] = nums[secondPointer];
                }
            }
            return result;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3};
        System.out.println(Arrays.toString(BruteForce.nextGreaterElements(arr)));
    }
}
