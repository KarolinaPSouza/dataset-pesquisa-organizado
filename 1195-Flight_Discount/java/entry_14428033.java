import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class entry_14428033 {

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

    public static List<List<int[]>> graph ;

    public static void main(String[] args) {
        FastReader fr = new FastReader() ;
        int n = fr.nextInt() ;
        int m = fr.nextInt() ;

        graph = new ArrayList<>() ;
        for(int i=0 ;i <n ;i++) graph.add(new ArrayList<>()) ;

        for(int i=0; i< m ;i++){
            int u = fr.nextInt() - 1 ;
            int v = fr.nextInt() - 1 ;
            int c = fr.nextInt() ;

            graph.get(u).add(new int []{v,c}) ;
        }

        long [][] dist = new long[n][2] ;
        for(long [] arr : dist) Arrays.fill(arr,Long.MAX_VALUE) ;



        PriorityQueue<long[]> pq = new PriorityQueue<>((p1,p2) -> Long.compare(p1[1], p2[1])) ;
        pq.add(new long []{0L,0L,0L}) ;

        dist[0][0] = 0 ;

        while(!pq.isEmpty()){
             long [] curr = pq.poll() ;
             int u = (int) curr[0] ;
             long currCost = curr[1] ;
             int state = (int) curr[2] ;

             if(currCost > dist[u][state]) continue ;

             for(int []child : graph.get(u)){
                int v = child[0] ;
                int c = child[1] ;

                if(state == 0){
                     if(dist[v][0] > currCost + c){
                          dist[v][0] = currCost + c ;
                          pq.add(new long []{v,dist[v][0],0L}) ;
                     }

                     if(dist[v][1] > currCost + c/2){
                         dist[v][1] = currCost + c/2 ;
                         pq.add(new long []{v,dist[v][1],1L}) ;
                     }
                }
                else{

                     if(dist[v][1] > currCost + c){
                         dist[v][1] = currCost + c ;
                         pq.add(new long[] {v,dist[v][1],1}) ;
                     }
                }
             }
        }


        System.out.println(dist[n-1][1]);


    }


}