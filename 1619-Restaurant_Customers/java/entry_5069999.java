
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_5069999 {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt()
        {
            return Integer.parseInt(next());
        }
        long nextLong()
        {
            return Long.parseLong(next());
        }
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class Pair implements Comparable<Pair>{
        int val;
        int positiveNegative;
        public Pair(int v, int p){
            this.val=v;
            this.positiveNegative=p;
        }
        public int compareTo(Pair o){
            return this.val - o.val;
        }

    }
    public static void main(String[] args) {

        FastReader fs = new FastReader();
        int n=fs.nextInt();
        List<Pair> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new Pair(fs.nextInt(),+1));
            ans.add(new Pair(fs.nextInt(),-1));
        }
        Collections.sort(ans);
        int max=0;
        int count=0;
        for (int i = 0; i < ans.size(); i++) {

            count += ans.get(i).positiveNegative;
            max=Math.max(max,count);
        }
//        for(Pair it:ans)
//            System.out.print(it.val + " " + it.positiveNegative + " || ");
//        System.out.println();
        System.out.println(max);


    }


}