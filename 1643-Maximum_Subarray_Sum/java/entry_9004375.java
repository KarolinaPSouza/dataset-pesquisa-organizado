import java.util.*;
import java.io.*;
import java.lang.*;
public class entry_9004375 {
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    StringTokenizer st = new StringTokenizer(sc.nextLine());
    long[] arr = new long[n+1];
    Arrays.fill(arr, 0);
    //System.out.println(st.toString());
    for(int i = 1; i <= n; i++){
      String x = st.nextToken();
      arr[i] = arr[i-1] + Long.parseLong(x);
    }
    long max = arr[1];
    long min = 0;

    for(int i = 1; i <= n; i++){
      if(max<arr[i]-min){
        max = arr[i]-min;
      }
      if(arr[i]<min){
        min=arr[i];
      }
    }
    System.out.print(max);
  }
}
