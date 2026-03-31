import java.io.*;
import java.util.*;

public class entry_5741763 {
    public static class pair{
            int f ;
            int s ;
            pair(int f, int s){
                this.f = f;
                this.s = s;
            }
        }
    public static void main(String[] args) {
    FastReader sc  = new FastReader();
    int t = sc.nextInt();
    ArrayList<pair> al = new ArrayList<>();
     for(int m = 0; m< t; m++){
        int f = sc.nextInt();
        int s = sc.nextInt();
        al.add(new pair(f, 1));
        al.add(new pair(s, -1));

     }   
     Collections.sort(al, (a,b)->{
        return a.f - b.f;


     });
     int max = 0;
     int c = 0;
     for(int i = 0; i<al.size(); i++){
        // System.out.print(al.get(i).f);
        // System.out.println(al.get(i).s);

        int x = al.get(i).s;
        c+= x;
        max= Math.max(max, c);

     }
     System.out.println(max);




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
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }

    long nextLong() { return Long.parseLong(next()); }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    float nextFloat() {
        return Float.parseFloat(next());
    }

    boolean nextBoolean() {
        return Boolean.parseBoolean(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}