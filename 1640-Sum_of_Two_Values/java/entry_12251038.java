import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
import java.io.*;


public class entry_12251038{
 public static void main(String[] args) throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);

  StringTokenizer st = new StringTokenizer(br.readLine());

  //Scanner sc = new Scanner(System.in);
  int n = Integer.parseInt(st.nextToken());
  int x = Integer.parseInt(st.nextToken());

  st = new StringTokenizer(br.readLine());
  Map<Integer, Integer> h = new HashMap<>();
  //boolean found = false;
  for (int i = 0; i<n; i++){
   int v = Integer.parseInt(st.nextToken());
   if (h.containsKey(x-v)){

    pw.print(String.valueOf(i+1)+ " "+ String.valueOf(h.get(x-v)));
    pw.close();
    //found = true;
    return;
   }

   h.put(v,i+1);

  }
  pw.print("IMPOSSIBLE");
  pw.close();
 }
}

