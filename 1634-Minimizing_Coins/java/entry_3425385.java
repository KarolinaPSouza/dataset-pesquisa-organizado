import java.io.*;
import java.util.*;
public class entry_3425385
{
 public static void main(String[] args){
  FastReader fs = new FastReader();
  int no_of_coins = fs.nextInt();
  int x = fs.nextInt();
  int[] coins = new int[no_of_coins];
  for(int i=0;i<no_of_coins;i++){
   coins[i] = fs.nextInt();
  }
//  System.out.println(recursion(coins,x)-1);
  int[] DP = new int[x+1];
  DP[0] = 1;
  for(int i=1;i<=x;i++){
   int max = Integer.MAX_VALUE;
   for(int J : coins){
    if(i-J<0) continue;
    if(DP[i-J]>0){
     if(DP[i-J]<max)
      max = DP[i-J]+1;
    }
   }
   DP[i] += max;
  }
  System.out.println(DP[x]==Integer.MAX_VALUE?-1:DP[x]-1);
 }
 /*
 Recursive way of solution
 */
 private static int recursion(int[] coins, int n){
  if(n==0) return 1;
  else if(n<0) return 0;
  else{
   ArrayList<Integer> arr = new ArrayList<>();
   for(int J : coins){
    int sum = recursion(coins,n-J);
    if(sum>0) arr.add(1+sum);
   }
   return arr.size()>0?Collections.min(arr):0;
  }
 }
 static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
