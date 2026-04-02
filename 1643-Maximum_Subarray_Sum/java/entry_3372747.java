import java.io.*;
import java.util.*;

public class entry_3372747 {
  static int N;
  static long [] arr;
  static long [] pref;
  static long ans;
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(br.readLine());
    N =  Integer.parseInt(st.nextToken());
    arr = new long [N];
    pref = new long [N];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i<N; i++){
       arr[i] =  Integer.parseInt(st.nextToken());
    }
    pref[0] =  arr[0];
    long min = pref[0];
    ans = pref[0];
    for(int k = 1; k<N; k++){
      pref[k] =  pref[k-1] + arr[k];
    }
    for(int k = 1; k<N; k++){
        min = Math.min(Math.min(min,0),pref[k-1]);
        ans = Math.max(ans,pref[k]-min);    

    }
    //pw.println(pref[N-1]);
    //for(int i: pref) pw.println(i);
    pw.println(ans);
    pw.close();


  }
}