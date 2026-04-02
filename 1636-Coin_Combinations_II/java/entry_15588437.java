import java.io.*;
import java.util.*;

public class entry_15588437 {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] currentLine = new int[n + 1];
        int[] nextLine = new int[n+1];
        currentLine[0] = 1;
        nextLine[0] = 1;

        for(int i=m-1;i>=0;i--){
            for(int j=1;j<=n;j++){
                currentLine[j] = ((arr[i]<=j?currentLine[j-arr[i]]:0) + nextLine[j])%mod ;
            }
            nextLine = currentLine;
        }
       System.out.println(currentLine[n]);
    }
    static int mod = 1000000007;
}