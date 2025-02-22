import java.util.Scanner;

class UF {
    private int[] parent;  
    private int[] size;    
    private int count;     

    // Initialize UF data structure with N objects (0 to N-1)
    public UF(int N) {
        count = N;
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;  
            size[i] = 1;    
        }
    } 

    // Add connection between p and q (i.e., merge the sets containing p and q)
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;  

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;  
    }

    // Are p and q in the same component?
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public int count() {
        return count;
    }

    public static Scanner StdIn = new Scanner(System.in);
    public static void main(String[] args) {
        int N = StdIn.nextInt(); 
        UF uf = new UF(N);
        while (StdIn.hasNext()) {
            int p = StdIn.nextInt();
            int q = StdIn.nextInt();

            if (!uf.connected(p, q)) {
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
        }
    }
}
