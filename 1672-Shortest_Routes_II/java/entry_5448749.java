import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class BufferedScanner {

    StringTokenizer st;
    BufferedReader br;

    public BufferedScanner(FileReader r) {
        br = new BufferedReader(r);
    }

    public BufferedScanner(InputStream s) {
        br = new BufferedReader(new InputStreamReader(s));
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }
}

public class entry_5448749 {

    public static void main(String[] arg) throws IOException {

        BufferedScanner scan = new BufferedScanner(System.in);
        int a1 = Integer.parseInt(scan.next());
        int b1 = Integer.parseInt(scan.next());
        int c1 = Integer.parseInt(scan.next());
        long[][] g1 = new long[a1 + 1][a1 + 1];
        long max = 0x3f3f3f3f3f3f3f3fL;

        for (int i = 0; i < a1 + 1; i++) {
            for (int j = 0; j < g1[i].length; j++) {
                g1[i][j] = max;
            }
            g1[i][i] = 0;
        }

        for (int i = 0; i < b1; i++) {
            int a = Integer.parseInt(scan.next());
            int b = Integer.parseInt(scan.next());
            int c = Integer.parseInt(scan.next());
            if (g1[a][b] > c) {
                g1[a][b] = c;
            }
            g1[b][a] = g1[a][b];
        }

        for (int k = a1; k > 0; k--) {
            for (int i = a1; i > 0; i--) {
                for (int j = a1; j > i; j--) {
                    if (g1[i][j] > g1[i][k] + g1[k][j]) {
                        g1[i][j] = g1[i][k] + g1[k][j];
                    }
                    g1[j][i] = g1[i][j];
                }
            }
        }

        PrintWriter pw = new PrintWriter(System.out);
        for (int i = 0; i < c1; i++) {
            int a = Integer.parseInt(scan.next());
            int b = Integer.parseInt(scan.next());
            pw.println(g1[a][b] == max ? -1 : g1[a][b]);
        }
        pw.close();
    }
}