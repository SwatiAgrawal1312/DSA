class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        int leftRemove = 0;
        int rightRemove = 0;

        // Find minimum removals
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                leftRemove++;
            }
            else if (ch == ')') {

                if (leftRemove > 0) {
                    leftRemove--;
                }
                else {
                    rightRemove++;
                }
            }
        }

        solver(s, 0, "", leftRemove, rightRemove, 0, set);

        list.addAll(set);

        return list;
    }

    public void solver(
        String s,
        int i,
        String curr,
        int leftRemove,
        int rightRemove,
        int balance,
        HashSet<String> set
    ) {

        // Invalid
        if (balance < 0) {
            return;
        }

        // End
        if (i == s.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                balance == 0) {

                set.add(curr);
            }

            return;
        }

        char ch = s.charAt(i);

        // '('
        if (ch == '(') {

            // Remove '('
            if (leftRemove > 0) {

                solver(
                    s,
                    i + 1,
                    curr,
                    leftRemove - 1,
                    rightRemove,
                    balance,
                    set
                );
            }

            // Keep '('
            solver(
                s,
                i + 1,
                curr + ch,
                leftRemove,
                rightRemove,
                balance + 1,
                set
            );
        }

        // ')'
        else if (ch == ')') {

            // Remove ')'
            if (rightRemove > 0) {

                solver(
                    s,
                    i + 1,
                    curr,
                    leftRemove,
                    rightRemove - 1,
                    balance,
                    set
                );
            }

            // Keep ')' only if there is '(' available
            if (balance > 0) {

                solver(
                    s,
                    i + 1,
                    curr + ch,
                    leftRemove,
                    rightRemove,
                    balance - 1,
                    set
                );
            }
        }

        // Normal character
        else {

            solver(
                s,
                i + 1,
                curr + ch,
                leftRemove,
                rightRemove,
                balance,
                set
            );
        }
    }
}