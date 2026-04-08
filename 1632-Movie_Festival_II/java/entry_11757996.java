
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class entry_11757996 {
    public static void main(String[] args){
        FastIO fs = new FastIO();
        int n = fs.nextInt();
        int k = fs.nextInt();
        int[][] movies = new int[n][2];
        for(int i=0;i<n;i++){
            movies[i][0] = fs.nextInt();
            movies[i][1] = fs.nextInt();
        }

        Comparator<int[]> comp = (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        Arrays.sort(movies,comp);
        TreeSet<int[]> set = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if(arr1[0] == arr2[0]) return Integer.compare(arr1[1], arr2[1]);
                return Integer.compare(arr1[0], arr2[0]);
            }
        });
        //set.add(new Integer[]{1,0});
        for(int i=0;i<k;i++){
            int[] x = new int[]{movies[i][1], i};
            set.add(x);
        }

        //

        //PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = k;
        for(int i=k;i<n;i++){
            int startTime = movies[i][0];
            int endTime = movies[i][1];
            if(set.first()[0] <= startTime){
                count++;
                set.pollFirst();
                set.add(new int[]{endTime,i});
            }else if(set.last()[0] > endTime){
                set.pollLast();
                set.add(new int[]{endTime,i});
            }
            //System.out.println(movies[i][0] + " " + movies[i][1]);
            // if(!pq.isEmpty() && pq.peek() <= movies[i][0]){
            //     pq.poll();
            //     count++;
            //     // k++;
            //     pq.add(movies[i][1]);
            // }
            // else if(k > 0){
            //     k--;
            //     pq.add(movies[i][1]);
            //     count++;
            // }
        }
        fs.println(count);
        fs.close();
    }

    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }
    static class FastIO extends PrintWriter {private InputStream stream;private byte[] buf=new byte[1<<16];private int curChar,numChars;public FastIO(){this(System.in,System.out);}public FastIO(InputStream i,OutputStream o){super(o);stream=i;}public FastIO(String i,String o) throws IOException{super(new FileWriter(o));stream=new FileInputStream(i);}private int nextByte(){if(numChars==-1)throw new InputMismatchException();if(curChar>=numChars){curChar=0;try{numChars=stream.read(buf);}catch(IOException e){throw new InputMismatchException();}if(numChars==-1)return-1;}return buf[curChar++];}public String next(){int c;do{c=nextByte();}while(c<=' ');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>' ');return res.toString();}public int nextInt(){int c;do{c=nextByte();}while(c<=' ');int sgn=1;if(c=='-'){sgn=-1;c=nextByte();}int res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res*sgn;}public double nextDouble(){return Double.parseDouble(next());}}

}