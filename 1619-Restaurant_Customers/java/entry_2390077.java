import java.io.*;
import java.util.*;

class restaurantCustomers{
    public static long mod = (long)1e9+7;
    public static ArrayList<Integer>[] graph;
    public static void main(String[] args) {
        InputStream inputStream = System.in;
  OutputStream outputStream = System.out;
  InputReader in = new InputReader(inputStream);
  PrintWriter out = new PrintWriter(outputStream);
        int t = 1;
        // t = in.nextInt();
        for(int i = 1;i<=t ;i++){
            solve(in,out);
        }
        out.close();
    }

    private static void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] arrivals = new int[n];
        int[] departures = new int[n];
        for (int i = 0; i < departures.length; i++) {
            arrivals[i] = in.nextInt();
            departures[i] = in.nextInt();
        }
        Arrays.sort(arrivals);
        Arrays.sort(departures);
        int max = -1;
        for (int i = 0; i < departures.length; i++) {
            int u = find(arrivals,departures[i]);
            max = Math.max(max,u-i);
        }
        out.println(max);
    }

    private static int find(int[] arrivals, int i) {
        if(i<arrivals[0]) return 0;
        if(i>arrivals[arrivals.length-1]) return arrivals.length;
        int lo = 0;
        int hi = arrivals.length-1;
        int ans = 0;
        while(lo<=hi){
            int mid = lo +(hi-lo)/2;
            if(arrivals[mid] < i){
                ans = mid;
                lo = mid+1;
            }
            else hi = mid-1;
        }
        return ans+1;
    }
}
class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
    public double nextDouble(){
        return Double.parseDouble(next());
    }
    public int[] readIntArray(int size){
        int[] list = new int[size];
        for(int i = 0;i<size;i++) list[i] = nextInt();
        return list;
    }
    public long[] readLongArray(int size){
        long[] list = new long[size];
        for(int i = 0;i<size;i++) list[i] = nextLong();
        return list;
    }
    public double[] readDoubleArray(int size){
        double[] list = new double[size];
        for(int i = 0;i<size;i++) list[i] = nextDouble();
        return list;
    }
    public String linereader() {
        String s = null;
        try{
            s = reader.readLine();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

}
class Pair<T extends Comparable<T>,K extends Comparable<K> > implements Comparable<Pair<T,K>>{
    T first;
    K second;
    public Pair(T first, K second){
        this.first  = first;
        this.second = second;
    }
    @Override
    public String toString(){
        return first+" "+second;
    }
    @Override
    public int compareTo(Pair<T,K> o) {
        // TODO Auto-generated method stub
        if((first).compareTo(o.first)!=0) return first.compareTo(o.first);
        else return second.compareTo(o.second);
    }

}