import java.io.*;
import java.util.*;

public class entry_2249544 implements Runnable {

    public void solve() throws IOException  {
        int n = readInt();
        int m = readInt();
        int k = readInt();
        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            a.add(readInt());
        }
        for (int i = 0; i < m; i++) {
            b.add(readInt());
        }

        int result = 0;
        while (!a.isEmpty() && !b.isEmpty()) {

            if (a.peek() > b.peek() + k) {
                b.poll();
                continue;
            }
            if (a.peek() < b.peek() - k) {
                a.poll();
                continue;
            }
            result++;
            a.poll();
            b.poll();
        }

        out.println(result);
    }


    /////////////////////////////////////////

    boolean trackTime = false;

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
                out.println("time = " + (System.currentTimeMillis() - time));
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
        new Thread(null, new entry_2249544(), "", 256 * (1L << 20)).start();
    }

}