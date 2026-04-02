import java.io.*;
import java.util.*;
public class entry_12651453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i=0; i<m; i++){
            StringTokenizer sc = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(sc.nextToken());
            int v = Integer.parseInt(sc.nextToken());
            int w = Integer.parseInt(sc.nextToken());
            graph.computeIfAbsent(u, x -> new ArrayList<>()). add(new int[] {v, w});
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0,1} );
        long[] dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] =0;
        while(!pq.isEmpty()){
            long[] point = pq.poll();
            int city = (int) point[1];
            long currDist = point[0];
            if(currDist > dist[city]) continue;
            for(int[] neighbour : graph.getOrDefault(city, new ArrayList<>())){
                int newCity = neighbour[0];
                int newDist = neighbour[1];
                if(newDist + currDist < dist[newCity]){
                    dist[newCity] = newDist+ currDist;
                    pq.offer(new long[]{dist[newCity], newCity});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(dist[i]).append(" ");
        }
        System.out.print(sb);
    }
}
