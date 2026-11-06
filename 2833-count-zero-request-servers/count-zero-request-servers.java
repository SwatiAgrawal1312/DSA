import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int m = logs.length;
        int q = queries.length;

        
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        
        Integer[] indices = new Integer[q];

        for (int i = 0; i < q; i++) {
            indices[i] = i;
        }

        
        Arrays.sort(indices, (a, b) -> queries[a] - queries[b]);

        int[] ans = new int[q];

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        for (int idx : indices) {

            int y = queries[idx];

            
            while (right < m && logs[right][1] <= y) {

                int server = logs[right][0];

                map.put(server, map.getOrDefault(server, 0) + 1);

                right++;
            }

            
            while (left < right && logs[left][1] < y - x) {

                int server = logs[left][0];

                map.put(server, map.get(server) - 1);

                if (map.get(server) == 0) {
                    map.remove(server);
                }

                left++;
            }

            
            ans[idx] = n - map.size();
        }

        return ans;
    }
}