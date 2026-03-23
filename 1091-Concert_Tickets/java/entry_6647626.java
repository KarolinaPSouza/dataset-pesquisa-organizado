import java.io.*;
import java.util.TreeSet;

public class entry_6647626 {
    static InputStream in = new BufferedInputStream(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int nextInt() throws IOException{
        int ret = 0, c;
        while (!Character.isDigit(c = in.read()));
        do {
            ret = ret * 10 + c - '0';
        } while (Character.isDigit(c = in.read()));
        return ret;
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt(), m = nextInt();
        TreeSet<int[]> tickets = new TreeSet<>((a, b) ->
            a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        );
        for (int i = 0; i < n; i++) {
            tickets.add(new int[]{nextInt(), i});
        }
        for (int i = 0; i < m; i++) {
            int[] h = tickets.floor(new int[]{nextInt(), n});
            if (h == null) out.println(-1);
            else {
                tickets.remove(h);
                out.println(h[0]);
            }
        }
        out.close();
    }
}
