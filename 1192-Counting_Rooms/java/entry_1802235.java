import java.io.*;
import java.util.*;

public class entry_1802235 {
 public static boolean[][] v;
 public static char[][] g;
 public static final int xd[] = {0,1,0,-1}, yd[] = {1,0,-1,0};
 public static int N, M;

    static class Pair{
        public int a,b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
 public static void floodfill(int i, int j) {
        Stack<Pair> sta = new Stack<Pair>();
        sta.push(new Pair(i,j));
        while(!sta.isEmpty()) {
            Pair p = sta.pop();
            i = p.a;
            j = p.b;
            if (i >= N || i< 0 || j >= M || j< 0|| g[i][j] == '#' || v[i][j]) {
                continue;
            }
            v[i][j] = true;
                for (int c = 0; c < 4; c++) {
                    sta.add(new Pair(i+xd[c],j+yd[c]));
                }

        }

    }
 public static void main(String[] args) throws IOException
 {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter out = new PrintWriter(System.out);
  StringTokenizer st = new StringTokenizer(br.readLine());
  N = Integer.parseInt(st.nextToken());
  M = Integer.parseInt(st.nextToken());
  g = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j =0; j< M; j++) {
                g[i][j] = str.charAt(j);
                }
            }
        int rooms = 0;
        v = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (g[i][j] == '.' && !v[i][j]) {
                    floodfill(i,j); 
                    rooms++;
                }
            }
        }

        out.println(rooms);
        out.close();
        }






 }
