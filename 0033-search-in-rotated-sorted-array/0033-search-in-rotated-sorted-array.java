class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //check the left part is sorted or not
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;  //eliminate the right part
                } else {
                    low = mid + 1;  //else eliminate the left part
                }
            }
            else {
            //check the right part is sorted or not
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1; //eliminate the left part
                } else {
                    high = mid - 1;  //eliminate the right part
                }
            }
        }
        return -1;
    }
}