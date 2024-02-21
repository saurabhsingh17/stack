package adityaverma;

public class RainWaterTrapping {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxL = new int[n];
        int[] maxR = new int[n];
        maxL[0] = height[0];
        for (int i = 1; i < n ; i++) {
            if(height[i] > maxL[i-1]){
                maxL[i] = height[i];
            }
            else {
                maxL[i] = maxL[i-1];
            }
        }
        maxR[n-1] = height[n-1];
        for (int i = n-2; i >= 0 ; i--) {
            if(height[i] > maxR[i+1]){
                maxR[i] = height[i];
            }
            else {
                maxR[i] = maxR[i+1];
            }
        }
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += (Math.min(maxL[i],maxR[i]) - height[i]);
        }
        return sum;

    }
}
