import java.io.*;
import java.util.*;

public class entry_10433617 {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer z = new StringTokenizer(b.readLine());

        int a = Integer.parseInt(z.nextToken());
        int x = Integer.parseInt(z.nextToken());

        int[][] y = new int[a][2];

        z = new StringTokenizer(b.readLine());
        for (int i = 0; i < a; i++) {
            y[i][0] = Integer.parseInt(z.nextToken());
            y[i][1] = i + 1;
        }

        int[][] c = new int[a][2];
        for (int d = 1; d < a; d *= 2) {
            for (int e = 0; e < a; e += 2 * d) {
                int f = Math.min(e + d, a);
                int g = Math.min(e + 2 * d, a);
                int h = e, i = f, j = e;
                while (h < f && i < g) {
                    if (y[h][0] <= y[i][0]) {
                        c[j][0] = y[h][0];
                        c[j++][1] = y[h++][1];
                    } else {
                        c[j][0] = y[i][0];
                        c[j++][1] = y[i++][1];
                    }
                }
                while (h < f) {
                    c[j][0] = y[h][0];
                    c[j++][1] = y[h++][1];
                }
                while (i < g) {
                    c[j][0] = y[i][0];
                    c[j++][1] = y[i++][1];
                }
            }
            int[][] t = y;
            y = c;
            c = t;
        }

        int l = 0, r = a - 1;
        while (l < r) {
            int s = y[l][0] + y[r][0];
            if (s == x) {
                System.out.println(y[l][1] + " " + y[r][1]);
                return;
            } else if (s < x) {
                l++;
            } else {
                r--;
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}