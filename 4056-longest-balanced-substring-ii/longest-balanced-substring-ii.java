class Solution {
    
    public int getLength(String s, char skip) {
        int maxLen = 0;
        int n = s.length();

        char first = (skip == 'a') ? 'b' : 'a';
        char second = (skip == 'c') ? 'b' : 'c';

        int i = 0;
        while (i < n) {
            int c1 = 0, c2 = 0;
            HashMap<Integer, Integer> prev = new HashMap<>();
            prev.put(0, i - 1);

            while (i < n && s.charAt(i) != skip) {
                char ch = s.charAt(i);
                if (ch == first) c1++;
                else c2++;

                int diff = c1 - c2;
                if (prev.containsKey(diff)) {
                    maxLen = Math.max(maxLen, i - prev.get(diff));
                } else {
                    prev.put(diff, i);
                }
                i++;
            }
            i++; // skip the `skip` character
        }
        return maxLen;
    }

    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        // Case 1: only one distinct character
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int len = 0;
            while (i < n && s.charAt(i) == ch) {
                i++;
                len++;
            }
            maxLen = Math.max(maxLen, len);
            i--;
        }

        // Case 2: exactly two characters
        maxLen = Math.max(maxLen, getLength(s, 'a'));
        maxLen = Math.max(maxLen, getLength(s, 'b'));
        maxLen = Math.max(maxLen, getLength(s, 'c'));

        // Case 3: all three characters
        HashMap<String, Integer> prev = new HashMap<>();
        int a = 0, b = 0, c = 0;
        prev.put("0#0", -1);

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') a++;
            else if (ch == 'b') b++;
            else c++;

            int diff1 = a - b;
            int diff2 = a - c;
            String key = diff1 + "#" + diff2;

            if (prev.containsKey(key)) {
                maxLen = Math.max(maxLen, i - prev.get(key));
            } else {
                prev.put(key, i);
            }
        }

        return maxLen;
        
    }
}