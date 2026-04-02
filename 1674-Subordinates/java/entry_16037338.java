import java.io.*;
import java.util.*;

public class entry_16037338 {
    static class FileReader {
        BufferedReader br;
        StringTokenizer st;

        public FileReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());

            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
    static int ans[] ; 
    static void  dfs(int src, ArrayList<Integer> graph[]) {
        int count = 0;
        for (int des : graph[src]){
          dfs(des, graph) ;
          ans[src] += ans[des] ; 
        }

        ans[src]++ ;
    }

    public static int[] solve(int n, int[] arr) {
        ArrayList<Integer> graph[] = new ArrayList[n+1] ; 
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>() ;

        for (int i = 2; i <= n ; i++){
          graph[arr[i- 2]].add(i) ; 
        }

        ans = new int[n+ 1];
        dfs(1, graph);

        return ans;
    }

    public static void main(String[] args) throws Exception {
        FileReader fs = new FileReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = fs.nextInt();

        int arr[] = new int[n - 1];
        for (int i = 0; i < n - 1; i++)
            arr[i] = fs.nextInt();

        StringBuilder sb = new StringBuilder();
        int brr[] = solve(n, arr) ;
        for (int i = 1 ;  i <= n ; i++ ) {
            sb.append(brr[i] -1 );
            sb.append(" ");
        }

        out.print(sb.toString());

        out.flush();
        out.close();
    }
}