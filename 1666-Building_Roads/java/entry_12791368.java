import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class entry_12791368 {

    static class DS{
        int[] parent;
        int[] size;
        DS(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int findUParent(int node){
            if(node==parent[node]) return node;
            int up = findUParent(parent[node]);
            parent[node] = up;
            return up;
        }
        public void union(int u, int v){
            int up = findUParent(u);
            int vp = findUParent(v);
            if(up==vp) return ;
            if(size[up]<size[vp]){
                parent[up] = vp;
                size[vp]+=size[up];
            }
            else{
                parent[vp] = up;
                size[up]+=size[vp];
            }

        }
    }

    public static void findMST(int[][] edges, int n, int m) {

        DS ds = new DS(n+1);
        for(int i=0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            ds.union(u,v);
        }

        HashSet<Integer> uniques = new HashSet<>();

        int lead = -1;
        for(int i=1;i<=n;i++){
            int up = ds.findUParent(i);
            uniques.add(up);
            if(lead==-1){
                lead = up;
            }
        }
        uniques.remove(lead);
        StringBuilder sb = new StringBuilder("");
        sb.append(uniques.size()).append("\n");
        for(int vertex : uniques){
            sb.append(lead).append(" ").append(vertex).append("\n");
        }

        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        findMST(edges, n, m);

    }
}