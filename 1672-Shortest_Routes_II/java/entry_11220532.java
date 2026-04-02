import java.io.*;
import java.util.*;
public class entry_11220532 {
    static class Graph {
    private List<List<Pair>> wg;
    private List<List<Integer>> g;
    private int[] dist;
    private boolean[] visited;

    public Graph(int[][] edgeList, int numVertices, boolean isWeighted) {
        if(!isWeighted)
        {
            g = new ArrayList<>(numVertices);
            for (int i = 0; i < numVertices; i++) 
            {
                g.add(new ArrayList<>());
            }
            buildAdjList(edgeList);
        }
        else
        {
            wg = new ArrayList<>(numVertices);
            for (int i = 0; i < numVertices; i++)
                wg.add(new ArrayList<>());
            buildWeightedAdjList(edgeList);
        }

        dist = new int[numVertices];
        Arrays.fill(dist, -1);

        visited = new boolean[numVertices];
        Arrays.fill(visited, false);
    }

    private void buildAdjList(int[][] edgeList) {
        for (int[] edge : edgeList) {
            int src = edge[0];
            int dest = edge[1];
            g.get(src).add(dest);
            g.get(dest).add(src); // For undirected graph
        }
    }

    private void buildWeightedAdjList(int[][] edgeList) {
        for (int[] edge : edgeList) {
            int src = edge[0];
            int dest = edge[1];
            int weight = edge[2];
            wg.get(src).add(new Pair(dest, weight));
            wg.get(dest).add(new Pair(src, weight)); // For undirected graph
        }
    }

