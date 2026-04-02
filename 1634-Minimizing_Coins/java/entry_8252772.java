import java.io.*;
import java.util.*;

public class entry_8252772 {
    public static void print(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            return  st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str ="";
            try{
                str = br.readLine().trim();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter{
        private final BufferedWriter bw;
        public FastWriter(){
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException{
            bw.append(""+object);
        }

        public void println(Object object) throws IOException{
            print(object);
            bw.append("\n");
        }
        public void close() throws IOException{
            bw.close();
        }
    }
    public static long mod = 1000000007;

    public static long solve(int[] arr, long sum) {
        int len = arr.length;
        long[] s = new long[(int)sum+1];
        Arrays.fill(s,Integer.MAX_VALUE);
        s[0] = 0;
        for(int i=1;i<=sum;i++){
            for(int j=0;j<len;j++){
                if(arr[j]<=i){
                    long a = s[i-arr[j]];
                    s[i] = Math.min(s[i],a+1);
                }
            }
        }
        if(s[(int)sum]==Integer.MAX_VALUE){
            return -1;
        }
        return s[(int)sum];

    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();

        int n = fr.nextInt();
        long sum = fr.nextLong();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = fr.nextInt();
        }
        System.out.println(solve(arr,sum));

    }
}







