import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class entry_6318714 {

 public static void main(String[] args) throws IOException{
  Scanner in = new Scanner(System.in);
  //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out, 1 << 16), false);

  int n = in.nextInt();
  long arr[] = new long[n];
  HashSet<Long> set = new HashSet<Long>();

  for (int i = 0; i < n; i++){
   arr[i] = in.nextLong();
  }
  for (long a: arr){
   set.add(a);
  }

  out.println(set.size());
  out.flush();
  out.close();
 }
}