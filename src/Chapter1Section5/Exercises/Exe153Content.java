package Chapter1Section5.Exercises;

public class Exe153Content {

    static class WeightedQuickUnion {
        private int[] ids;
        private int count;
        private int[] sz;

        public WeightedQuickUnion(int N) {
            this.ids = new int[N];
            this.count = N;
            this.sz = new int[N];
            for (int i = 0; i < N; i++) this.ids[i] = i;
            for (int i = 0; i < N; i++) this.sz[i] = 1;
        }

        public int find(int p) {
            while (p != this.ids[p]) p = this.ids[p];
            return p;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int pId = find(p);
            int qId = find(q);
            if (pId == qId) return;

            if (sz[pId] < sz[qId]) {
                ids[pId] = qId;
                sz[qId] += sz[pId];
            } else {
                ids[qId] = pId;
                sz[pId] += sz[qId];
            }
            count--;
            System.out.println(this);
        }

        public int size(){ return count; }

        @Override
        public String toString(){
            String result = "";
            for (int i = 0; i < ids.length; i++) result += ids[i];
            return result;
        }
    }

    public static void main(String[] args) {
        WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(10);
        int[] pArr = {9, 3, 5, 7, 2, 5, 0, 4};
        int[] qArr = {0, 4, 8, 2, 1, 7, 3, 2};
        int idx = 0;

        while (idx < pArr.length){
            int p = pArr[idx];
            int q = qArr[idx];
            idx++;
            if (weightedQuickUnion.connected(p, q)) continue;
            System.out.printf("%d - %d\n", p, q);
            weightedQuickUnion.union(p, q);
        }
    }
}
