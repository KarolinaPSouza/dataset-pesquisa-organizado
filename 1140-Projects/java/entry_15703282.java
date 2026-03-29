import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

public class entry_15703282 {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n=fs.nextInt();
        ArrayList<ArrayList<Integer>> arr  = new ArrayList<>(); // {start ,end ,profit}
        for(int i=0;i<n;i++){
            ArrayList<Integer> project = new ArrayList<>();
            project.add(fs.nextInt());
            project.add(fs.nextInt());
            project.add(fs.nextInt());
            arr.add(project);
        }

        Collections.sort(arr,(a,b)->a.get(1)-b.get(1));
        long[] dp = new long[n];
        dp[0]=arr.get(0).get(2);
        for(int i=1;i<n;i++){

            int l=0,r=i-1;
            ArrayList<Integer> currProject = arr.get(i);
            int p=-1;
            while(l<=r){
                int mid=(l+r)/2;
                ArrayList<Integer> midProject = arr.get(mid);
                if(currProject.get(0)>midProject.get(1)){
                    p=mid;
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
            long lastEligibleProjit = p==-1?0:dp[p];
            dp[i]=Math.max(dp[i-1],lastEligibleProjit+currProject.get(2));
        }
        System.out.println(dp[n-1]);
    }

}



class FastScanner {
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1 << 16];
    private int ptr = 0, len = 0;

    private int read() throws IOException {
        if (ptr >= len) {
            len = in.read(buffer);
            ptr = 0;
            if (len <= 0) return -1;
        }
        return buffer[ptr++];
    }

    private int skip() throws IOException {
        int c = read();
        while (c != -1 && c <= ' ') c = read();
        return c;
    }

    // -------------------------------
    // Integer
    // -------------------------------
    public int nextInt() throws IOException {
        int c = skip();
        if (c == -1) return 0;

        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }

        int val = 0;
        while (c > ' ') {
            val = val * 10 + (c - '0');
            c = read();
        }

        return val * sign;
    }

    // -------------------------------
    // Long
    // -------------------------------
    public long nextLong() throws IOException {
        int c = skip();
        if (c == -1) return 0;

        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }

        long val = 0;
        while (c > ' ') {
            val = val * 10 + (c - '0');
            c = read();
        }

        return val * sign;
    }

    // -------------------------------
    // String (token)
    // -------------------------------
    public String next() throws IOException {
        int c = skip();
        if (c == -1) return null;

        StringBuilder sb = new StringBuilder();
        while (c > ' ') {
            sb.append((char)c);
            c = read();
        }
        return sb.toString();
    }

    // -------------------------------
    // Next Line
    // -------------------------------
    public String nextLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c = read();

        // consume previous newline if needed
        if (c == '\n') c = read();

        while (c != -1 && c != '\n') {
            sb.append((char)c);
            c = read();
        }

        return sb.toString();
    }

    // -------------------------------
    // Double
    // -------------------------------
    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}