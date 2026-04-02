import java.util.*;
import java.io.*;

public class entry_5454819 {

    static class Kattio extends PrintWriter {

        private BufferedReader r;

        private StringTokenizer st;


        public Kattio() { this(System.in, System.out); }

        public Kattio(InputStream i, OutputStream o) {

            super(o);

            r = new BufferedReader(new InputStreamReader(i));

        }

        public String next() {

            try {

                while (st == null || !st.hasMoreTokens())

                    st = new StringTokenizer(r.readLine());

                return st.nextToken();

            } catch (Exception e) { }

            return null;

        }

        public int nextInt() { return Integer.parseInt(next()); }

        public double nextDouble() { return Double.parseDouble(next()); }

        public long nextLong() { return Long.parseLong(next()); }

    }

    public static ArrayList<Integer>[] adj; //Array of ArrayLists
    public static int[] dist, parent;
    public static int n, m;
    public static void main(String[] args) throws IOException {
        //Scanner in = new Scanner(System.in);
        Kattio io = new Kattio();
        n = io.nextInt(); m = io.nextInt();

        adj = new ArrayList[n];
        for(int i=0; i<n; i++)
            adj[i] = new ArrayList<Integer>();
        for(int i=0; i<m; i++) {
            int a = io.nextInt()-1; int b = io.nextInt()-1;
            adj[a].add(b); adj[b].add(a);
        }

        bfs(0);
        if(dist[n-1]==-1)
            System.out.println("IMPOSSIBLE");
        else {
            System.out.println(dist[n-1]+1);

            int[] res = new int[dist[n-1]+1];
            int x = dist[n-1];
            for(int i=n-1; i>0; i=parent[i])
                res[x--] = i;

            for(int i=0; i<res.length-1; i++)
                System.out.print(res[i]+1 + " ");
            System.out.println(res[res.length-1]+1);
        }

    }

    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<Integer>();
        //MyPair p = new MyPair(node, -1); //wait but I never changed my key, is this right
        ArrayList<Integer> path = new ArrayList<Integer>();
        //Queue<ArrayList<Integer>> paths = new LinkedList<ArrayList<Integer>>();
        dist = new int[n];
        parent = new int[n];
        Arrays.fill(dist, -1);
        dist[node] = 0;
        q.add(node);
        //paths.add(new ArrayList<Integer>(Arrays.asList(node)));

        while(q.size()>0) {
            node = q.poll();
            //ArrayList<Integer> path = paths.poll();
            //int lastNode = path.get(path.size()-1);
            for(int e : adj[node]) {
                if(dist[e]==-1) {
                    dist[e] = dist[node]+1;
                    q.add(e);
                    parent[e] = node;
                }

                //ArrayList<Integer> new_path = path;
                //new_path.add(e);
                //paths.add(new_path);
            }
            //if(node==n-1) {
            //    p.setValue(node);
            //    path = p.value();
            //    return;
            //}
            //if(lastNode == n-1)
            //    return path;
        }
        //return new ArrayList<Integer>(Arrays.asList(0));
    }

    /*
    public static class MyPair
    {
        private int key;
        private int value;
         public MyPair(int aKey, int aValue)
        {
            key   = aKey;
            value = aValue;
        }
         public int key()   { return key; }
        public int value() { return value; }
         public void setKey(int key) { this.key = key; }
        public void setValue(int value) { this.value = value; }
    }
     */
}