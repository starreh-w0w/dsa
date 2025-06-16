// LC #31 | Next Permutation
// https://leetcode.com/problems/next-permutation/

package dsa;

public class NextPermutaion {
    public void nextPermutation(int[] nums) {

        int n = nums.length;
        int idx = -1;

        // find the peak, till which the prefix prevails

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i+1]) {
                idx = i;
                break;
            }
        }

        // no peak exists, reverse the array

        if (idx == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // find the min of the next elements > nums[idx]

        int min = Integer.MAX_VALUE;
        int minIdx = -1;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > nums[idx]) {
                if (nums[i] < min) {
                    min = nums[i];
                    minIdx = i;
                }
            }
        }

        // swap min element with nums[idx]
        swap(nums, idx, minIdx);

        // reverse the remaining right side of the array
        reverse (nums, idx + 1, n - 1);

        return;
    }

    private  void reverse(int[] nums, int left, int right) {
        
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }

        return;
    }

    private void swap(int[] nums, int i, int j) {

        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];

        return;
    }

}
