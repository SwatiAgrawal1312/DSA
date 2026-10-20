
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] prefMax = new int[n + 1];
        int[] suffMin = new int[n + 1];
        int[] prefDrop = new int[n];

        // Prefix maximum
        for (int i = 0; i < n; i++) {
            prefMax[i + 1] = Math.max(prefMax[i], nums[i]);
        }

        // Suffix minimum
        suffMin[n] = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
        }

        // Prefix count of descending adjacent pairs
        for (int i = 1; i < n; i++) {
            prefDrop[i] = prefDrop[i - 1];

            if (nums[i - 1] > nums[i]) {
                prefDrop[i]++;
            }
        }

        int ans = 0;

        // Check every divisor of n
        for (int d = 1; d <= n / d; d++) {
            if (n % d == 0) {
                if (check(nums, prefMax, suffMin, prefDrop, d)) {
                    ans += d;
                }

                int other = n / d;

                if (other != d &&
                    check(nums, prefMax, suffMin, prefDrop, other)) {
                    ans += other;
                }
            }
        }

        return ans;
    }

    private boolean check(int[] nums, int[] prefMax,
                          int[] suffMin, int[] prefDrop, int k) {
        int n = nums.length;

        for (int start = 0; start < n; start += k) {
            int end = start + k - 1;

            int drops = prefDrop[end] - prefDrop[start];

            // Circular boundary
            if (nums[end] > nums[start]) {
                drops++;
            }

            // Block must be cyclically sortable,
            // and elements must remain globally ordered.
            if (drops > 1 || prefMax[start] > suffMin[start]) {
                return false;
            }
        }

        return true;
    }
}
