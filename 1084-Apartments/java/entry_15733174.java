import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class entry_15733174 {
    public static void main(String[] args)  throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] app = new int[n];
        int[] free = new int[m];
        st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
    app[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
for (int i = 0; i < m; i++) {
    free[i] = Integer.parseInt(st.nextToken());
}
        System.out.println(result(app, free, n, m, k));
    }
    public static int result(int[] app, int[] free, int n,int m, int k){
        Arrays.sort(app);
         Arrays.sort(free);
         int i = 0;
         int j = 0;
         int ans = 0;
         while(i < n && j < m){
         if (Math.abs(app[i] - free[j]) <= k) {
   ++i;
   ++j;
   ++ans;
         }
         else if(app[i] > free[j]){
            j++;

         }
         else{
            i++;
         }
    }
    return ans;
}
}