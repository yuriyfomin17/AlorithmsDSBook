package Chapter1Section5.ChapterNotes;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class UnionFindImplementationWeightedQuickUnion {
    int[] ids;
    int[] sz;
    int count;

    public UnionFindImplementationWeightedQuickUnion(int N) {
        ids = new int[N];
        sz = new int[N];
        count = N;
        for (int i = 0; i < N; i++) ids[i] = i;
        for (int i = 0; i < N; i++) sz[i] = 1;
    }

    public static void main(String[] args) {
//        int[] arr = {10, 20, 40, 80, 160, 320};
//        for (int i = 0; i < arr.length; i++) {
//            double time = timeTrial(arr[i]);
//            StdOut.printf("%7d %5.1f\n", arr[i], time);
//        }

        readDataFromFile();
    }

    public static double timeTrial(int n) {
        // Time ThreeSum.count() for N random 6-digit ints.

        Stopwatch timer = new Stopwatch();
        int idx = 0;
        while (idx < n * 5000000) {
            readDataFromArray();
            idx++;
        }
        return timer.elapsedTime();
    }

    public static void readDataFromArray() {
        int N = 10;
        int[] pArr = {4, 3, 6, 9, 2, 8, 5, 7, 6, 1, 6};
        int[] qArr = {3, 8, 5, 4, 1, 9, 0, 2, 1, 0, 7};
        int idx = 0;
        UnionFindImplementationWeightedQuickUnion unionFindImplementationWeightedQuickUnion = new UnionFindImplementationWeightedQuickUnion(N);
        while (idx < pArr.length) {
            int p = pArr[idx];
            int q = qArr[idx];
            idx++;
            if (unionFindImplementationWeightedQuickUnion.connected(p, q)) continue;
            unionFindImplementationWeightedQuickUnion.union(p, q);
        }
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
        if (sz[p] < sz[q]) {
            ids[p] = q;
            sz[q] += sz[p];
        } else {
            ids[q] = p;
            sz[p] += sz[q];
        }
        count--;

    }

    public int size() {
        return count;
    }
    public static void readDataFromFile() {
        // Solve dynamic connectivity problem on StdIn
        int N = StdIn.readInt(); // read number of sites
        UnionFindImplementationWeightedQuickUnion uf = new UnionFindImplementationWeightedQuickUnion(N); // initialize N components
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt(); // Read pair to connect
            if (uf.connected(p, q)) continue; // Ignore if connected
            uf.union(p, q); // combine components
//            StdOut.println(p + " " + q); // and print connection
            StdOut.println(uf.size() + " components\n");
        }
        StdOut.println(uf.size() + " components\n");

    }
}
