class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        int MOD = 1000000007;
        int bitLength = 0;

        for (int i = 1; i <= n; i++) {
            // if i is power of 2 → bit length increases
            if ((i & (i - 1)) == 0) {
                bitLength++;
            }

            // shift left and add i
            result = ((result << bitLength) + i) % MOD;
        }

        return (int) result;
        
    }
}