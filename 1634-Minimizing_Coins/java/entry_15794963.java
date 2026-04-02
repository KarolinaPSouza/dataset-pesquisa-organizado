import java.io.*;
import java.util.*;

public class entry_15794963 {
    static class FastScanner{
        private final byte[] buffer=new byte[1<<16];
        private int ptr=0,len=0;
        private final InputStream in=System.in;
        private int readByte() throws IOException{
            if(ptr>=len){
                len=in.read(buffer);
                ptr=0;
                if(len<=0) return -1;
            }
            return buffer[ptr++];
        }

        boolean hasNext() throws IOException{
            int c;
            while((c=readByte())!=-1){
                if(!Character.isWhitespace(c)){
                    --ptr;
                    return true;
                }
            }
            return false;
        }
        String next() throws IOException{
            StringBuilder sb=new StringBuilder();
            int c;
            while((c=readByte())!=-1 && Character.isWhitespace(c));
            while(c!=-1 && !Character.isWhitespace(c)){
                sb.append(c);
                c=readByte();
            }
            return sb.toString();
        }
        int nextInt() throws IOException{
            int c,sign=1,val=0;
            while((c=readByte())<=' ');
            if(c=='-'){
                sign=-1;
                c=readByte();
            }
            while(c>' '){
                val=val*10+(c-'0');
                c=readByte();
            }
            return val*sign;
        }
        long nextLong() throws IOException{
            int c,sign=1;
            long val=0;
            while((c=readByte())<=' ');
            if(c=='-'){
                sign=-1;
                c=readByte();
            }
            while(c>' '){
                val=val*10+(c-'0');
                c=readByte();
            }
            return val*sign;
        }
        double nextDouble() throws IOException{
            return Double.parseDouble(next());
        }
    }

    static class FastWriter{
        private final StringBuilder sb=new StringBuilder();
        void print(Object o){
            sb.append(o);
        }
        void println(Object o){
            sb.append(o).append('\n');
        }
        void println(){
            sb.append('\n');
        }
        void flush() throws IOException{
            System.out.print(sb.toString());
        }
    }

    static final Long MOD=1_000_000_007L;
    public static void main(String[]args) throws IOException{
        FastScanner fs=new FastScanner();
        FastWriter out=new FastWriter();
        final int n=fs.nextInt(),s=fs.nextInt();
        int[]a=new int[n]; 
        for(int i=0;i<n;++i)a[i]=fs.nextInt();
        Arrays.sort(a);
        long[] dp=new long[s+1];Arrays.fill(dp,MOD);
        dp[0]=0L;
        for(int i=1;i<=s;++i){
            for(int j:a){
                if(i-j<0)break;
                dp[i]=Math.min(dp[i],dp[i-j]+1);
            }
        }
        out.println(dp[s]>=MOD?-1:dp[s]);
        out.flush();
    }
}