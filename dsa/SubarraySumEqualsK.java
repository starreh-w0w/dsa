package dsa;

public class SubarraySumEqualsK {

    public int subarraySumEqualsK(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int sum = nums[0];
        int len = 0;

        while (right < n) {

            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                len = Math.max(len, right - left + 1);
            }

            right++;

            if (right < n) sum += nums[right];
        }
        
        return len;
    }
}