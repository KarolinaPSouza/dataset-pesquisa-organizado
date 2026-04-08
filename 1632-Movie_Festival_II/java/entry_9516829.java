import java.io.*;
import java.util.*;
class FastIO extends PrintWriter {
    private InputStream stream;private byte[]buf=new byte[1<<16];
    private int curChar,numChars;public FastIO(){this(System.in,System.out);}
    public FastIO(InputStream i, OutputStream o){super(o);stream=i;}
    public FastIO(String i,String o)throws IOException {super(new FileWriter(o));stream=new FileInputStream(i);}
    private int nextByte(){if(numChars==-1)throw new InputMismatchException();if(curChar>=numChars){curChar=0;try{numChars=stream.read(buf);}catch(IOException e){throw new InputMismatchException();}if(numChars==-1)return -1;}return buf[curChar++];}
    public String nextLine(){int c;do{c=nextByte();}while(c<='\n');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>'\n');return res.toString();}
    public String next(){int c;do{c=nextByte();}while(c<=' ');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>' ');return res.toString();}
    public int nextInt(){int c;do{c=nextByte();}while(c<=' ');int sgn=1;if(c=='-'){sgn=-1;c=nextByte();}int res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res * sgn;}
    public long nextLong(){int c;do{c=nextByte();}while(c<=' ');long sgn=1;if(c=='-'){sgn=-1;c=nextByte();}long res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res * sgn;}
    public double nextDouble(){return Double.parseDouble(next());
    }

}
class EndTime implements Comparable<EndTime> {
    int time;
    int index;
    public EndTime(int time,int index){
        this.time=time;
        this.index=index;
    }
    @Override
    public int compareTo(EndTime e){
        if(this.time!=e.time){
            return this.time-e.time;
        }else{
            return this.index-e.index;
        }
    }
}
class Timings implements Comparable<Timings>{
    int arrival;
    int ending;
    public Timings(int arrival,int ending){
        this.arrival=arrival;
        this.ending=ending;
    }
    @Override
    public int compareTo(Timings t){
        if(this.ending!=t.ending){
            return this.ending-t.ending;
        }else{
            return this.arrival-t.arrival;
        }
    }
}

public class entry_9516829 {
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

    public static void main(String[] args) {
        FastIO sc=new FastIO();
        int n=sc.nextInt();
        int k=sc.nextInt();
        ArrayList<Timings> arr=new ArrayList<>();
        if(k==n){
            sc.println(n);
            sc.flush();
            return;
        }

        for(int i=0;i<n;i++){
            arr.add(new Timings(sc.nextInt(), sc.nextInt()));
        }
        TreeSet<EndTime> ends=new TreeSet<>();
        Collections.sort(arr);
        int count=0;
//        for(int i=0;i<k;i++){
//            ends.add(new EndTime(arr.get(i).ending,i));
//            count++;
//        }
        for(int i=0;i<n;i++){
            int newStart=arr.get(i).arrival;
            EndTime endToBeRemoved=ends.floor(new EndTime(newStart,n));

            if(endToBeRemoved!=null){
                ends.remove(endToBeRemoved);
            }

            if(ends.size()<k){
                ends.add(new EndTime(arr.get(i).ending,i));
                count++;
            }


        }
        sc.println(count);
        sc.flush();


    }






}