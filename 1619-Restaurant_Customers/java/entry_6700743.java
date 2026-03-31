import java.util.*;
import java.io.*;
public class entry_6700743 {
    static class Pair implements Comparable<Pair>{
        long firstval; long secondval;
        public Pair(long f, long s){
            firstval = f;
            secondval = s;
        }
        public int compareTo(Pair P){
            return Long.compare(firstval,P.firstval);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        //I think we can coordinate compress and then use prefix sums
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Pair> points = new ArrayList<Pair>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            points.add(new Pair(a,1));
            points.add(new Pair(b,-1));
        }
        Collections.sort(points);
        long ans = 0;
        long pref = 0;
        for(int i=0;i<2*N;i++){
            pref += points.get(i).secondval;
            ans = Math.max(ans,pref);
        }
        out.println(ans);

        br.close();
        out.close();


    }
}