import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_15347361 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        List<List<Integer>> graph=new ArrayList<>();
        for (int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for (int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] visited=new int[n+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        visited[1]=1;
        //boolean found=false;
        while (!q.isEmpty()){
            int x=q.poll();
            if (x==n){
                break;
            }
            for (int y: graph.get(x)){
                if (visited[y]==0){
                    visited[y]=x;
                    q.add(y);
                }
            }
        }
        if (visited[n]==0){
            out.println("IMPOSSIBLE");
        }
        else {
            List<Integer> values=new ArrayList<>();
            int z = n;
            //out.println(Arrays.toString(visited));
            int op = 1;
            while (visited[z] != z) {
                values.add(z);
                z = visited[z];
                op++;
            }
            out.println(op);
            out.print(1+" ");
            for (int i=values.size()-1;i>=0;i--){
                out.print(values.get(i)+" ");
            }
            out.println();
        }
        out.flush();


    }
}