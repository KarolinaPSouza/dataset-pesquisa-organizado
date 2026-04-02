import java.io.*;
import java.util.*;
public class entry_4769213{
 public static void main(String[] args) throws Exception{
  // try{
  //    System.setIn(new FileInputStream("input.txt"));
  //    System.setOut(new PrintStream(new FileOutputStream("out.txt")));
  //   }catch(Exception e){
  //    System.out.println("Error");
  //   }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i=0;i<n;i++)
     arr[i] = Integer.parseInt(st.nextToken());

    long ans = Integer.MIN_VALUE;
    long sum = 0;
    for(int i=0;i<n;i++){
     sum += arr[i];
     if(ans<sum)
      ans = sum;
     if(sum<0)
      sum = 0;
    }
    System.out.print(ans+"\n");
 }
}
