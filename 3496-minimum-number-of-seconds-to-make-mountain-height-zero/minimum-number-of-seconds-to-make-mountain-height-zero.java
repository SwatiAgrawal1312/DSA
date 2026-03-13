class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
         long left = 1;
        long right = (long)1e16;

        while (left < right) {

            long mid = left + (right - left) / 2;

            if (canFinish(mid, mountainHeight, workerTimes)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFinish(long time, int mountainHeight, int[] workerTimes) {

        long totalHeight = 0;

        for (int wt : workerTimes) {

            long h = (long)((Math.sqrt(1 + 8.0 * time / wt) - 1) / 2);

            totalHeight += h;

            if (totalHeight >= mountainHeight)
                return true;
        }

        return false;
        
    }
}