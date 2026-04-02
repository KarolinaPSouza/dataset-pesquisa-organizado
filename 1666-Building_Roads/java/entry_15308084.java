import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class DSU{
    public int[] size;
    public int[] parent;

    public DSU(int n){
        size = new int[n+1];
        parent = new int[n+1];
        for(int i=0 ; i<=n ; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findParent(int node){
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }
    public void unionBySize(int a, int b){
        int u = findParent(a);
        int v = findParent(b);

        if(u==v) return;
        if(size[u] < size[v]){
            int temp = u; //swapping u and v
            u = v;
            v = temp;
        }
        size[u] += size[v];
        parent[v] = u;
    }
}
public class entry_15308084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());



        DSU ds = new DSU(n);
        for(int i=0 ; i<m ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            ds.unionBySize(u, v);
        }
        // sc.close();

        ArrayList<Integer>ans = new ArrayList<>();

        for(int i=1 ; i<=n ; i++){
            if(ds.findParent(i) == i){
                ans.add(i);
            }
        }

        if(ans.size() == 1){
            System.out.println(0);
        }
        else{
            System.out.println(ans.size() - 1);
            for(int i = 1; i < ans.size(); i++){
                System.out.println(ans.get(i-1) + " " + ans.get(i));
            }
        }





    }
}
