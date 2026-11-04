
import java.util.*;

class Solution {

    class WindowMedian {

        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int leftSize = 0;
        int rightSize = 0;

        long leftSum = 0;
        long rightSum = 0;

        // Insert one element
        void add(int val) {

            if (left.isEmpty() || val <= left.lastKey()) {
                left.put(val, left.getOrDefault(val, 0) + 1);
                leftSize++;
                leftSum += val;
            } 
            else {
                right.put(val, right.getOrDefault(val, 0) + 1);
                rightSize++;
                rightSum += val;
            }

            balance();
        }

        // Remove one occurrence
        void remove(int val) {

            if (left.containsKey(val)) {

                int count = left.get(val);

                if (count == 1) {
                    left.remove(val);
                } else {
                    left.put(val, count - 1);
                }

                leftSize--;
                leftSum -= val;
            } 
            else {

                int count = right.get(val);

                if (count == 1) {
                    right.remove(val);
                } else {
                    right.put(val, count - 1);
                }

                rightSize--;
                rightSum -= val;
            }

            balance();
        }

        // Balance both TreeMaps
        void balance() {

            while (leftSize > rightSize + 1) {

                int val = left.lastKey();

                decrease(left, val);
                leftSize--;
                leftSum -= val;

                increase(right, val);
                rightSize++;
                rightSum += val;
            }

            while (leftSize < rightSize) {

                int val = right.firstKey();

                decrease(right, val);
                rightSize--;
                rightSum -= val;

                increase(left, val);
                leftSize++;
                leftSum += val;
            }
        }

        void increase(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        void decrease(TreeMap<Integer, Integer> map, int val) {

            int count = map.get(val);

            if (count == 1) {
                map.remove(val);
            } else {
                map.put(val, count - 1);
            }
        }

        // Calculate minimum operations using median
        long getCost() {

            long median = left.lastKey();

            long leftCost =
                median * leftSize - leftSum;

            long rightCost =
                rightSum - median * rightSize;

            return leftCost + rightCost;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Required intermediate variable
        int[] maritovexi = nums.clone();

        // Step 1: Calculate cost of every window
        long[] cost = new long[n - x + 1];

        WindowMedian wm = new WindowMedian();

        // Insert first window
        for (int i = 0; i < x; i++) {
            wm.add(maritovexi[i]);
        }

        cost[0] = wm.getCost();

        // Slide the window
        for (int i = x; i < n; i++) {

            // Remove outgoing element
            wm.remove(maritovexi[i - x]);

            // Insert incoming element
            wm.add(maritovexi[i]);

            cost[i - x + 1] = wm.getCost();
        }

        // Step 2: Dynamic Programming
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int j = 1; j <= k; j++) {
            Arrays.fill(dp[j], INF);
        }

        // dp[0][i] = 0 for all i

        for (int j = 1; j <= k; j++) {

            for (int i = 1; i <= n; i++) {

                // Choice 1: Skip current element
                dp[j][i] = dp[j][i - 1];

                // Choice 2: Select window of size x
                if (i >= x && dp[j - 1][i - x] != INF) {

                    dp[j][i] = Math.min(
                        dp[j][i],
                        dp[j - 1][i - x] + cost[i - x]
                    );
                }
            }
        }

        return dp[k][n];
    }
}
