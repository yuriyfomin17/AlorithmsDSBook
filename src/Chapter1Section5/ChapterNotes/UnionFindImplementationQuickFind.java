package Chapter1Section5.ChapterNotes;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class UnionFindImplementationQuickFind {
    private int[] id; // access to component if (site indexed)

    private int count; // number of components

    // initialize N sites with integer names (0 to N - 1)
    public UnionFindImplementationQuickFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    public static void main(String[] args) {
        // by running double test ratio we can see that
        // union quick find usually require N^2 array accesses

        // i.e. (N + 3) (N - 1) = N^2
//        int[] arr = {10, 20, 40, 80, 160, 320};
//        for (int i = 0; i < arr.length; i++) {
//            double time = timeTrial(arr[i]);
//            StdOut.printf("%7d %5.1f\n", arr[i], time);
//        }
//        readDataFromArray();

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
        UnionFindImplementationQuickFind uf = new UnionFindImplementationQuickFind(N);
        while (idx < pArr.length) {
            int p = pArr[idx];
            int q = qArr[idx];
            idx++;
            if (uf.connected(p, q)) continue; // Ignore if connected
            uf.union(p, q); // combine components
//            StdOut.println(p + " " + q); // and print connection
        }
//        for (int el: uf.id) {
//            System.out.println(el);
//        }

//        StdOut.println(uf.count() + " components\n");
    }

    public static void readDataFromFile() {
        // Solve dynamic connectivity problem on StdIn
        int N = StdIn.readInt(); // read number of sites
        UnionFindImplementationQuickFind uf = new UnionFindImplementationQuickFind(N); // initialize N components
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt(); // Read pair to connect
            if (uf.connected(p, q)) continue; // Ignore if connected
            uf.union(p, q); // combine components
            StdOut.println(p + " " + q); // and print connection
        }
        StdOut.println(uf.count() + " components\n");

    }

    // add connection between p and q
    void union(int p, int q) {
        // Quick find algorithm uses one array access fro each call to find between
        // N + 3 and 2N + 1 array accesses for each call to union that combines
        // two components

        // Put p and q into the same component
        int pID = find(p);
        int qID = find(q);

        // Nothing to do if p and q are already in the same component
        if (pID == qID) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) id[i] = qID;
        }
        count--;
    }

    // component identifier for p (0 to N - 1)
    int find(int p) {
        return id[p];
    }

    // return true if p and q are in the same component
    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // number of components
    int count() {
        return count;
    }
}
