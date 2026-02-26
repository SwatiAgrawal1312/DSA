class Solution {
    public int numSteps(String s) {
         int steps = 0;
        StringBuilder sb = new StringBuilder(s);
        
        while (sb.length() > 1) {
            int last = sb.length() - 1;
            
            if (sb.charAt(last) == '0') {
                // even → divide by 2
                sb.deleteCharAt(last);
            } else {
                // odd → add 1
                addOne(sb);
            }
            steps++;
        }
        return steps;
    }
    
    private void addOne(StringBuilder sb) {
        int i = sb.length() - 1;
        
        // handle carry
        while (i >= 0 && sb.charAt(i) == '1') {
            sb.setCharAt(i, '0');
            i--;
        }
        
        if (i >= 0) {
            sb.setCharAt(i, '1');
        } else {
            sb.insert(0, '1');
        }
    }
        
    }
