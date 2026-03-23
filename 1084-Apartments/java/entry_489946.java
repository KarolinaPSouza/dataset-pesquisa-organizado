import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class entry_489946 {
 public static void main(String[] args) {
  FastScanner scan=new FastScanner();
  int n=scan.nextInt(), m=scan.nextInt(), k=scan.nextInt();
  ArrayList<Integer> p=new ArrayList<>(), a=new ArrayList<>();

  int[] ppl=new int[n], apartments=new int[m];
  for(int i=0;i<n;i++) p.add(scan.nextInt());
  for(int j=0;j<m;j++) a.add(scan.nextInt());

  Collections.sort(p);
  Collections.sort(a);

  for(int i=0;i<n;i++) ppl[i]=p.get(i);
  for(int j=0;j<m;j++) apartments[j]=a.get(j);

  int p1=0, p2=0;
  int res=0;
  while(p1<n&&p2<m) {
   if(Math.abs(ppl[p1]-apartments[p2])<=k) {
    res++;
    p1++;
    p2++;
   }
   else if(ppl[p1]>apartments[p2]) p2++;
   else p1++;
  }
  System.out.println(res);
 }
 static class FastScanner {
  BufferedReader br;
  StringTokenizer st;

  public FastScanner() {
   try {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
   } catch (Exception e){e.printStackTrace();}
  }

  public String next() {
   if (st.hasMoreTokens()) return st.nextToken();
   try {st = new StringTokenizer(br.readLine());}
   catch (Exception e) {e.printStackTrace();}
   return st.nextToken();
  }

  public int nextInt() {return Integer.parseInt(next());}

  public long nextLong() {return Long.parseLong(next());}

  public double nextDouble() {return Double.parseDouble(next());}

  public String nextLine() {
   String line = "";
   if(st.hasMoreTokens()) line = st.nextToken();
   else try {return br.readLine();}catch(IOException e){e.printStackTrace();}
   while(st.hasMoreTokens()) line += " "+st.nextToken();
   return line;
  }
 }
}