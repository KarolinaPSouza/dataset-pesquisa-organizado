import java.io.*;
import java.util.*;

class FastIO extends PrintWriter{
    private InputStream stream;private byte[]buf=new byte[1<<16];
    private int curChar,numChars;public FastIO(){this(System.in,System.out);}
    public FastIO(InputStream i,OutputStream o){super(o);stream=i;}
    public FastIO(String i,String o)throws IOException{super(new FileWriter(o));stream=new FileInputStream(i);}
    private int nextByte(){if(numChars==-1)throw new InputMismatchException();if(curChar>=numChars){curChar=0;try{numChars=stream.read(buf);}catch(IOException e){throw new InputMismatchException();}if(numChars==-1)return -1;}return buf[curChar++];}
    public String nextLine(){int c;do{c=nextByte();}while(c<='\n');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>'\n');return res.toString();}
    public String next(){int c;do{c=nextByte();}while(c<=' ');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>' ');return res.toString();}
    public int nextInt(){int c;do{c=nextByte();}while(c<=' ');int sgn=1;if(c=='-'){sgn=-1;c=nextByte();}int res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res * sgn;}
    public long nextLong(){int c;do{c=nextByte();}while(c<=' ');long sgn=1;if(c=='-'){sgn=-1;c=nextByte();}long res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res * sgn;}
    public double nextDouble(){return Double.parseDouble(next());
    }
}

public class entry_12014436 {
    static FastIO sc = new FastIO();

    public static void main(String args[]){
        long n=sc.nextLong();
        int k=sc.nextInt();
        long prime[]=new long[k];
        for(int i=0;i<k;i++){
            prime[i]=sc.nextLong();
        }
        long subsetGroupsSummation[]=new long[k+1];
        int max=1<<k;
        for (int i = 1; i < max; i++) {
            int groupSize = 0;
            long product = 1;
            for (int j = 0; j < k; j++) {
                if ((i & (1 << j)) != 0) {
                    // Check if multiplying would exceed n
                    if (product > n / prime[j]) {
                        product = n + 1; // Force product to be > n
                        break;
                    }
                    product *= prime[j];
                    groupSize++;
                }
            }
            long contribution = (product > n ? 0 : n / product);
            subsetGroupsSummation[groupSize] += contribution;
        }
        int sign=1;
        long answer=0;

        for(int i=1;i<=k;i++){
            // sc.print(subsetGroupsSummation[i]+" ");
            answer+=sign*subsetGroupsSummation[i];
            sign=sign*(-1);


        }
        sc.println(answer);

        sc.flush();
    }
}