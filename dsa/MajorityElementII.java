// LC #229 | Majority Element II
// https://leetcode.com/problems/majority-element-ii/

package dsa;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    
    public List<Integer> majorityElement(int[] nums) {

        int n = nums.length;

        int e1 = Integer.MIN_VALUE, e2 = Integer.MIN_VALUE, c1 = 0, c2 = 0;

        // Extended Boyer Moore's Voting Algorithm

        for (int i = 0; i < n; i++) {
            if (c1 == 0 && e2 != nums[i]) {
                e1 = nums[i];
                c1++;
            }

            else if (c2 == 0 && e1 != nums[i]) {
                e2 = nums[i];
                c2++;
            }

            else if (e1 == nums[i]) c1++;

            else if (e2 == nums[i]) c2++;

            else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;

        // Finding Total Count

        for (int i = 0; i < n; i++) {
            if (nums[i] == e1) c1++;
            if (nums[i] == e2) c2++;
        }

        int min = (int) (n / 3) + 1;

        List<Integer> ans = new ArrayList<>();

        if (c1 >= min) ans.add(e1);
        if (c2 >= min) ans.add(e2);

        return ans;
    }
}
