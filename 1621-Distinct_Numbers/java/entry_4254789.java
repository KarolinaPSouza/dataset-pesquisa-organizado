import java.util.*;
import java.io.*;
public class entry_4254789 {
 static class InputReader{
  BufferedReader reader;
  StringTokenizer tokenizer;

  public InputReader(InputStream stream) {
   reader = new BufferedReader(new InputStreamReader(stream), 32768);
   tokenizer = null;
  }

  String next() {
   while(tokenizer==null || !tokenizer.hasMoreTokens()) {
    try {
     tokenizer = new StringTokenizer(reader.readLine());
    } catch(IOException e) {
     throw new RuntimeException(e);
    }
   }
   return tokenizer.nextToken();
  }

  public int nextInt() {
   return Integer.parseInt(next());
  }

 }

 static InputReader r = new InputReader(System.in);
 static PrintWriter pw = new PrintWriter(System.out);

 public static void main(String[] args) {
  HashSet<Integer> set = new HashSet<Integer>();

  int n = r.nextInt();
  for(int i = 0; i < n; i ++) {
   set.add(r.nextInt());
  }

  pw.print(set.size());
  pw.close();
 } 
}