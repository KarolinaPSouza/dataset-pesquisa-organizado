import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")
public class entry_2047116 {
    public static ArrayList<Pair> list = new ArrayList();
    public static void main(String args[]){
        FastReader input = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = input.nextInt();
        for(int i = 0; i < n; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            list.add(new Pair(a, 1));
            list.add(new Pair(b, -1));
        }
        Collections.sort(list);
        int max = 0;
        int count = 0;
        for(int i = 0; i < list.size(); i++) {
            count += list.get(i).second();
            max = Math.max(max, count);
        }
        out.println(max);
        out.flush();
    }   
}

class Pair implements Comparable<Pair> {    
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int first() {
        return x;
    }
    public int second() {
        return y;
    }

    public int compareTo(Pair p) {
        if(this.first() == p.first()) {
            return 0;
        }else if(this.first() > p.first()) {
            return 1;
        }else {
            return -1;
        }
    } 
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    public String next() {
        while(st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }catch(Exception e) {
                System.out.println(e);
            }
        }     
        return st.nextToken();
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public String getString() {
        return next();
    }
}