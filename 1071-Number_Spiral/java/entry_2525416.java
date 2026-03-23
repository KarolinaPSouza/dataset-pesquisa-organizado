import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
import java.util.*;
import java.io.*;
import java.math.*;

public class entry_2525416 {
 public static void main(String[] args) throws Exception{
  BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
  BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
  StringTokenizer st = new StringTokenizer(infile.readLine());
  int n = Integer.parseInt(st.nextToken());

  while(n-- >0){   

   //second line int []
   long[] arr = readArr(2, infile, st);
   output.write(Long.toString(solve(arr[0], arr[1])) + "\n");   
  }
  output.flush();
 }

 public static long solve(long x, long y){
  long z = max(x, y);
  long z2 = z*z;

  if (z % 2 == 0) {
   if (z == x) {
    return z2 - y + 1;    
   } else {
    return (y-1) * (y-1) + x;
   }  
  } else {
   if (z == x) {
    long a = (x-1) * (x-1);
    return a + y;
   } else {
    long b = (y-1) * (y-1);
    return b + y + (y-x);
   }
  }  
 }

 public static long[] readArr(int n, BufferedReader infile, StringTokenizer st) throws Exception{
  long[] arr = new long[n];
  st = new StringTokenizer(infile.readLine());
  for(int i=0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        return arr;
 }
}

/*
Common Mistakes:
- integer overflow -> check boundaries of input values
- String comparison with "equals" and not with "=="
- Using System.out.println() for large strings (TLE) -> use buffered writer for faster output
 */