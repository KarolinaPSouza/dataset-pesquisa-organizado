import java.util.*;
import java.io.*;

/* Valar Morghulis */
/* Valar Dohaeris */

public class entry_12716726 {
    static class FastIO extends PrintWriter{
        private InputStream stream;
        private byte[] buf=new byte[1<<16];
        private int curChar,numChars;

        public FastIO(){
            this(System.in,System.out);
        }

        public FastIO(InputStream i,OutputStream o){
            super(o);
            stream=i;
        }

        public FastIO(String i,String o) throws IOException{
            super(new FileWriter(o));
            stream=new FileInputStream(i);
        }

        private int nextByte(){
            if(numChars==-1) throw new InputMismatchException();
            if(curChar>=numChars){
                curChar=0;
                try{
                    numChars=stream.read(buf);
                } catch(IOException e){
                    throw new InputMismatchException();
                }
                if(numChars==-1) return -1;
            }
            return buf[curChar++];
        }

        public String next(){
            int c;
            do{
                c=nextByte();
            } while(c<=32);
            StringBuilder res=new StringBuilder();
            do{
                res.appendCodePoint(c);
                c=nextByte();
            } while(c>32);
            return res.toString();
        }

        public int nextInt(){
            int c;
            do{
                c=nextByte();
            } while(c<=32);
            int sgn=1;
            if(c=='-'){
                sgn=-1;
                c=nextByte();
            }
            int res=0;
            do{
                if(c<'0'||c>'9') throw new InputMismatchException();
                res=res*10+(c-'0');
                c=nextByte();
            } while(c>32);
            return res*sgn;
        }

        public long nextLong(){
            int c;
            do{
                c=nextByte();
            } while(c<=32);
            int sgn=1;
            if(c=='-'){
                sgn=-1;
                c=nextByte();
            }
            long res=0;
            do{
                if(c<'0'||c>'9') throw new InputMismatchException();
                res=res*10+(c-'0');
                c=nextByte();
            } while(c>32);
            return res*sgn;
        }

        public int[] readIntArray(int n){
            int[] a=new int[n];
            for(int i=0;i<n;i++)
                a[i]=nextInt();
            return a;
        }

        public long[] readLongArray(int n){
            long[] a=new long[n];
            for(int i=0;i<n;i++)
                a[i]=nextLong();
            return a;
        }

        public char[] readCharArray(int n){
            char[] a=new char[n];
            for(int i=0;i<n;i++)
                a[i]=next().charAt(0);
            return a;
        }

        public double nextDouble(){
            return Double.parseDouble(next());
        }
    }
    static class Interval{
        int st,end;
        public Interval(int st,int end){
            this.st=st;
            this.end=end;
        }
    }
    public static void main(String[] args){
        FastIO io=new FastIO();
        int n=io.nextInt();
        int k=io.nextInt();
        Interval arr[]=new Interval[n];
        for(int i=0;i<n;i++) arr[i]=new Interval(io.nextInt(), io.nextInt());
        Arrays.sort(arr,Comparator.comparingInt(a->a.end));
        int ans=0;
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        tm.put(0,k);
        for(int i=0;i<n;i++){
            Integer lower=tm.floorKey(arr[i].st);
            if(lower!=null){
                ans++;
                int val=tm.get(lower);
                if(val-1==0) tm.remove(lower);
                else tm.put(lower,val-1);
                tm.put(arr[i].end,tm.getOrDefault(arr[i].end,0)+1);
            }
        }
        io.println(ans);
        io.flush();
        io.close();
    }
}