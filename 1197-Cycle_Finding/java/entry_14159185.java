import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class entry_14159185 {

             static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null; // Avoid NPE if input is over
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }


        int nextInt()     { return Integer.parseInt(next()); }
        long nextLong()   { return Long.parseLong(next()); }
        double nextDouble(){ return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }


    public static void main(String[] args) {
        FastReader fr = new FastReader() ;
        int n = fr.nextInt() ;
        int m = fr.nextInt() ;

        int [] parent = new int [n] ;
        int [][] edges = new int [m][3] ;

        for(int i=0 ;i <m ;i++){
             int u = fr.nextInt() - 1 ;
             int v = fr.nextInt() - 1 ;
             int w = fr.nextInt() ;


             edges[i][0] = u ;
             edges[i][1] = v ;
             edges[i][2] = w ;
        }

        boolean isNeg = false ;
        List<Integer> loop = new ArrayList<>() ;

        long [] dist = new long[n] ;
        // Arrays.fill(dist,Long.MAX_VALUE) ;
        // dist[0] = 0 ;

        for(int i=0 ;i <n ;i++){

            for(int [] edge : edges){
                 int u = edge[0] ;
                 int v = edge[1] ;
                 int w = edge[2] ;

                 if(  dist[v] > dist[u] + w){
                    parent[v] = u ;
                    dist[v] = w + dist[u] ;
                    if(i == n-1){
                        isNeg = true ;
                        int currNode = v ;
                        for(int j=0 ;j <n ;j++){
                            currNode = parent[currNode] ;
                        }


                        int reach = currNode ;
                        loop.clear();
                        loop.add(reach) ;
                        reach = parent[reach] ;
                        while(reach != currNode){
                             loop.add(reach) ;
                             reach = parent[reach] ; 
                        }

                        loop.add(reach) ;

                    }

                 }
            }
        }

        if(!isNeg) System.out.println("NO");
        else{
            System.out.println("YES");
            Collections.reverse(loop);
            for(int num : loop) System.out.print((num+1)+" ");
        }
    }
}