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

public class entry_7595719 {
    static FastIO sc = new FastIO();
    public static void sort(int[]arr){
        if(arr==null){return;}int n=arr.length;if(n<2){return;}int mid=n/2;int[]left=new int[mid];int[]right=new int[n - mid];
        System.arraycopy(arr,0,left,0,mid);System.arraycopy(arr,mid,right,0,n - mid);
        sort(left);sort(right);merge(arr,left,right);
    }
    private static void merge(int[]arr,int[]left,int[]right){
        int i=0,j=0,k=0;int leftLength=left.length;
        int rightLength=right.length;while(i<leftLength&&j<rightLength)
        {if(left[i]<=right[j]){arr[k++]=left[i++];}else{arr[k++]=right[j++];}}
        while(i<leftLength){arr[k++]=left[i++];}while(j<rightLength){arr[k++]=right[j++];}
    }
    public static void main(String args[]){
        int n,m,k;
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        int[] requirements = new int[n];
        int[] apartments = new int[m];
        for(int i=0;i<n;i++){
            requirements[i] = sc.nextInt();
        }
        for(int i=0;i<m;i++){
            apartments[i] = sc.nextInt();
        }

        sort(apartments);
        sort(requirements);

        int i=0,j=0,count = 0;

        while(i<n && j<m){
            if (requirements[i]-k>apartments[j]){
                j++;
            } else if (requirements[i]+k < apartments[j]){
                i++;
            } else {
                i++;j++; count++;
            }
        }

        sc.println(count);
        sc.flush();
    }
}
