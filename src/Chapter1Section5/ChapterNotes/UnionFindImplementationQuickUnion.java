package Chapter1Section5.ChapterNotes;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFindImplementationQuickUnion {
    private int[] id;
    private int count;
    public UnionFindImplementationQuickUnion(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public int count(){return count;}
    public int find(int p){
        while (p != id[p]) p = id[p];
        return p;
    }
    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }
    public static void main(String[] args) {
        readDataFromFile();
    }
    public static void readDataFromFile() {
        // Solve dynamic connectivity problem on StdIn
        int N = StdIn.readInt(); // read number of sites
        UnionFindImplementationQuickUnion uf = new UnionFindImplementationQuickUnion(N); // initialize N components
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt(); // Read pair to connect
            if (uf.connected(p, q)) continue; // Ignore if connected
            uf.union(p, q); // combine components
            StdOut.println(p + " " + q); // and print connection
        }
        StdOut.println(uf.count() + " components\n");

    }
}
