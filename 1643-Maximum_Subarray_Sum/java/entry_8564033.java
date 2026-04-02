import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_8564033 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        long cur = 0;
        long res = Long.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 0; i < n; i++)
        {
            long thing = Long.parseLong(st.nextToken());
            cur = Math.max(cur + thing, thing);
            res = Math.max(cur, res);
        }
        System.out.println(res);
    }
}