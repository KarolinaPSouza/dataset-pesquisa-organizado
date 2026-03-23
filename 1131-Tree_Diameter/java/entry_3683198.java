import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class entry_3683198 {
    private static int farthest, count;
    private static Edge[] edges;
    private static int[] latest;
    public static void main(String[]args)throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        edges = new Edge[2 * n - 1];
        latest = new int[n + 1];
        for(int i = 0; i < n - 1; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            addEdge(a, b, i * 2 + 1);
            addEdge(b, a, i * 2 + 2);
        }

        bfs(1);
        count = 0;
        bfs(farthest);
        pw.println(count - 1);
        pw.close();
    }

    private static void bfs(int start)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, -1));
        while(!q.isEmpty())
        {
            int width = q.size();
            for(int k = 0; k < width; k++)
            {
                Node node = q.poll();
                for(int i = latest[node.val]; i != 0; i = edges[i].prevEdge)
                {
                    if(edges[i].to != node.parent)
                        q.add(new Node(edges[i].to, node.val));
                }
                farthest = node.val;
            }
            count++;
        }
    }
    private static void addEdge(int from, int to, int id)
    {
        edges[id] = new Edge(to, latest[from]);
        latest[from] = id;
    }

    static class Edge
    {
        int to, prevEdge;

        public Edge(int a, int b)
        {
            to = a;
            prevEdge = b;
        }
    }

    static class Node
    {
        int val, parent;

        public Node(int a, int b)
        {
            val = a;
            parent = b;
        }
    }
}