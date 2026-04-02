import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_10204598 {
 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());
  int n = Integer.parseInt(st.nextToken());
  long[] prefix = new long[n+1];
  long[] neg = new long[n+1];
  long[] seq = new long[n];
  st = new StringTokenizer(br.readLine());
  for (int i = 0; i<n; i++) {
   seq[i] = Integer.parseInt(st.nextToken());
   prefix[i+1] = seq[i] + prefix[i];
   neg[i+1] = seq[i] + neg[i];

  }
  for (int i = 1; i<n+1; i++) {
   neg[i] = Math.min(neg[i], neg[i-1]);
  }
  long msum = Long.MIN_VALUE;
  for (int i = 1; i<n+1; i++) {
   msum = Math.max(msum, prefix[i] - neg[i-1]);
  }
  System.out.println(msum);

 }
}