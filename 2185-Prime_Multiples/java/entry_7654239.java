import java.io.*;
import java.util.*;

public class entry_7654239 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        long max = Long.parseLong(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] nums = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }
        long total = 0;
        for(long i = 1; i < (1<<n); i++){
            long div = 1;
            for(long j = 0; j < n; j++){
                if ((i & (1 << j)) > 0) {
                    if(div > max / nums[(int)j]){
                        div = max + 1;
                        break;
                    }
                    div *= nums[(int)j];
                }
            }
            if(Integer.bitCount((int)i) % 2 == 1){
                total += max / div;
            } else {
                total -= max / div;
            }
        }
        pw.println(total);
        pw.close();
    }
}