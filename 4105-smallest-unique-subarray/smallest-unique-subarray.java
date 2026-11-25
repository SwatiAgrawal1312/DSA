import java.util.*;

class Solution {
    private static final long MOD1 = 1_000_000_007L;
    private static final long MOD2 = 1_000_000_009L;
    private static final long BASE1 = 100_019L;
    private static final long BASE2 = 100_043L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        int low = 1;
        int high = n;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(nums, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int[] nums, int len) {
        int n = nums.length;

        long power1 = 1;
        long power2 = 1;

        for (int i = 0; i < len; i++) {
            power1 = (power1 * BASE1) % MOD1;
            power2 = (power2 * BASE2) % MOD2;
        }

        long hash1 = 0;
        long hash2 = 0;

        // First window
        for (int i = 0; i < len; i++) {
            hash1 = (hash1 * BASE1 + nums[i]) % MOD1;
            hash2 = (hash2 * BASE2 + nums[i]) % MOD2;
        }

        HashMap<Long, Integer> map = new HashMap<>();

        long key = hash1 * MOD2 + hash2;
        map.put(key, 1);

        // Sliding window
        for (int i = len; i < n; i++) {
            int outgoing = nums[i - len];
            int incoming = nums[i];

            hash1 = (hash1 * BASE1 + incoming
                    - (power1 * outgoing) % MOD1 + MOD1) % MOD1;

            hash2 = (hash2 * BASE2 + incoming
                    - (power2 * outgoing) % MOD2 + MOD2) % MOD2;

            key = hash1 * MOD2 + hash2;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // Check if any subarray occurs exactly once
        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}