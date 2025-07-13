class Solution {
    int reorderCount = 0;
    Map<Integer, List<int[]>> adj; 
    public int minReorder(int n, int[][] connections) {
        adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] conn : connections) {
            int u = conn[0];
            int v = conn[1];
            adj.get(u).add(new int[]{v, 1});
            adj.get(v).add(new int[]{u, 0});
        }

        Set<Integer> visited = new HashSet<>();
        dfs(0, visited); 
        return reorderCount;
    }

    private void dfs(int currentCity, Set<Integer> visited) {
        visited.add(currentCity);

        for (int[] neighborInfo : adj.get(currentCity)) {
            int neighbor = neighborInfo[0];
            int directionFlag = neighborInfo[1];

            if (!visited.contains(neighbor)) {
                if (directionFlag == 1) { 
                    reorderCount++; 
                }
                dfs(neighbor, visited);
            }
        }
    }
}