import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class entry_13767906 {

    public static void main(String[] args) throws IOException {

        BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter o = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st;


  st = new StringTokenizer(x.readLine());

  int nc = Integer.parseInt(st.nextToken());
  int v = Integer.parseInt(st.nextToken());

  long[] dp = new long[v+1];
  int[] c = new int[nc];

  st = new StringTokenizer(x.readLine());

  for(int i = 0;i<nc;i++) {
   c[i] = Integer.parseInt(st.nextToken());
  }

  dp[0] = 1;

  for(int j : c) {
   for(int i = 1;i<=v;i++) {

    if(i-j>=0) {

     //dp[i]+=dp[i-j]; 
     dp[i] = (dp[i-j]+dp[i])%1000000007;

     //dp[i]++;
    }       
   }
  }

//  for(int i = 0;i<=v;i++) {
//   System.out.println(i+" = "+dp[i]);
//  }

  o.print(dp[v]);


  o.flush();

    }
}