import java.util.*;
import java.io.*;

public class entry_4745434 {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
  private final BufferedWriter bw;

  public FastWriter() {
   this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public void print(Object object) throws IOException {
   bw.append("" + object);
  }

  public void println(Object object) throws IOException {
   print(object);
   bw.append("\n");
  }

  public void close() throws IOException {
   bw.close();
  }
 }
public static int m =  (1000000000)+7;


    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
          //  int testCases=in.nextInt();
          //  while(testCases-- > 0){
                // write code here
            int n = in.nextInt();
            int x = in.nextInt();
            int c[]=new int[n];
              for(int i = 0 ; i < n ; i++)
              {
                   c[i]=in.nextInt();
              }

            int dp[]= new int[x+1];
              dp[0]=0;
     for(int i = 1 ; i <= x ; i++)
  {
   dp[i]=Integer.MAX_VALUE;

   for(int j = 0 ; j< n ; j++)
   {
    if(i >= c[j] && dp[i-c[j]]!=Integer.MAX_VALUE)
    {
     dp[i]=Math.min(dp[i-c[j]]+1,dp[i]);
    }

   }
  }
            if(dp[x]==Integer.MAX_VALUE)
                 out.println(-1);
            else
  out.println(dp[x]); 

      //      }
            out.close();
        } catch (Exception e) {
            return;
        }
    }

}