class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low=0,high=n-1;
        int ans = n;  //Default to the end if target>all elements
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>=target){  // Potential answer found, try to go left
                ans = mid;
                high = mid-1;
            }else{
                low=mid+1;  //Go right
            }
        }
        return ans;
    }
}