import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_13439309 {
    private static List<Integer>[] tree;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());

        tree=new List[n+1];
        visited=new boolean[n+1];

        for(int i=0;i<=n;++i)
            tree[i]=new ArrayList<>();

        for(int i=0;i<n-1;++i) {
            st=new StringTokenizer(br.readLine());
            int node1=Integer.parseInt(st.nextToken());
            int node2=Integer.parseInt(st.nextToken());
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        int node1=explore1(1);
        Arrays.fill(visited,false);
        int ans=explore2(node1);
        System.out.println(ans);
    }

    private static int explore1(int root) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(root);

        int prev=-1;
        while (!queue.isEmpty()) {
            int node=queue.poll();
            visited[node]=true;
            prev=node;
            List<Integer> children=tree[node];
            for(int child:children) {
                if(visited[child])
                    continue;
                queue.add(child);
            }
        }
        return prev;
    }

    private static int explore2(int root) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(root);

        int itrCount=0;
        while (!queue.isEmpty()) {
            int size= queue.size();
            while (size>0) {
                int node=queue.poll();
                visited[node]=true;
                List<Integer> children=tree[node];
                for(int child:children) {
                    if(visited[child])
                        continue;
                    queue.add(child);
                }
                size--;
            }
            itrCount++;
        }
        return itrCount-1;
    }
}