class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left=0;
        int right=n-1;
        int width=0;
        int maxArea=0;
        while(left<right){
            width = right-left;
            int minHeight = Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea,width * minHeight);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}