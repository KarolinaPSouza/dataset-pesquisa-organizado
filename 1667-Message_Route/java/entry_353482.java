import java.util.*;
import java.io.*;

/**
 * CSES ProblemSet: Graph: Building Roads
 * @author amaheshwari
 * @version 03.13.20
 * - finding connected components
 */

@SuppressWarnings("Duplicates")
public class entry_353482 {

    static int n, m;
    static List<Integer>[] conn;
    static int[] dist;
    static int[] par;


    public static void main(String[] arg) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(f.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        conn = new List[n+1];
        dist = new int[n+1];
        par = new int[n+1];

        for(int i = 1; i <= n; i++){
            conn[i]=new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            conn[a].add(b);
            conn[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        Arrays.fill(dist, -1);
        dist[1]=1; // really number of nodes on path
        int curr;
        boolean found = false;
        while(!q.isEmpty()){
            curr = q.poll();

            for(int x: conn[curr]){
                if(dist[x]==-1){
                    dist[x]=dist[curr]+1;
                    par[x]=curr;
                    q.add(x);
                    if(x==n){found=true; break;}
                }
            }
        }

        if(!found){ pw.println("IMPOSSIBLE"); pw.close(); return; }
        pw.println(dist[n]);
        int[] sp = new int[dist[n]-1]; // everything except n
        int fin = n;
        for(int i = sp.length-1; i>=0; i--){
            sp[i]=par[fin];
            fin=par[fin];
        }

        for(int i = 0; i < sp.length; i++){
            pw.print(sp[i] + " ");
        }
        pw.println(n);

        pw.close();
    }



}