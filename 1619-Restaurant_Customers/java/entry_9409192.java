import java.io.*;
import java.util.*;
import java.math.*;
public class entry_9409192 {
    public static void main(String[] args)
    {
        FastReader sc = new FastReader();
        int n=sc.nextInt();
        int[] arr=new int[n];
        int[] dep=new int[n];
        for(int i=0;i<n;i++) {
          arr[i]=sc.nextInt();
          dep[i]=sc.nextInt();
        }
        ruffSort(arr);
        ruffSort(dep);
        int max=0, ind=0;
        for(int i=0;i<n;++i) {
          //not considering arr=dep
          while(n>ind && arr[i]>=dep[ind]) ind++;
          max=Math.max(max, i-ind+1);
        }
        System.out.println(max);
    }
    static void ruffSort(int[] arr) {
      Random rn=new Random();
      int n=arr.length;
      for(int i=0;i<n;++i) {
        int ind=rn.nextInt(n);
        int temp=arr[ind];
        arr[ind]=arr[i];
        arr[i]=temp;
      }
      Arrays.sort(arr);
    }
    static class FastReader 
    { 
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) 
            {
                try 
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        }

        long nextLong()
        { 
            return Long.parseLong(next()); 
        }

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
            return (str);
        }
    }
}