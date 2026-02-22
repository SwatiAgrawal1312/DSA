class Solution {
    public int binaryGap(int n) {

        int last = -1;   // position of last seen 1
        int maxGap = 0;  // maximum distance
        int pos = 0;     // current bit position
        
        while (n > 0) {
            if ((n & 1) == 1) {   // if current bit is 1
                if (last != -1) {
                    maxGap = Math.max(maxGap, pos - last);
                }
                last = pos;
            }
            pos++;
            n >>= 1;  // shift right
        }
        
        return maxGap;
        
    }
}