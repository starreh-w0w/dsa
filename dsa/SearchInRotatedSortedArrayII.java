// LC #81 | Search In Rotated Sorted Array II
// https://leetcode.com/problems/search-in-rotated-sorted-array-ii

/**
 * 
 * Because of repeating elements a specific edge case occurs where
 * nums[low] <= nums[mid] or nums[mid] <= nums[high] is inconclusive
 * 
 * As it becomes, nums[low] == nums[mid] == nums[high]
 * 
 * Then, we should address by situation by
 * incrementing the low & decrementing the high
 * 
 */

package dsa;

public class SearchInRotatedSortedArrayII {
    
    public boolean search(int[] nums, int k) {
        int n = nums.length;
        int low = 0, high = n -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == k) return true;

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low ++;
                high--;
            } else if (nums[low] <= nums[mid]) {
                if (nums[low] <= k && k <= nums[mid]) high = mid - 1;
                else low = mid + 1;
            } else {
                if (nums[mid] <= k && k <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return false;
    }
}
