import java.util.*;
import java.io.*;
public class entry_8445420 {
   public static void main(String[] args) throws IOException
   {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int a = Integer.parseInt(st.nextToken());
       st=new StringTokenizer(br.readLine());
       long sum=0;
       long max=Long.MIN_VALUE;
       while(a-->0)
       {
          long b=Integer.parseInt(st.nextToken());
          sum+=b;
          max=Math.max(sum,max);
          if(sum<0) sum=0;
       }
       System.out.println(max);
   }
}

