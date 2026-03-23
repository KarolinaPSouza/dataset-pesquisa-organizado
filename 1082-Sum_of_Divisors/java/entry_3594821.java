import java.util.*;
import java.io.*;
import java.math.*;


public class entry_3594821 {
    public static void main(String[]args){ 
        long s = System.currentTimeMillis();
        new Solver().run();
        System.err.println(System.currentTimeMillis()-s+"ms");
    }

}

class Solver{
    final long mod = (long)1e9+7l;
    final boolean DEBUG = true, MULTIPLE_TC = false;
    long modInv2 = 500000004;

    FastReader sc;
    PrintWriter out;

    long f(long r, long l){
        long res = modSub(modMul(modMul(r, r + 1l), modInv2), modMul(modMul(l, l + 1l), modInv2));
        return res; 
    }

    long modAdd(long a, long b){
        long res = (a + b) % mod;
        return res;
    }

    long modSub(long a, long b){
        long res = a - b;
        if(res < 0){
            res = (res + mod) % mod;
        }
        return res;
    }

    long modMul(long a, long b){
        long res = ((a % mod) * (b % mod)) % mod;
        return res;
    }

    long mpow(long x, long n) {
        if(n == 0)
            return 1;
        if(n % 2 == 0) {
            long root = mpow(x, n / 2);
            return root * root % mod;
        }else {
            return x * mpow(x, n - 1) % mod;
        }
    }

    long modInv(long x){
        return mpow(x, mod - 2l);
    }

    ArrayDeque<Long> g(long X){
        ArrayDeque<Long> li = new ArrayDeque<>();
        long lt = (long)Math.sqrt(X);
        long prevL = 0, prevR = 0;
        for(long i = lt; i >= 1; i--){
            long div1 = X / i, div2 = X / div1;
            if(prevL != div1){
                li.addFirst(div1);
                prevL = div1;
                prevR = div2;
                if(div1 != div2){
                    li.addLast(div2);
                }
            }
        } 
        //Collections.sort(li, (A, B)->Long.compare(B, A));
        return li;
    }

    void process(int testNumber){
        long N = nl();
        //modInv2 = modInv(2); trace(modInv2);
        ArrayDeque<Long> li = g(N); //trace("list", li); 
        //trace(li);
        long res = 0l, prev = 0l;
        for(long x : li){
            long rightLt = N / x, val = f(rightLt, prev); //trace(x, prev, rightLt, val);
            res = modAdd(res, modMul(val, x));
            prev = rightLt;
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