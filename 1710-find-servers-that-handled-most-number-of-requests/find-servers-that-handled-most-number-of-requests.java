class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        TreeSet<Integer> available = new TreeSet<>();

        // Initially, all servers are available
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        // Stores {finishTime, serverId}
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        int[] count = new int[k];

        for (int i = 0; i < arrival.length; i++) {

            int time = arrival[i];

            // Release servers that have completed their requests
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] curr = busy.poll();
                available.add(curr[1]);
            }

            if (available.isEmpty()) {
                continue;
            }

            // Preferred server
            int server = i % k;

            // Find first available server >= preferred server
            Integer chosen = available.ceiling(server);

            // Circular search
            if (chosen == null) {
                chosen = available.first();
            }

            // Assign request
            available.remove(chosen);

            count[chosen]++;

            // Server becomes free at arrival + load
            busy.offer(new int[]{
                time + load[i], chosen
            });
        }

        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                ans.add(i);
            }
        }

        return ans;
    }
}