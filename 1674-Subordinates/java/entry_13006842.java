import java.util.*;
import java.io.*;

public class entry_13006842  {
    public static int[] subordinates;
    public static List<Integer>[] tree; 
    static boolean[] visited;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        subordinates = new int[n+1];
        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=2; i<=n; i++){
            int boss = Integer.parseInt(st.nextToken());
            tree[boss].add(i);
        }
        dfsIterative(1);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(subordinates[i]).append(" ");
        }
        System.out.println(sb);
    }
    static void dfsIterative(int start) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> postOrder = new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()){
            int node = stack.pop();
            postOrder.push(node);
            for(int child : tree[node]){
                stack.push(child);
            }
        }
        while(!postOrder.isEmpty()){
            int node = postOrder.pop();
            for(int child : tree[node]){
                subordinates[node] += subordinates[child] +1;

            }
        }
    }
}
