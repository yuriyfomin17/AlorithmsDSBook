package Chapter1Section5.Exercises;

public class Exe151Content {
    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(10);
        int[] pArr = {9, 3, 5, 7, 2, 5, 0, 4};
        int[] qArr = {0, 4, 8, 2, 1, 7, 3, 2};
        int idx = 0;
        while (idx < pArr.length){
            int p = pArr[idx];
            int q = qArr[idx];
            idx++;
            if (quickFind.connected(p, q)) continue;
            quickFind.union(p, q);
        }
    }

    static class QuickFind {
        private int[] ids;
        private int count;

        public QuickFind(int N) {
            ids = new int[N];
            count = N;
            for (int i = 0; i < N; i++) ids[i] = i;
        }

        public int find(int p) {
            return ids[p];
        }

        public boolean connected(int p, int q) {
            return ids[p] == ids[q];
        }

        public void union(int p, int q) {
            int pId = find(p);
            int qId = find(q);
            if (pId == qId) return;

            for (int i = 0; i < ids.length; i++) {
                if (ids[i] == pId) ids[i] = qId;
            }
            count--;
            System.out.println(this);
        }

        public int size() {
            return count;
        }

        @Override
        public String toString(){
            String result = "";
            for (int i = 0; i < ids.length; i++) {
                result += ids[i];
            }
            return result;
        }
    }
}
