import java.io.BufferedReader;import java.io.DataInputStream;import java.io.File;import java.io.FileInputStream;import java.io.FileNotFoundException;import java.io.FileWriter;import java.io.IOException;import java.io.InputStreamReader;import java.util.*;import java.util.*;

public class entry_14904541 {
   //static FastReader sc = new FastReader();
   static int modulo = (int)Math.pow(10,9)+7;


   public static void main(String[] args)  {

      FastScanner sc = new FastScanner();
      int tests=1;

      for(int test=0;test<tests;test++) 
      {
        int n=sc.nextInt();
        int sum= sc.nextInt();

        int arr[] = new int[n];

        for(int i=0;i<n;i++)arr[i]=sc.nextInt();
        //Arrays.sort(arr);

        long waysToMakeSum[] = new long[sum+1];
        waysToMakeSum[0]=1;

        for(int i=1;i<=sum;i++) 
        {
           for(int j: arr)
           {
               if(i>=j)waysToMakeSum[i]+=waysToMakeSum[i-j];
           }

           waysToMakeSum[i]%=modulo;
        }
       // System.out.println(Arrays.toString(waysToMakeSum));


        System.out.println(waysToMakeSum[sum]);
      }
    }

 static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

} 



  /**   template to increase stack size
     * class Main implements Runnable {
 static void main(...){
  new Thread(null, new Main(), "Main", 1<<28).start();
 }
  public void run() {
  // your code here
 }
}
     */