class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int arr[] = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        //1. FIRST STEP : PUSH ALL THE ELEMENTS OF BOTH ARRAYS INTO THE NEW ARRAY arr[] IN SORTED ORDER

        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                i++;
                k++;
            } else {
                arr[k] = nums2[j];
                j++;
                k++;
            }
        }
        while (i < n1) {
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = nums2[j];
            j++;
            k++;
        }

        int n = arr.length;

        //2.SECOND STEP : CHECK THE SIZE OF NEW ARRAY, IF EVEN OR ODD THEN BELOW CODE

        if (n % 2 == 1) { // IF ODD LENGTH(because remainder 1)
            return arr[n / 2];
        }

        return (arr[n / 2] + arr[n / 2 - 1]) / 2.0; // IF EVEN LENGTH(becasue in even legnth wo numbers are att middle, so take the avg of both)
    }
}