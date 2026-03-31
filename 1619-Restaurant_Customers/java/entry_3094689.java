import java.util.*;
import java.io.*;
import static java.lang.System.out;
import java.util.Stack;
import java.util.Queue;

public class entry_3094689 {

    static int mod=(int)(1e9+7);
    static long MOD=(long)(1e9+7);
    static FastReader in=new FastReader();
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String args[])
    {  

        int tc=1;

       // tc=in.nextInt();
        tcloop: while(tc-->0)
        {

            int n=in.nextInt();
            List<Pair> al = new ArrayList<>();

            for(int i =0;i<n;i++){
                int a=in.nextInt();
                int b=in.nextInt();
                al.add(new Pair(a,1));
                al.add(new Pair(b,-1));

            }
            Collections.sort(al);

            int max=0;
            int curr=0;
            for(Pair p : al){
                curr+=p.b;
                max = Math.max(max, curr);
            }
            pr.println(max);




        }
        pr.flush();

    }

 static long gcd(long a,long b)
 {
  if(a==0)return b;
  return gcd(b%a,a);
 }

    static class Pair implements Comparable<Pair>
    {
        int a,b;
        Pair(int a,int b)
        {
            this.a=a;
            this.b=b;

        }

        @Override
        public int compareTo(Pair o)
        {
            return Integer.compare(a,o.a);
        }
    }



    static void sort(long[] a) {
  ArrayList<Long> l = new ArrayList<>();
  for (long i : a)
   l.add(i);
  Collections.sort(l);
  for (int i = 0; i < a.length; i++)
   a[i] = l.get(i);
 }


 static void sort(int[] a) {
  ArrayList<Integer> l = new ArrayList<>();
  for (int i : a)
   l.add(i);
  Collections.sort(l);
  for (int i = 0; i < a.length; i++)
   a[i] = l.get(i);
    }


    static class FastReader
    { 
        BufferedReader br; 
        StringTokenizer st; 

        public FastReader() 
        { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 

        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
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

        int[] readIntArray(int n)
        {
  int a[]=new int[n];
  for(int i=0;i<n;i++)a[i]=nextInt();
  return a;
 }

 long[] readLongArray(int n)
 {
  long a[]=new long[n];
  for(int i=0;i<n;i++)a[i]=nextLong();
  return a;
 }

        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
}


