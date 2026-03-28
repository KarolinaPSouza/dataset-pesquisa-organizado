import java.io.*;
import java.util.*;

public class entry_2424280 implements Runnable {

    public void solve() throws IOException  {
        n = readInt();
        if (n == 1) {
            out.println(0);
            return;
        }

        int[] l = new int[n - 1];
        int[] r = new int[n - 1];
        int[] sizes = new int[n];
        for (int i = 0; i < n - 1; i++) {
            l[i] = readInt() - 1;
            r[i] = readInt() - 1;
            sizes[l[i]]++;
            sizes[r[i]]++;
        }

        int[][] edges = new int[n][];
        for (int i = 0; i < n; i++) {
            edges[i] = new int[sizes[i]];
        }
        for (int i = 0; i < n - 1; i++) {
            edges[l[i]][--sizes[l[i]]] = r[i];
            edges[r[i]][--sizes[r[i]]] = l[i];
        }

        int[] curLayer = new int[n];
        int curLayerSize = 0;
        int[] nextLayer = new int[n];
        int nextLayerSize = 1;
        nextLayer[0] = 0;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while (nextLayerSize > 0) {
            System.arraycopy(nextLayer, 0, curLayer, 0, nextLayerSize);
            curLayerSize = nextLayerSize;
            nextLayerSize = 0;
            for (int i = 0; i < curLayerSize; i++) {
                for (int j = 0; j < edges[curLayer[i]].length; j++) {
                    if (!visited[edges[curLayer[i]][j]]) {
                        nextLayer[nextLayerSize++] = edges[curLayer[i]][j];
                        visited[edges[curLayer[i]][j]] = true;
                    }
                }
            }
        }
        int firstFarthest = curLayer[0];

        ans = new int[n];
        curLayerSize = 0;
        nextLayerSize = 1;
        nextLayer[0] = firstFarthest;
        Arrays.fill(visited, false);
        visited[firstFarthest] = true;
        int dist = 0;
        while (nextLayerSize > 0) {
            dist++;
            System.arraycopy(nextLayer, 0, curLayer, 0, nextLayerSize);
            curLayerSize = nextLayerSize;
            nextLayerSize = 0;
            for (int i = 0; i < curLayerSize; i++) {
                for (int j = 0; j < edges[curLayer[i]].length; j++) {
                    if (!visited[edges[curLayer[i]][j]]) {
                        nextLayer[nextLayerSize++] = edges[curLayer[i]][j];
                        visited[edges[curLayer[i]][j]] = true;
                        ans[edges[curLayer[i]][j]] = dist;
                    }
                }
            }
        }

        int secondFarthest = curLayer[0];

        curLayerSize = 0;
        nextLayerSize = 1;
        nextLayer[0] = secondFarthest;
        Arrays.fill(visited, false);
        visited[secondFarthest] = true;
        dist = 0;
        while (nextLayerSize > 0) {
            dist++;
            System.arraycopy(nextLayer, 0, curLayer, 0, nextLayerSize);
            curLayerSize = nextLayerSize;
            nextLayerSize = 0;
            for (int i = 0; i < curLayerSize; i++) {
                for (int j = 0; j < edges[curLayer[i]].length; j++) {
                    if (!visited[edges[curLayer[i]][j]]) {
                        nextLayer[nextLayerSize++] = edges[curLayer[i]][j];
                        visited[edges[curLayer[i]][j]] = true;
                        ans[edges[curLayer[i]][j]] = Math.max(ans[edges[curLayer[i]][j]], dist);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            out.println(ans[i]);
        }
    }
    int n;
    int ans[];

    /////////////////////////////////////////

    boolean trackTime = true;

    int JIT = 1000;

    int mod = 1000_000_007;

    @Override
    public void run() {
        try {
            if (ONLINE_JUDGE || !new File("input.txt").exists()) {
                reader = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            } else {
                reader = new BufferedReader(new FileReader("input.txt"));
                out = new PrintWriter("output.txt");
            }
            long time = 0;
            if (trackTime) {
                time = System.currentTimeMillis();
            }
            solve();
            if (trackTime) {
                System.err.println("time = " + (System.currentTimeMillis() - time));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                // nothing
            }
            out.close();
        }
    }

    private String readString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    @SuppressWarnings("unused")
    private int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    @SuppressWarnings("unused")
    private long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    @SuppressWarnings("unused")
    private double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    private PrintWriter out;

    public static void main(String[] args) {
        new Thread(null, new entry_2424280(), "", 256 * (1L << 20)).start();
    }

}