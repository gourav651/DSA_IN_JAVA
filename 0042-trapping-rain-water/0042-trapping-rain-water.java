class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n-1;
        int leftMax = height[l];
        int rightMax = height[r];
        int totalWater=0;

        while(l<r){
            if(leftMax<rightMax){
                l++;
                leftMax = Math.max(leftMax,height[l]);
                totalWater = totalWater + (leftMax-height[l]);
            }
            else{
                r--;
                rightMax = Math.max(rightMax,height[r]);
                totalWater = totalWater + (rightMax-height[r]);
            }
        }
        return totalWater;
    }
}