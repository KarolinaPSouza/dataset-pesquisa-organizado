import java.io.*;
import java.util.*;

public class entry_14424162 {
        static final int MOD = 1_000_000_007;

    static class FastReader {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() {
            if (ptr >= len) {
                try {
                    len = in.read(buffer);
                    ptr = 0;
                } catch (IOException e) {
                    return -1;
                }
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String nextLine() {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = readByte()) != -1) {
                if (c == '\n' || c == '\r') continue;
                sb.append((char)c);
                break;
            }
            while ((c = readByte()) != -1 && c != '\n' && c != '\r') {
                sb.append((char)c);
            }
            return sb.toString();
        }

        int nextInt() {
            int c, sign = 1, val = 0;
            do { c = readByte(); } while (c <= ' ');
            if (c == '-') { sign = -1; c = readByte(); }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        solve(fr, out);
        out.flush();
    }
    static int n;
    static int m;
    static int vis[][];
    static char grid[][];
    static void solve(FastReader fr, PrintWriter out) {
        n = fr.nextInt();
        m = fr.nextInt();
        grid = new char[n][m];
        for(int i=0;i<n;i++){
            String curr = fr.nextLine();
            grid[i] = curr.toCharArray();
        }
        int ct =0;
        vis = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == '#'){
                    vis[i][j] = 1;
                }else{
                    if(vis[i][j] == 1)continue;
                    vis[i][j] =1 ;
                    solve(i,j);
                    ct++;
                }
            }
        }
        System.out.println( ct );

    }
    static int dx[] = {0,-1,0,1};
    static int dy[] = {1,0,-1,0};
    static void solve(int x1,int y1){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x1,y1});
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int x = curr[0];
            int y = curr[1];
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<m&& grid[nx][ny] == '.' && vis[nx][ny]!=1){
                    vis[nx][ny] = 1;
                    q.add(new int[]{nx,ny});
                }
            }
        }

    }
}