class Solution {
    int[][] prefix;

    public int maxSideLength(int[][] mat, int threshold) {
        int rows = mat.length;
        int cols = mat[0].length;

        prefix = new int[rows][cols];

        // Build prefix sum
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                prefix[i][j] =
                        (i > 0 ? prefix[i - 1][j] : 0)
                      + (j > 0 ? prefix[i][j - 1] : 0)
                      - (i > 0 && j > 0 ? prefix[i - 1][j - 1] : 0)
                      + mat[i][j];
            }
        }

        int best = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                for (int k = best; i + k < rows && j + k < cols; k++) {
                    int r2 = i + k;
                    int c2 = j + k;

                    int sum = sumSquare(i, j, r2, c2);

                    if (sum <= threshold) {
                        best = Math.max(best, k + 1);
                    } else {
                        break; // further expansion only increases sum
                    }
                }
            }
        }
        return best;
    }

    private int sumSquare(int r1, int c1, int r2, int c2) {
        return prefix[r2][c2]
                - (r1 > 0 ? prefix[r1 - 1][c2] : 0)
                - (c1 > 0 ? prefix[r2][c1 - 1] : 0)
                + (r1 > 0 && c1 > 0 ? prefix[r1 - 1][c1 - 1] : 0);
    }
}