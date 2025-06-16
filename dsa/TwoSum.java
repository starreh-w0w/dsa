// LC #1 | Two Sum
// https://leetcode.com/problems/two-sum/

package dsa;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum (int[] nums, int target) {

        HashMap<Integer, Integer> diff = new HashMap<>();

        for (int num: nums) {
            int complement = target - num;

            if (diff.containsKey(complement)) {
                return new int[] {num, complement};
            }
             
            diff.put(num, complement);
        }
        return new int[] {};
    }
}
