import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

class FastReader {
    private InputStream is = System.in;
    private byte[] inbuf = new byte[1 << 16]; // 64KB Buffer
    private int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b));
        return b;
    }

    public String next() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    public int nextInt() {
        int c = skip();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = readByte();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            res = res * 10 + c - '0';
            c = readByte();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long nextLong() {
        int c = skip();
        long sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = readByte();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            res = res * 10 + c - '0';
            c = readByte();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}
public class entry_16076486 {
    public static void dfs(char grid[][],int m,int n,int i,int j){
        if(i<0 || j<0 || i==m || j==n || grid[i][j]=='#')
            return;
        grid[i][j]='#';
        dfs(grid,m,n,i+1,j);
        dfs(grid,m,n,i-1,j);
        dfs(grid,m,n,i,j+1);
        dfs(grid,m,n,i,j-1);
    }
    public static void main(String[] args){
        FastReader ip=new FastReader();
        int m=ip.nextInt(),n=ip.nextInt();
        char grid[][]=new char[m][n];
        for(int i=0;i<m;i++){
            String s=ip.next();
            for(int j=0;j<n;j++){
                grid[i][j]=s.charAt(j);
            }
        }

        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='.'){
                    c++;
                    dfs(grid,m,n,i,j);
                }
            }
        }
        System.out.println(c);
    }
}