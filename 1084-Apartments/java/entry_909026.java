import java.util.*;
import java.math.*;
import java.io.*;

public class entry_909026 {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        List<Integer> other = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            arr.add(sc.nextInt());
        }
        for(int i = 0; i < m; ++i) {
            other.add(sc.nextInt());
        }
        Collections.sort(arr);
        Collections.sort(other);
        int i = 0, j = 0, ans = 0;
        while(i < arr.size() && j < other.size()) {
            if(Math.abs(arr.get(i)-other.get(j)) <= k) {
                ans++;
                i++;
                j++;
            }
            else if (arr.get(i) > other.get(j))
                j++;
            else
                i++;
        }
        System.out.println(ans); 
        out.close();
    }



    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

  //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine(){
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
      return str;
   }
  }
}