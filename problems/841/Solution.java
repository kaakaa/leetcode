// Runtime: 3 ms, faster than 13.48% of Java online submissions for Keys and Rooms.
// Memory Usage: 39 MB, less than 25.00% of Java online submissions for Keys and Rooms.
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.get(0).size() == 0) {
            return rooms.size() == 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i : rooms.get(0)) queue.offer(i);

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        
        int num = rooms.size();
        while (!queue.isEmpty()) {
            Integer room = queue.poll();
            visited.add(room);
            if (visited.size() == num) {
                return true;
            }
            
            for (Integer i : rooms.get(room)) {
                if (!visited.contains(i)) {
                    queue.offer(i);
                }
            }
        }
        return visited.size() == num;
    }
}