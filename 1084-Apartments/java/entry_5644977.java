/*
 1) try passing newly created empty arrays if list/array gets 
dynamically updated while recursion (remember that tree problem?)
 2) sometimes array faster and better than arraylist
3) if finding factorial for each 'n' is taking O(n) , store the factorials in an array globally
and access later in O(1)
     long fact_arr[] = new long[1000001];
    fact_arr[0] = 1L;
     for(i=1;i<fact_arr.length;i++)
        fact_arr[i] = (fact_arr[i-1] * i) % modd;
 4) for array/string problems try
    unsort/sort :
   left to right
   right to left 
   left ----> centre <---- right
 5) IMPORTANT ->> Sometimes checking 'when it's achieving and not' is better than 'achieving and checking'
6) When not finding pattern, try to find fibonacci pattern if relevant
7) always check constraints before submitting
8) struggling with int and long? use BigInteger
9) count of odd numbers from 1 to n is (n+1)/2
 10) for 10^3 -> O(n^2)
11) for 10^5 -> O(nlogn) or O(n) (binary search, prefix sum etc)
12) for 10^8 -> O(n)
 13) SIEVE BLACKBOX LIMIT IN C++ :
{
    function limit: int arr[10^6], boolean arr[10^7]
    global limit: int arr[10^7], boolean arr[10^8]
    test case limit -> 10^6 -> normal sieve O(log(log(n))) logic
    test case limit -> 10^8 -> 
}
 14) Using null structure and left-Parent-Right marking -> unique structure string of a subtree can be found (if tree in linkedlist format)
*/

import java.util.*;
import java.io.*;
import java.lang.Math;
import java.math.BigInteger;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.pow;
import static java.lang.System.out;

class Main { // public for CF

    static long modd = 1000000007L;

    // POWER FUNCTION .........................................:

    static long power(long a, long b){

    long ans = 1L;
    while(b > 0L)
    {
    if((((b) % 2L)) == 0L)
    {
        a = ((a)*(a)) ;
        b = ((b) >> 1L);
    }
    else
    {
        ans = ((ans)*(a));
        b = ((b) - 1L) ;
    }
    }

    return (ans);
    }


    // GCD FUNCTION ............................................:

    static long gcd(long a, long b)
    {
        if (a == 0L)
            return b;

        return gcd(b % a, a);
    }


    // FACTORIAL FUNCTION ......................................: 

    static long factorial(long a)
    {
        long f = 1L;
        while(a > 1L)
        {
            f = (f*a) % modd;
            a--;
        }
        return f;
    }


    // Size of LCS FUNCTION.....................................:

    static int helper(String s1, String s2, int i, int j, int dp[][])
    {
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != 0) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + helper(s1, s2, i-1, j-1, dp);

        return dp[i][j] = Math.max(helper(s1, s2, i, j-1, dp), helper(s1, s2, i-1, j, dp));
    }

    // MAIN.................................................:

    public static void main(String[] args) throws IOException {

        // Scanner ob = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        if (System.getProperty("ONLINE_JUDGE") == null) {

            try {br = new BufferedReader(new FileReader("input.txt"));
                System.setOut(new PrintStream(new FileOutputStream("output.txt")));
                } 
            catch (Exception e) {}
        }

    // ------------------------------
    // -----START YOUR CODE HERE-----
    // ------------------------------

        int t;
        // t = ob.nextInt();
        t = 1;

        while (t-- > 0) {

            String[] in_var = br.readLine().split(" ");
            String[] in_req_sizes = br.readLine().split(" ");
            String[] in_apt_sizes = br.readLine().split(" ");

            int n = Integer.parseInt(in_var[0]);
            int m = Integer.parseInt(in_var[1]);
            int k = Integer.parseInt(in_var[2]);

            List<Integer> a = new ArrayList<>();
            List<Integer> d = new ArrayList<>();

            for (int i=0;i<n;i++)
                d.add(Integer.parseInt(in_req_sizes[i]));

            for (int j=0;j<m;j++)
                a.add(Integer.parseInt(in_apt_sizes[j]));

            Collections.sort(d);
            Collections.sort(a);
            long i = 0L;
            long j = 0L;
            long ans = 0L;

            while(i<n && j<m)
            {
                if(a.get((int)j) <= d.get((int)i) + k && a.get((int)j) >= d.get((int)i) - k)
                {
                    ans++;
                    i++;
                    j++;
                }
                else if(a.get((int)j) > d.get((int)i) + k) i++;
                else j++;
            }

            out.println(ans);
        }
    // ------------------------------
    // ------END YOUR CODE HERE------
    // ------------------------------

    }
}