import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class entry_1731943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long pref[] = new long[n+1];
        long min = 0;
        long ans = Long.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++)
        {
            long a = Long.parseLong(st.nextToken());
            pref[i] = pref[i-1]+a;
            ans = Math.max(pref[i]-min, ans);
            min = Math.min(pref[i], min);
        }
        bw.write(ans+"\n");
        bw.flush();
    }
}