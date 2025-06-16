// LC #153 | Find Minimum In Rotated Sorted Array
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

package dsa;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] arr) {
        int ans = Integer.MAX_VALUE;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + ( high - low) / 2;

            if (arr[low] <= arr[mid] && arr[mid] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }
            
            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                high = mid -1;
            }
        }
        return ans;
    }
}
