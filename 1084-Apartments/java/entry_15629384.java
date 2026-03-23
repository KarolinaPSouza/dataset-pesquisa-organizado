//package searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class entry_15629384 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] mnk = br.readLine().split(" ");
            int m = Integer.parseInt(mnk[0]) , n = Integer.parseInt(mnk[1]),
            k = Integer.parseInt(mnk[2]);
            String[] apts = br.readLine().split(" ");
            int[] apartments = new int[m];
            for(int i = 0; i<m ; i++) {
                apartments[i] = Integer.parseInt(apts[i]);
            }
            String[] aplc = br.readLine().split(" ");
            int[] applicants = new int[n];
            for(int i = 0; i<n ; i++) {
                applicants[i] = Integer.parseInt(aplc[i]);
            }
            System.out.println(gotHomes(apartments,applicants,m,n,k));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int gotHomes(int[] apts, int[] aplcs, int m, int n, int k) {
        Arrays.sort(aplcs);
        Arrays.sort(apts);
        int res = 0;
        int flatIndex = 0, aplcIndex = 0;
        while(aplcIndex < n && flatIndex < m) {
            if(Math.abs(aplcs[aplcIndex]-apts[flatIndex]) <= k) {
                res++;
                aplcIndex++;
                flatIndex++;
            } else if(apts[flatIndex] < aplcs[aplcIndex]-k) {
                flatIndex++;
            } else if (apts[flatIndex] > aplcs[aplcIndex]+k) {
                aplcIndex++;
            }
        }
        return res;
    }
}