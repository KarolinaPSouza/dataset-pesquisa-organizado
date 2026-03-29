import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class entry_8803235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] cost = new int[n];
        int[] pages = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pages[i] = Integer.parseInt(st.nextToken());
        }

        int[] bag = new int[x + 1];
        for (int i=0; i<n; i++) {
            for (int j=x; j>=cost[i]; j--) {
                bag[j] = Math.max(bag[j], bag[j-cost[i]] + pages[i]);
            }
        }

        System.out.println(bag[x]);
    }
}