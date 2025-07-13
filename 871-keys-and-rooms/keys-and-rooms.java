class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        visited.add(0);

        while (!stack.isEmpty()) {
            int currentRoom = stack.pop();

            for (int key : rooms.get(currentRoom)) {
                if (!visited.contains(key)) {
                    visited.add(key);
                    stack.push(key);
                }
            }
        }
        return visited.size() == n;
    }
}