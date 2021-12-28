package Chapter1Section5.ChapterNotes;

public class TrainingUFfastUnion {
    int[] id;
    int count;

    public TrainingUFfastUnion(int N) {
        this.count = N;
        this.id = new int[N];
        for (int i = 0; i < N; i++) this.id[i] = i;
    }

    public static void main(String[] args) {
        int N = 10;
        int[] pArr = {4, 3, 6, 9, 2, 8, 5, 7, 6, 1, 6};
        int[] qArr = {3, 8, 5, 4, 1, 9, 0, 2, 1, 0, 7};
        int idx = 0;
        TrainingUFfastUnion trainingUFfastUnion = new TrainingUFfastUnion(N);

        while (idx < pArr.length) {
            int p = pArr[idx];
            int q = qArr[idx];
            idx++;
            if (trainingUFfastUnion.connected(p, q)) continue;
            trainingUFfastUnion.union(p, q);
        }

        for (int i = 0; i < N; i++) {
            int root = trainingUFfastUnion.find(i);
            System.out.println(root);

        }
    }

    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int qRoot = find(p);
        int pRoot = find(q);

        if (pRoot == qRoot) return;

        id[qRoot] = pRoot;
        count--;
    }
}
