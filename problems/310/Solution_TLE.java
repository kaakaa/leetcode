class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0)
            return Arrays.asList(0);

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] arr : edges) {
            map.putIfAbsent(arr[0], new HashSet<>());
            map.get(arr[0]).add(arr[1]);
            map.putIfAbsent(arr[1], new HashSet<>());
            map.get(arr[1]).add(arr[0]);
        }

        int minHeight = Integer.MAX_VALUE;
        List<Integer> ret = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            // System.out.println(entry.getKey() + ":" + entry.getValue());
            Set<Integer> checked = new HashSet<>();
            checked.add(entry.getKey());
            int level = 0, update = 1;

            Set<Integer> indexes = new HashSet<>(entry.getValue());
            while (update != 0 && level++ <= minHeight) {
                // System.out.println(" " + update + ":" + level + ":" + indexes);
                if (minHeight < level) {
                    break;
                }
                update = 0;
                Set<Integer> newIndexes = new HashSet<>();
                for (Integer v : indexes) {
                    if (!checked.contains(v)) {
                        checked.add(v);
                        update++;
                        newIndexes.addAll(map.get(v));
                    }
                }
                indexes = newIndexes;
            }

            // System.out.println(" => " + level);
            if (level < minHeight) {
                minHeight = level;
                ret.clear();
                ret.add(entry.getKey());
            } else if (level == minHeight) {
                ret.add(entry.getKey());
            }
        }
        return ret;
    }
}