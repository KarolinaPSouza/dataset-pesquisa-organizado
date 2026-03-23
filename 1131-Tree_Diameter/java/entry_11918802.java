import java.io.*;
import java.util.*;

public class entry_11918802 {
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("inputf.in"));
            System.setOut(new PrintStream(new FileOutputStream("outputf.in")));
        } catch (Exception e) {
            System.err.println("Error : " + e);
        }

        FastScanner in = new FastScanner();   
        int n = in.nextInt();

        if(n == 1){
            System.out.println(n-1);
            return;
        }

        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }


        for(int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }


        int[] firstBFS = BFS(1, adj);         
        int[] secondBFS = BFS(firstBFS[1],adj); 


        System.out.println(secondBFS[0]);
    }

    // BFS returns an int[]: [distanceInLayers, lastNodeReached]
    public static int[] BFS(int root, ArrayList<Integer>[] adj) {
        // queue elements are (node, parent)
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {root, -1});

        int steps = 0;      // BFS layers
        int lastNode = root;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                int node = curr[0];
                int par = curr[1];

                lastNode = node; 


                for(int neigh : adj[node]) {
                    if(neigh == par) continue;

                    queue.offer(new int[] {neigh, node});
                }
            }
            steps++;
        }

        return new int[] {steps - 1, lastNode}; 
    }
}



/* ------------------ FastScanner Class ------------------ */
class FastScanner {
    private int BS = 1 << 16;
    private char NC = (char) 0;
    private byte[] buf = new byte[BS];
    private int bId = 0, size = 0;
    private char c = NC;
    private double cnt = 1;
    private BufferedInputStream in;

    public FastScanner() {
        in = new BufferedInputStream(System.in, BS);
    }

    public FastScanner(String s) {
        try {
            in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
        } catch (Exception e) {
            in = new BufferedInputStream(System.in, BS);
        }
    }

    private char getChar() {
        while (bId == size) {
            try {
                size = in.read(buf);
            } catch (Exception e) {
                return NC;
            }
            if (size == -1) return NC;
            bId = 0;
        }
        return (char) buf[bId++];
    }

    public int nextInt() {
        return (int) nextLong();
    }

    public int[] nextInts(int N) {
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = (int) nextLong();
        }
        return res;
    }

    public long[] nextLongs(int N) {
        long[] res = new long[N];
        for (int i = 0; i < N; i++) {
            res[i] = nextLong();
        }
        return res;
    }

    public long nextLong() {
        cnt = 1;
        boolean neg = false;
        if (c == NC) c = getChar();
        for (; (c < '0' || c > '9'); c = getChar()) {
            if (c == '-') neg = true;
        }
        long res = 0;
        for (; c >= '0' && c <= '9'; c = getChar()) {
            res = (res << 3) + (res << 1) + c - '0'; 
            cnt *= 10;
        }
        return neg ? -res : res;
    }

    public double nextDouble() {
        double cur = nextLong();
        return c != '.' ? cur : cur + nextLong() / cnt;
    }

    public double[] nextDoubles(int N) {
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = nextDouble();
        }
        return res;
    }

    public String next() {
        StringBuilder sb = new StringBuilder();
        while (c <= 32) c = getChar();
        while (c > 32) {
            sb.append(c);
            c = getChar();
        }
        return sb.toString();
    }

    public String nextLine() {
        StringBuilder sb = new StringBuilder();
        while (c <= 32) c = getChar();
        while (c != '\n') {
            sb.append(c);
            c = getChar();
        }
        return sb.toString();
    }

    public boolean hasNext() {
        if (c > 32) return true;
        while (true) {
            c = getChar();
            if (c == NC) return false;
            else if (c > 32) return true;
        }
    }
}