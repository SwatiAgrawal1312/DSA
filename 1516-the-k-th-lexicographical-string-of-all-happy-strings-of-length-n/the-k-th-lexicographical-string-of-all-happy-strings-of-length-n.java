class Solution {
    
         List<String> list = new ArrayList<>();

    public String getHappyString(int n, int k) {
        generate("", n);

        if (k > list.size()) {
            return "";
        }

        return list.get(k - 1);
    }

    public void generate(String curr, int n) {
        if (curr.length() == n) {
            list.add(curr);
            return;
        }

        char[] chars = {'a', 'b', 'c'};

        for (char ch : chars) {
            if (curr.length() == 0 || curr.charAt(curr.length() - 1) != ch) {
                generate(curr + ch, n);
            }
        }
    }
        
    
}