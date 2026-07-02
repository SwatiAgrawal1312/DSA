class Solution {
    public String countAndSay(int n) {

        String result = "1";

        for (int i = 2; i <= n; i++) {
            result = generateNext(result);
        }

        return result;
    }

    private String generateNext(String s) {

        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count);
                sb.append(s.charAt(i - 1));
                count = 1;
            }
        }

        // Add the last group
        sb.append(count);
        sb.append(s.charAt(s.length() - 1));

        return sb.toString();
    }
}