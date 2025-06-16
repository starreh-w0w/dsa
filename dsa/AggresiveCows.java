// GFG | Aggressive Cows
// https://www.geeksforgeeks.org/problems/aggressive-cows/

package dsa;

import java.util.Arrays;

public class AggresiveCows {
    public int aggressiveCows(int[] stalls, int k) {

        int n = stalls.length;

        if (k > n) return -1;

        Arrays.sort(stalls);

        int low = 1, high = (stalls[n - 1] - stalls[0]);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean canBePlaced = canWePlace(stalls, mid, k);

            if (canBePlaced) low = mid + 1;
            else high = mid - 1;
        }

        return high;
    }

    private boolean canWePlace (int[] stalls, int dis, int cows) {
        int cntCows = 1, lastCow = stalls[0];

        for (int stl: stalls) {
            int dist = stl - lastCow;

            if (dist >= dis) {
                cntCows++;
                lastCow = stl;
            }

            if (cntCows >= cows) return true;
        }
        return false;
    }
}
