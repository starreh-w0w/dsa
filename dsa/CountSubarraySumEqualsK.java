// LC #560 | Sub-Array Sum Equals K
// https://leetcode.com/problems/subarray-sum-equals-k/

package dsa;

public class CountSubarraySumEqualsK {

    public int countSubarrayEqualsK (int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int sum = nums[0];
        int count = 0;

        while (right < n) {

            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                count++;
            }

            right++;

            if (right < n) sum += nums[right];
        }
        
        return count;
    }
    
}
