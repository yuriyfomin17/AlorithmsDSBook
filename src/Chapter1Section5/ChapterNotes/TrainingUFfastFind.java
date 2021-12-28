package Chapter1Section5.ChapterNotes;

public class TrainingUFfastFind {
    int[] id;
    int count;
    public TrainingUFfastFind(int N){
        this.count = N;
        this.id = new int[N];
        for (int i = 0; i < N; i++) this.id[i] = i;
    }
    // component identifier for p
    public int find(int p){
        return id[p];
    }
    // adds connection between p and q
    public void union(int p, int q){
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) id[i] = qId;
        }
        count--;
    }

    public boolean connected(int p, int q){ return find(p) == find(q); }
    public int count() { return this.count; }

    public static void main(String[] args) {
        int N = 10;
        int[] pArr = {4, 3, 6, 9, 2, 8, 5, 7, 6, 1, 6};
        int[] qArr = {3, 8, 5, 4, 1, 9, 0, 2, 1, 0, 7};
        int idx = 0;
        TrainingUFfastFind trainingUFfastFind = new TrainingUFfastFind(N);

        while (idx < qArr.length){
            int p = pArr[idx];
            int q = qArr[idx];
            idx++;
            if (trainingUFfastFind.connected(p, q)) continue;
            trainingUFfastFind.union(p, q);
        }
//        1
//        1
//        1
//        8
//        8
//        1
//        1
//        1
//        8
//        8
        for (int node: trainingUFfastFind.id) {
            System.out.println(node);
        }
    }
}
