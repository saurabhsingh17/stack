package adityaverma;

import java.util.Stack;

public class MaximumAreaHistogramBinary {
    public static void main(String[] args) {
        char[][] chars ={{1,0},{1,0},{1,0}};
        System.out.println(maximalRectangle(chars));
    }
    static int maximalRectangle(char[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        int[] vec = new int[m];
        int mx = 0;
        for (int i = 0; i < m; i++){
            vec[i] =  matrix[0][i] - '0';
        }
        mx = largestRectangleArea(vec);

        for (int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                if((matrix[i][j] -'0') == 0){
                    vec[j] = 0;
                }
                else
                    vec[j] += (matrix[i][j] - '0');
            }
            mx = Math.max(mx,largestRectangleArea(vec));
        }
        return mx;
    }
    static int largestRectangleArea(int[] heights) {
        int[] nsr = nextSmallerElement(heights);
        int[] nsl = nextSmallerElementToLeft(heights);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int sum = heights[i] * (nsr[i] - nsl[i] - 1);
            if (sum > max) {
                max = sum;
            }
        }
        return max;
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
