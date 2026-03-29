import java.util.*;
import java.io.*;

public class entry_9691690 {
    static class Project implements Comparable<Project>{
        long s;
        long e;
        long w;
        Project(long a,long b,long c){
            s=a;
            e=b;
            w=c;
        }

        @Override
        public int compareTo(Project p2){
            return (int)(this.e-p2.e);
        }
    }
    static int find(int i,int j, long e[],long x){
        int ans=-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(e[mid]<x){
                ans=mid;
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out=new FastWriter();
            int n=in.nextInt();
            List<Project> a=new ArrayList<>();
            for(int i=0;i<n;i++){
                a.add(new Project(in.nextLong(),in.nextLong(),in.nextLong()));
            }
            Collections.sort(a);
            long e[]=new long[n];
            for(int i=0;i<n;i++){
                e[i]=a.get(i).e;
            }
            long dp[]=new long[n];
            dp[0]=a.get(0).w;
            for(int i=1;i<n;i++){
                int k=find(0,i-1,e,a.get(i).s);
                dp[i]=Math.max(dp[i-1],a.get(i).w+(k==-1?0:dp[k]));
            }
            out.println(dp[n-1]);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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
        char nextChar() {
            return next().charAt(0);
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
}