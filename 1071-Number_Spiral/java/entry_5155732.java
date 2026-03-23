import java.io.*;

public class entry_5155732 {
    public static long numberSpiral(long r, long c) {
        if (c > r) {
            if (c % 2 == 0) {
                return(((c - 1) * (c - 1)) + 1 + (r - 1));
            } else
                return(((c) * (c)) - (r - 1));
        } else {
            if(r % 2 == 0){
                return(((r) * (r)) - (c - 1));
            } else
                return(((r - 1) * (r - 1)) + 1 + (c - 1));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());
        for (long t = 0; t < T; t++) {
            String s[] = br.readLine().split(" ");
            long r = Long.parseLong(s[0]);
            long c = Long.parseLong(s[1]);
            long ans = numberSpiral(r, c);
            System.out.println(ans);
        }
    }
}