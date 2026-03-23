import java.io.*;
import java.util.StringTokenizer;

public class entry_8483012 {
 static int MOD = 1000000007;
 public static void main(String[] args) throws IOException {
  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);

  long N = Long.parseLong(r.readLine());
  long sum = 0;
  long i=0;
  for(i=1; i*i<=N; i++){
   sum = (sum+i*(N/i))%MOD;
  }
  //System.out.println(sum);

  long lastD = i-1;
  //System.out.println(lastD);
  long numberAffected = N/(i-1);


  while(numberAffected>0){
   long newD = bin(N, lastD, N+1, numberAffected);
   long newDp = newD%MOD; long lastDp=lastD%MOD;
   sum = (sum + 
    (
     (
      (
       (newDp*(newDp+1))/2-(lastDp*(lastDp+1))/2 + MOD
      )
    %MOD) + MOD)
   *numberAffected)%MOD;

   numberAffected--;
   lastD=newD;
  }
  pw.println(sum);
  pw.close();
 }

 public static  long bin(long N, long l, long r, long tar){
  long guess = (l+r+1)/2;
  if(N/guess == tar)
  {
   if(l==r)
    return l;
   return bin(N, guess, r, tar);
  }
  else
   return bin(N, l, guess-1, tar);
 }
}