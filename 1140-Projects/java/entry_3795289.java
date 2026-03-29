import java.io.*;
import java.util.*;

// Good dp problem
public class entry_3795289 {
 static int mod = 998244353;
 public static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }





 public static void main(String[] args)  throws IOException{

  BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
  FastReader s = new FastReader();
  int t = 1;//s.nextInt();
  for(int z = 1; z <= t; z++) {
   int n = s.nextInt();
   ArrayList<int[]> aList = new ArrayList<int[]>();
   long[] reward = new long[n];
   for(int i = 0; i < n; i++) {
    int a = s.nextInt();
    int b = s.nextInt();
    int rew = s.nextInt();
    int[] aa = {b, (i + 1)};
    int[] bb = {a, -(i + 1)};
    aList.add(aa);
    aList.add(bb);
    reward[i] = rew;
   }

   aList.sort(new Comparator<int[]>() {
    public int compare(int[] a, int[] b) {
     if(Math.abs(a[0]) == Math.abs(b[0])) {
      return Integer.compare(a[1], b[1]);
     }
     return Integer.compare(a[0], b[0]);
    }
   });
   long maxe = -1;
   long maxs = 0;
   int n1 = aList.size();
   for(int i = n1 - 1; i >=0 ; i--) {
    int[] aa = aList.get(i);
    //System.out.println(Arrays.toString(aa));
    if(aa[1] > 0) {
     aa[1]--;
     reward[aa[1]] = maxs + reward[aa[1]];
     maxe = Math.max(reward[aa[1]], maxe);
    }
    else {
     aa[1]++;
     maxs = Math.max(maxs, reward[-aa[1]]);
    }
    //System.out.println(maxe);
   }
   System.out.println(maxe);




  }
  //output.flush();
   }
}



class FastReader {
    BufferedReader br;
    StringTokenizer st;
    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
}}