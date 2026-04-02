import java.io.IOException;
import java.io.InputStream;


public class entry_15779267 {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() {
            StringBuilder sb = new StringBuilder();
            int c;
            try {
                while ((c = readByte()) <= ' ') {
                    if (c == -1) return null;
                }
                while (c > ' ') {
                    sb.append((char) c);
                    c = readByte();
                }
            } catch (IOException e) {
                return null;
            }
            return sb.toString();
        }
    }
    public static void main(String [] args){
        FastScanner sc=new FastScanner();

        String s1=sc.next();
        String s2=sc.next();

        int n=s1.length();
        int m=s2.length();

        int dp[][]=new int [n+1][m+1];

        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];

                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }    

            }
        }

        System.out.println(dp[n][m]);


    }

}