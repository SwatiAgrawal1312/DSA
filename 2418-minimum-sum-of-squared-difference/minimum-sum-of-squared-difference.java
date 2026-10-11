
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;

        int[] diff = new int[100001];
        int maxDiff = 0;
        long total = 0;

        for (int i = 0; i < nums1.length; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            diff[d]++;
            maxDiff = Math.max(maxDiff, d);
            total += d;
        }

        if (total <= k) {
            return 0;
        }

        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (diff[d] == 0) {
                continue;
            }

            // Reduce all differences at level d together
            long count = Math.min((long) diff[d], k);

            diff[d] -= (int) count;
            diff[d - 1] += (int) count;
            k -= count;
        }

        long ans = 0;

        for (int d = 1; d <= maxDiff; d++) {
            ans += (long) d * d * diff[d];
        }

        return ans;
    }
}
