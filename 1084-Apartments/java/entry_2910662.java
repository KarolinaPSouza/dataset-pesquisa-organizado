import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Custom
{
 public static void main (String[] args) throws java.lang.Exception
 {
  // your code goes here
  FastReader sc=new FastReader();
  int n=sc.nextInt();
  int m=sc.nextInt();
  int k=sc.nextInt();
  ArrayList<Integer> a=new ArrayList<>();
  ArrayList<Integer> b=new ArrayList<>();
  while(n-->0)
  {
      int x=sc.nextInt();
      a.add(x);
  }
  Collections.sort(a);
  while(m-->0)
  {
      int x=sc.nextInt();
      b.add(x);
  }
  Collections.sort(b);
  int i=0,j=0;
     int count=0;
  while(i<a.size() && j<b.size())
  {
      if(Math.abs(a.get(i)-b.get(j))<=k)
      {
          i++;
          j++;
          count++;
      }
      else if(a.get(i)>b.get(j))
      {
          j++;
      }
      else
      {
          i++;
      }
  }
  System.out.println(count);
 }

 static class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new
        InputStreamReader(System.in));
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

    int [] readintarray(int n) {
        int res [] = new int [n];
        for(int i = 0; i<n; i++)res[i] = nextInt();
        return res;
    }
    long [] readlongarray(int n) {
        long res [] = new long [n];
        for(int i = 0; i<n; i++)res[i] = nextLong();
        return res;
    }
}
}