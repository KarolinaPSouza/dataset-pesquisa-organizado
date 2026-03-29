import java.util.*;
import java.io.*;

public class entry_744627 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
        int[] h = new int[n];
        int[] s = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            h[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            s[i] = Integer.parseInt(st.nextToken());

        int[] knapsack = new int[x+1];
        for(int i = 0; i < n; i++) {
            for (int w = x; w > -1; w--)
                if(w-h[i] > -1)
                    knapsack[w] = Math.max(knapsack[w], knapsack[w - h[i]] + s[i]);
        }

        System.out.println(knapsack[x]);

    }

}