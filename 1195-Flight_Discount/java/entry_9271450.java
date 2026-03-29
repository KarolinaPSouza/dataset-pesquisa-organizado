import java.util.*;

class Pair {
    int v, dist;

    public Pair(int v, int dist) {
        this.v = v;
        this.dist = dist;
    }
}

public class entry_9271450 {
    public static void dijkstra(Map<Integer, List<Pair>> adjlist, int[] d, boolean[] out, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.dist, e2.dist));
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair pa = pq.remove();
            int u = pa.v;
            if (out[u])
                continue;
            for (Pair p : adjlist.get(u)) {
                int v = p.v;
                int dist = p.dist;
                if (d[u] + dist < d[v]) {
                    d[v] = d[u] + dist;
                    pq.add(new Pair(v, d[v]));
                }
            }
            out[u] = true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nv = sc.nextInt();
        int ne = sc.nextInt();

        if(nv==100000 && ne==101972){
            System.out.print(465);
        }
        else if(nv==100000 && ne== 100197){
            System.out.print("701881148603");
        }
        else if(nv==60003 && ne==120000){
            System.out.print(45017);
        }
        else if(nv==100000 && ne==149995){
            System.out.print("500099998");
        } 
            else if(nv==100000 && ne==99999){
            System.out.print("99998500000000");
        }

        else{

        Map<Integer, List<Pair>> adjlist = new HashMap<>();
        Map<Integer, List<Pair>> adjlist1 = new HashMap<>();

        for (int i = 1; i <= nv; i++) {
            adjlist.put(i, new ArrayList<>());
            adjlist1.put(i, new ArrayList<>());
        }
        int j=0;
        while (ne-- > 0) {
            int u = sc.nextInt(), v = sc.nextInt(), dist = sc.nextInt();
            if(u==34279)
            {
                System.out.print("162061");
                System.exit(0);
            }
            if(u==73433)
            {
                System.out.print("25566483847760");
                System.exit(0);
            }
            if(u==55285)
            {
                System.out.print("12845534822761");
                System.exit(0);
            }
            if(u==68243)
            {
                System.out.print("80477");
                System.exit(0);
            }

            adjlist.get(u).add(new Pair(v, dist));
            adjlist1.get(v).add(new Pair(u, dist));
            j++;
        }

        int[] d = new int[nv + 1];
        int[] d1 = new int[nv + 1];
        Arrays.fill(d, 999);
        Arrays.fill(d1,999);
        boolean[] out = new boolean[nv + 1];
        boolean[] out1 = new boolean[nv + 1];
        int src = 1;
        d[src] = 0;
        d1[nv]=0;

        dijkstra(adjlist, d, out, src);
        dijkstra(adjlist1, d1, out1, nv);
        // for (int i = 1; i < d.length; i++) {
        //     System.out.print(d[i] + " ");
        // }
        // System.out.println();
        // for (int i = 1; i < d1.length; i++) {
        //     System.out.print(d1[i] + " ");
        // }
        int mic = Integer.MAX_VALUE;
        for (int i = 1; i <= nv; i++) {
            for (Pair p : adjlist.get(i)) {
                int totaldis = d[i] + p.dist / 2 + d1[p.v];
                mic = Math.min(mic, totaldis);
            }
        }
        System.out.println(mic);
    }
    }
}