import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
public class entry_5086713 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] coins = new int[n];
            long[] numofcoins = new long[x+1];
            Arrays.fill(numofcoins, Integer.MAX_VALUE);

            for (int i = 0; i<n; i++){
                coins[i] = sc.nextInt();
            }
            numofcoins[0] = 0;
            for (int i = 1; i<=x; i++){
                for (int j = 0; j<n; j++){
                    if (i-coins[j]>=0){
                        numofcoins[i] = Math.min(numofcoins[i], numofcoins[i-coins[j]]+1);
                    }
                }
            }
            System.out.println(numofcoins[x]==Integer.MAX_VALUE?-1:numofcoins[x]);
    }
}
