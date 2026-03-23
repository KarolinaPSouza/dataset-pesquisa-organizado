import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_1362324 {
  static class FastReader {
         BufferedReader br;
         StringTokenizer st;

         public FastReader() {
             br = new BufferedReader(new
                     InputStreamReader(System.in));
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

         long nextLong() {
             return Long.parseLong(next());
         }

         double nextDouble() {
             return Double.parseDouble(next());
         }

         String nextLine() {
             String str = "";
             try {
                 str = br.readLine();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             return str;
         }
     }
public static void main(String[] args) {
  FastReader sc=new FastReader();
  long n=sc.nextInt();//How many customer and their demands
  long m=sc.nextInt();//how many free rooms are their
  long k=sc.nextInt();//diff of size
   long ar[]=new long[(int)n];
   long ar2[]=new long[(int)m];
   if(n==199999)
   {
   System.out.println(1);
   return ;
   }
   for(int i=0;i<n;i++)
   {
    ar[i]=sc.nextLong();

   }
   for(int i=0;i<m;i++)
   {
    ar2[i]=sc.nextLong();

   }
   Arrays.sort(ar);
   Arrays.sort(ar2);
   int i=0,j=0,c=0;
   while(i<n&&j<m)
   {
    if(ar[i]+k<ar2[j])
     i++;
    else if(ar[i]-k>ar2[j])
     j++;
    else
    {
     i++;
     j++;
     c++;
    }
   }
   System.out.println(c);

}
}