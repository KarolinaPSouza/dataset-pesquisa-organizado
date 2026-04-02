import java.io.*;
import java.util.*;
public class entry_16018474 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        long mod = 1000000007;
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] val = new int[k];
        long[] arr = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++)
            val[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(val);
        arr[0] = 1;
        for(int j=0;j<k;j++){
            for(int i=val[j];i<=n;i++){
                arr[i] += arr[i - val[j]];
                if(arr[i]>=mod)
                    arr[i] -= mod;
            }
        }
        out.println(arr[n]);
        out.close();
    }
}