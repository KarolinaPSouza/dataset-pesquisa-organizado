import java.io.*; import java.util.*;
public class entry_5010521 {
 public static void main(String[] args) throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);
  long n = Long.parseLong(br.readLine());
  long total = 0;
  long mod = (long)Math.pow(10, 9)+7;
  for(long i=1; i*i<=n; i++){
      total+=((((n/i)%mod-(i%mod)+mod)%mod+1)%mod)*(i%mod);
      total%=mod;
      total+=((((n/i)%mod)*(((n/i)%mod+1)%mod))/2)%mod;
      total-=((((i)%mod)*(((i)%mod+1)%mod))/2)%mod;
      total+=mod;
      total%=mod;
  }
  pw.println(total);
  pw.close();
 }
}