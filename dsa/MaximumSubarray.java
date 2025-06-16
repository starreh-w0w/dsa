// LC #53 | Maximum Subarray
// https://leetcode.com/problems/maximum-subarray/

/**
 * Kadane's Algorithm
 */

package dsa;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum > maxSum) maxSum = sum;
            if (sum < 0) sum = 0;
        }
        
        return maxSum;
    }
}
