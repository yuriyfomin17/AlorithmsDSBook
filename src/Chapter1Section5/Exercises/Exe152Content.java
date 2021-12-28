package Chapter1Section5.Exercises;

public class Exe152Content {

    static class QuickUnion {
        private int[] ids;
        private int count;

        public QuickUnion(int N) {
            this.ids = new int[N];
            this.count = N;
            for (int i = 0; i < this.ids.length; i++) this.ids[i] = i;
        }

        public static void main(String[] args) {
            int[] pArr = {9, 3, 5, 7, 2, 5, 0, 4};
            int[] qArr = {0, 4, 8, 2, 1, 7, 3, 2};
            int idx = 0;
            QuickUnion quickUnion = new QuickUnion(10);
            while (idx < pArr.length) {
                int p = pArr[idx];
                int q = qArr[idx];
                idx++;
                if (quickUnion.connected(p, q)) continue;
                System.out.printf("%d-%d\n", p, q);
                quickUnion.union(p, q);
            }
        }

        @Override
        public String toString(){
            String result = "";
            for (int i = 0; i < this.ids.length; i++) {
                result += this.ids[i];
            }
            return result;
        }
        public int find(int p) {
            while (p != ids[p]) p = ids[p];
            return p;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int pId = find(p);
            int qId = find(q);
            if (pId == qId) return;
            ids[pId] = qId;
            count--;
            System.out.println(this);
        }

        public int size(){ return this.count; }
    }
}
