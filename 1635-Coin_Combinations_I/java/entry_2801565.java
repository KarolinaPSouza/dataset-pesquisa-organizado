//package cses;

import java.io.*;
import java.util.*;

public class entry_2801565 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken());
        int[] min = new int[x+1];
        int[] coins = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            coins[i] = Integer.parseInt(st.nextToken());
            if(coins[i] < min.length) min[coins[i]] = 1;
        }

        for(int index=1; index<=x; index++){
            for(int i=0; i<coins.length; i++){
                if(index-coins[i] > 0) min[index] += min[index-coins[i]];
                min[index] %= 1000000007;
            }
        }

        System.out.println(min[x]);

    }

}