    public void bfsDistance(int src) {

        dist[src] = 0;
        visited[src] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Pair neighbor : wg.get(current)) {
                if (!visited[neighbor.vertex]) {
                    visited[neighbor.vertex] = true;
                    dist[neighbor.vertex] = dist[current] + 1; // Distance in terms of edges only
                    queue.offer(neighbor.vertex);
                }
            }
        }
    }
}

    private static class Pair {
        int vertex;
        int weight;

        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    static class Fast{
        BufferedReader br;
        StringTokenizer st;
        BufferedWriter bw;
        Fast() throws IOException{
            br=new BufferedReader(new InputStreamReader(System.in));
            bw=new BufferedWriter(new OutputStreamWriter(System.out));
            st=new StringTokenizer(br.readLine());
        }

        String next() throws IOException {
            if(st.hasMoreTokens()){
                return st.nextToken();
            }
            else{
                st=new StringTokenizer(br.readLine());
                return st.nextToken();
            }
        }

        String nextLine() throws IOException{
            String str;
            if(st.hasMoreTokens()){
                str = st.nextToken("\n");
            }
            else{
                str = br.readLine();
            }
            return str;
        }
        int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
        long nextLong() throws IOException{
            return Long.parseLong(next());
        }
        double nextDouble() throws IOException{
            return Double.parseDouble(next());
        }
        void print(Object o) throws IOException{
            String s=String.valueOf(o);
            bw.write(s);
            bw.flush();
        }
        void println(Object o) throws IOException{
            String s=String.valueOf(o);
            bw.write(s+"\n");
            bw.flush();
        }
    }
    static class FastInput {
    private InputStream is;
    private byte[] buffer;
    private int index, totalBytes;
    private PrintWriter out;

    public FastInput() {
        is = System.in;
        buffer = new byte[1024];
        out = new PrintWriter(System.out);
    }

    private int read() throws IOException {
        if (index >= totalBytes) {
            index = 0;
            totalBytes = is.read(buffer);
            if (totalBytes <= 0) {
                return -1; // EOF
            }
        }
        return buffer[index++];
    }

    public String next() throws IOException {
        StringBuilder sb = new StringBuilder();
        int b = read();
        while (b <= ' ') { // Skip whitespace
            b = read();
        }
        while (b > ' ') { // Read until whitespace
            sb.append((char) b);
            b = read();
        }
        return sb.toString();
    }

    public int nextInt() throws IOException {
        int num = 0;
        int b = read();
        boolean negative = false;

        // Handle sign
        if (b == '-') {
            negative = true;
            b = read();
        }

        // Read digits
        while (b >= '0' && b <= '9') {
            num = num * 10 + (b - '0');
            b = read();
        }

        return negative ? -num : num;
    }

    public long nextLong() throws IOException {
        long num = 0;
        int b = read();
        boolean negative = false;

        // Handle sign
        if (b == '-') {
            negative = true;
            b = read();
        }

        // Read digits
        while (b >= '0' && b <= '9') {
            num = num * 10 + (b - '0');
            b = read();
        }

        return negative ? -num : num;
    }

    public void println(Object obj) {
        out.println(obj);
    }

    public void flush() {
        out.flush();
    }
}

    //BFS and DFS
        //4 directions
        static int x4[]={1,-1,0,0}; static int y4[]={0,0,1,-1};
        //8 directions
        static int xi[]={-1,-1,0,1,1,1,0,-1}; static int yi[]={0,1,1,1,0,-1,-1,-1};

        static int count=1;
        //DFS
        static void dfs(int arr[][],int i, int j)
        {
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]!=-1)
            return;
        if(arr[i][j]==-1) //condition for visited or not
            arr[i][j]=count++;
        for(int k=0;k<4;k++)
            dfs(arr,i+x4[k],j+y4[k]);

        }

        //BFS
        static int bfs(int arr[][],int i, int j)
        {

            arr[i-1][j-1]=1;
            i--;
            j--;
            //bfs
            Queue<int[]> q=new LinkedList<>();
            q.add(new int[]{i,j});
            while(!q.isEmpty())
            {
                int cell[]=q.poll();
                int x=cell[0];
                int y=cell[1];
                //bfs on current cell i,j
                for(int k=0;k<4;k++)
                {
                    int x1=x+x4[k];
                    int y1=y+y4[k];
                    if(x1>=0 && x1<arr.length && y1>=0 && y1<arr[x1].length && arr[x1][y1]==0)
                    {
                        arr[x1][y1]=arr[x][y]+1;
                        q.add(new int[]{x1,y1});
                    }
                }
            }
                int ans=-1;
                for(int q1[] : arr)
                    for(int z : q1)
                        ans=Math.max(ans,z);
                return ans;
        }

    static int[] dijkstra(int src, List<List<Pair>> adjList, int n) {
        int[] dist = new int[n + 1]; // Distance array
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.weight));
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            // If the distance we popped is greater than the stored distance, we skip
            if (current.weight > dist[current.vertex]) {
                continue;
            }

            // Explore neighbors
            for (Pair neighbor : adjList.get(current.vertex)) {
                int newDist = dist[current.vertex] + neighbor.weight;
                if (newDist < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = newDist;
                    pq.add(new Pair(neighbor.vertex, newDist));
                }
            }
        }

        return dist;
    }

        static  void printMatrix(long m[][]){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                if(j == 0)
                    System.out.print(m[i][j]);
                else
                    System.out.print(" " +m[i][j]);
            }
        System.out.println();
        }
        System.out.println();
    }



    public static void main(String args[]) throws IOException {
        FastInput f = new FastInput();
        int n = f.nextInt();
        int me = f.nextInt();
        int q = f.nextInt();

        long BIG = 1000000000000000000L;
        // long BIG = 1000000000000000000L;
        int ed[][]=new int[n][3];
        List<List<Pair>> adjList = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        long fw[][] = new long [n+1][n+1];

        for(int i=0;i<n;i++)
        {
            Arrays.fill(fw[i], BIG);
        }

        for(int i=0;i<me;i++)
        {
            int u = f.nextInt();
            int v = f.nextInt();
            int w = f.nextInt();
            u--;
            v--;
            if(w<fw[u][v])
            {
                fw[u][v]=w;
                fw[v][u]=w;
            }
        }

        for(int m=0;m<n;m++)
        {
            // printMatrix(fw);
            for(int s=0;s<n;s++)
            {
                for(int e=0;e<n;e++)
                {
                    if( fw[s][m]!=BIG && fw[m][e]!=BIG && fw[s][e]>fw[s][m]+fw[m][e])
                    {
                        fw[s][e]=fw[s][m]+fw[m][e];
                        fw[e][s]=fw[s][m]+fw[m][e];
                    }
                }
            }

        }
        while(q--!=0)
        {

            int src = f.nextInt();
            int dst = f.nextInt();
            src--;
            dst--;
            if(src==dst)
                f.println(0);
            else
                f.println(fw[src][dst]==BIG?-1:fw[src][dst]);


        }


        f.flush();
    }
}