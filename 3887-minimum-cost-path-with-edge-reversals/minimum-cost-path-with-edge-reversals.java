class Solution {
    public int minCost(int n, int[][] edges) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            // Normal direction
            graph[u].add(new int[]{v, w});
            // Reverse direction with cost = 2*w
            graph[v].add(new int[]{u, 2 * w});
        }

        // Dijkstra from node 0
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0});  // {cost, node}

        boolean[] seen = new boolean[n];

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int curCost = top[0], u = top[1];

            if (seen[u]) continue;
            seen[u] = true;

            if (u == n - 1) return curCost;  // reached target

            for (int[] next : graph[u]) {
                int v = next[0], w = next[1];
                int newCost = curCost + w;
                if (newCost < dist[v]) {
                    dist[v] = newCost;
                    pq.add(new int[]{newCost, v});
                }
            }
        }

        return dist[n - 1] < Integer.MAX_VALUE / 2 ? dist[n - 1] : -1;
        
    }
}