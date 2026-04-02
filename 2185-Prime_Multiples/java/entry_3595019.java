import java.util.*;
import java.io.*;
import java.math.*;


public class entry_3595019 {
    public static void main(String[]args){ 
        long s = System.currentTimeMillis();
        new Solver().run();
        System.err.println(System.currentTimeMillis()-s+"ms");
    }

}

class Solver{
    final long mod = (long)1e9+7l;
    final boolean DEBUG = true, MULTIPLE_TC = false;

    FastReader sc;
    PrintWriter out;

    long N, arr[];
    int K;

    void init(){
        N = nl();
        K = ni();
        arr = new long[K];
        for(int i = 0; i < K; i++){
            arr[i] = nl();
        }
    }

    void process(int testNumber){
        init();
        int maskLt = 1 << K; 
        long res = 0l;
        for(int mask = 1; mask < maskLt; mask++){
            int tmpMask = mask, pos = 0, setBitCount = 0;
            long val = 0l, prod = 1l;
            while(tmpMask != 0){
                if((tmpMask & 1) == 1){
                    if(prod > N / arr[pos]){
                        prod = N + 1;
                    }else{
                        prod *= arr[pos];
                    }
                    setBitCount += 1;
                }
                tmpMask /= 2;
                pos += 1;
            } 
            val = N / prod;
            if((setBitCount & 1) == 1){
                res += val;
            }else{
                res -= val;
            }
        }
        pn(res);
    }

    void run(){
        sc = new FastReader();
        out = new PrintWriter(System.out);
        int t = MULTIPLE_TC ? ni() : 1;
        for(int test = 1; test <= t; test++){
            process(test);
        }
        out.flush();
    }

    void trace(Object... o){ if(!DEBUG) return; System.err.println(Arrays.deepToString(o)); };    
    void pn(Object o){ out.println(o); }
    void p(Object o){ out.print(o); }
    int ni(){ return Integer.parseInt(sc.next()); }
    long nl(){ return Long.parseLong(sc.next()); }
    double nd(){ return Double.parseDouble(sc.next()); }
    String nln(){ return sc.nextLine(); }
    long gcd(long a, long b){ return (b==0)?a:gcd(b,a%b);}
    int gcd(int a, int b){ return (b==0)?a:gcd(b,a%b); }

    class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 

        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 

        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 

        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 
    } 
}


class pair implements Comparable<pair> {
    int first, second;
    public pair(int first, int second){
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(pair ob){
        if(this.first != ob.first)
            return this.first - ob.first;
        return this.second - ob.second;
    }

    @Override
    public String toString(){
        return this.first + " " + this.second;
    }

    static public pair from(int f, int s){
        return new pair(f, s);
    }
}