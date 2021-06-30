// Runtime: 1 ms, faster than 63.42% of Java online submissions for Redundant Connection.
// Memory Usage: 39.4 MB, less than 50.11% of Java online submissions for Redundant Connection.
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        int[] ret = new int[2];
        for (int[] arr : edges) {
            if (uf.isSame(arr[0], arr[1])) ret = arr;
            else uf.unite(arr[0], arr[1]);
        }
        return ret;
    }
    
    class UnionFind {
        private int[] par;
        UnionFind(int size) {
            this.par = new int[size+1];
            for (int i=1; i<=size; i++) {
                this.par[i] = i;
            }
        }
        
        int root(int x) {
            if (this.par[x] == x) return x;
            int r = root(this.par[x]);
            this.par[x] = r;
            return r;
        }
        
        void unite(int x, int y) {
            int rx = root(x);
            int ry = root(y);
            if (rx == ry) return;
            int r = Math.min(rx, ry);
            this.par[rx] = r;
            this.par[ry] = r;
        }
        
        boolean isSame(int x, int y) {
            int rx = root(x);
            int ry = root(y);
            return rx == ry;
        }
    }

}