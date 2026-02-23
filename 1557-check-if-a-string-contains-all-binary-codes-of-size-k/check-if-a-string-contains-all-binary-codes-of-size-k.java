class Solution {
    public boolean hasAllCodes(String s, int k) {
         int need = 1 << k; // 2^k
        
        // quick fail
        if (s.length() - k + 1 < need) return false;

        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i + k <= s.length(); i++) {
            set.add(s.substring(i, i + k));
            if (set.size() == need) return true; // early stop
        }
        
        return false;
        
    }
}