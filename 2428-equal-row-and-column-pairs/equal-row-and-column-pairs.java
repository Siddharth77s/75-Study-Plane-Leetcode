class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowFrequencies = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]);
                if (j < n - 1) {
                    sb.append(",");
                }
            }
            String rowString = sb.toString();
            rowFrequencies.put(rowString, rowFrequencies.getOrDefault(rowString, 0) + 1);
        }

        int count = 0;
        for (int j = 0; j < n; j++) { 
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) { 
                sb.append(grid[i][j]);
                if (i < n - 1) {
                    sb.append(",");
                }
            }
            String colString = sb.toString();
            if (rowFrequencies.containsKey(colString)) {
                count += rowFrequencies.get(colString);
            }
        }

        return count;
    }
}
