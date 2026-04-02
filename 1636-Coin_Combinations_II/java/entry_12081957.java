import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class entry_12081957 {

    static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) throws IOException {
        // Using BufferedReader and StringTokenizer for fast input.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coins);

        System.out.println(DisOrderWaysTab(n,0,x, coins));

    }


    static int DisOrderWays(int n, int index, int x, int []coins) {

        if(x==0) {
            return 1;
        }

        if(n<0) return 0;

        int cnt = 0;
        for(int i = index;i<n;i++) {

            if(i>index && coins[i]==coins[i-1]) continue;

            if(x>=coins[i]) {
                cnt+= DisOrderWays(n,i,x-coins[i],coins);
            } else {
                cnt+= DisOrderWays(n, i + 1, x, coins);
            }

        }

        return cnt;

    }


    static int DisOrderWaysTab(int n, int index, int x, int []coins) {

        int state[] = new int[x+1];

        state[0] = 1;

        for(int i = 0;i<n;i++) {

            for(int j = coins[i];j<=x;j++) {

                if(coins[i]>j) {
                    break;
                } else {
                    state[j]= (state[j] + state[j-coins[i]])%MOD;
                }
            }
        }

        return state[x];

    }

}