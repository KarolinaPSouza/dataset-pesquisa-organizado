import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class entry_9599984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ip = br.readLine().split(" ");
        int n = Integer.parseInt(ip[0]);

        ArrayList<Integer>[] G = new ArrayList[n+1];
        for(int i = 0 ; i <= n ; i++)G[i] = new ArrayList<>();
        ip = br.readLine().split(" ");
        for(int i = 2 ; i <= n;  i++){
            int t = Integer.parseInt(ip[i-2]);
            G[t].add(i);
        }

        Stack<Integer> st = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        int[] par = new int[n+1];
        boolean[] vis = new boolean[n+1];
        int[] ans = new int[n+1];
        Arrays.fill(ans,1);
        st.push(1);
        par[1] = -1;

        while(!st.empty()){
            int node = st.pop();
            st2.push(node);
            vis[node] = true;

            for(int c : G[node]){
                if(!vis[c]){
                    st.push(c);
                    par[c] = node;
                }
            }
        }
        while(!st2.empty()){
            int node = st2.pop();
            if(par[node] != -1) ans[par[node]] += ans[node];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= n ; i++){
            sb.append(ans[i]-1).append(" ");
        }
        System.out.println(sb);
    }
}