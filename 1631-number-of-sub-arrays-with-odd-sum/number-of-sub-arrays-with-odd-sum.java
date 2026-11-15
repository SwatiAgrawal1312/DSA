
class Solution {
    public int numOfSubarrays(int[] arr) {

        long MOD = 1000000007;

        long even = 1;
        long odd = 0;

        long prefix = 0;
        long count = 0;

        for (int num : arr) {

            prefix += num;

            if (prefix % 2 != 0) {
                count = (count + even) % MOD;
                odd++;
            } 
            else {
                count = (count + odd) % MOD;
                even++;
            }
        }

        return (int) count;
    }
}
