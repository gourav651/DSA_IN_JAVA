class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int n = nums.length;
        int high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }
            //check the left part is sorted or not
                if(nums[low] <= nums[mid]){
                    if(nums[low] <= target && target < nums[mid]){
                        high = mid-1;
                    }else{
                    low = mid+1;
                    }
                }
            //check the right part is sorted or not
            else 
            {
                if(nums[mid] < target && target <= nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}