class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If mid element is the target
            if (nums[mid] == target)
                return true;

            // Handle duplicates: cannot determine sorted side
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // Search left (eliminated right part)
                } else {
                    low = mid + 1; // Search right (eliminated left part)
                }
            }

            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}