import java.io.*;
import java.util.*;
/*
Given an array of n integers, your task is to find the maximum sum of values in a contiguous, nonempty subarray.
The first input line has an integer n: the size of the array.
The second line has n integers x_1,x_2,\dots,x_n: the array values.
Print one integer: the maximum subarray sum.
O(n) for time and space complexity
*/
public class entry_15998789 {
    public static void main(String[] args) {
        FastReader stdin = new FastReader();
        int n = stdin.nextInt();
        int[] values = new int[n];
        for(int i = 0; i<n; i++){
            values[i] = stdin.nextInt();
        }
        long res = maxSubSum(values);
        System.out.println(res);

    }

    public static long maxSubSum(int[] a){
        long max = Long.MIN_VALUE;
        long end = 0;
        for(int i = 0; i<a.length; i++){
            end = end + a[i];
            if(max < end) max = end;
            if(end<0) end = 0;
        }
        return max;
    }
}


// FastReader class for efficient input
class FastReader {

    // BufferedReader to read input
    BufferedReader b;

    // StringTokenizer to tokenize input
    StringTokenizer s;

    // Constructor to initialize BufferedReader
    public FastReader() {
        b = new BufferedReader(new InputStreamReader(System.in));
    }

    // Method to read the next token as a string
    String next() {
        while (s == null || !s.hasMoreElements()) {
            try {
                s = new StringTokenizer(b.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return s.nextToken();
    }

    // Method to read the next token as an integer
    int nextInt() {
        return Integer.parseInt(next());
    }

    // Method to read the next token as a long
    long nextLong() {
        return Long.parseLong(next());
    }

    // Method to read the next token as a double
    double nextDouble() {
        return Double.parseDouble(next());
    }

    // Method to read the next line as a string
    String nextLine() {
        String str = "";
        try {
            if (s.hasMoreTokens()) {
                str = s.nextToken("\n");
            } else {
                str = b.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}