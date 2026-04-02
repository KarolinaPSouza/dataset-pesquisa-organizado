/***
 *    ██████╗=====███████╗====███████╗====██████╗=
 *    ██╔══██╗====██╔════╝====██╔════╝====██╔══██╗
 *    ██║==██║====█████╗======█████╗======██████╔╝
 *    ██║==██║====██╔══╝======██╔══╝======██╔═══╝=
 *    ██████╔╝====███████╗====███████╗====██║=====
 *    ╚═════╝=====╚══════╝====╚══════╝====╚═╝=====
 *    ============================================
 */


import java.io.*;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.util.*;
import java.math.*;
import java.lang.*;

public class entry_635777 implements Runnable {
    public void run() {
        InputReader sc = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        int i=0,j=0,k=0;
        int t=0;
        //t=sc.nextInt();
        for(int testcase = 0;testcase < t; testcase++)
        {

        }


        long n=sc.nextLong();
        long arr[]=new long[(int) n];
        for (i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        long sum=0;
        long max=Integer.MIN_VALUE;
        for (i=0;i<n;i++)
        {
            sum+=arr[i];
            max=Math.max(Math.max(sum,arr[i]),max);
            sum=Math.max(sum,0);
        }
        out.println(max);






























//================================================================================================================================
        out.flush();
        out.close();
    }

//================================================================================================================================
public static int[] sa(int n,InputReader sc)
{
    int inparr[]=new int[n];
    for (int i=0;i<n;i++)
        inparr[i]=sc.nextInt();
    return inparr;
}

    public static long gcd(long a,long b){
        return (a%b==0l)?b:gcd(b,a%b);
    }
    private static long lcm(long a, long b)
    {
        return a * (b / gcd(a, b));
    }
    public int egcd(int a, int b) {
        if (a == 0)
            return b;

        while (b != 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }

        return a;
    }



    public int countChar(String str, char c)
    {
        int temp = 0;
        for(int i=0; i < str.length(); i++)
        {    if(str.charAt(i) == c)
            temp++;
        }
        return temp;
    }
    static int binSearch(Integer[] inparr, int number){
        int left=0,right=inparr.length-1,mid=(left+right)/2,ind=0;
        while(left<=right){
            if(inparr[mid]<=number){
                ind=mid+1;
                left=mid+1;
            }
            else
                right=mid-1;
            mid=(left+right)/2;
        }
        return ind;
    }
    static int binSearch(int[] inparr, int number){
        int left=0,right=inparr.length-1,mid=(left+right)/2,ind=0;
        while(left<=right){
            if(inparr[mid]<=number){
                ind=mid+1;
                left=mid+1;
            }
            else
                right=mid-1;
            mid=(left+right)/2;
        }
        return ind;
    }
    static class Pair
    {
        int a,b;
        Pair(int aa,int bb)
        {
            a=aa;
            b=bb;
        }
        String get()
        {
            return a+" "+b;
        }
        String getrev()
        {
            return b+" "+a;
        }
    }

    static boolean isPrime(long n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }
    static long factorial(long n)
    {
        if (n == 0)
            return 1;
        return n*factorial(n-1);
    }
//================================================================================================================================

    static class InputReader
    {
        BufferedReader br;
        StringTokenizer st;

        public InputReader()
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
    }

    public static void main(String args[]) throws Exception {
        new Thread(null, new entry_635777(),"Main",1<<27).start();
    }
}