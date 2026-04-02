
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class entry_6241662 {
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws FileNotFoundException {
        //InputStream inputStream = new FileInputStream("test_input.txt");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] parent = new int[n+1];
        parent[1] = -1;
        int t  = 2;
        while (t<=n){
            parent[t] = scanner.nextInt();
            t++;
        }
        scanner.close();
        int[] in_degree = new int[n+1];
        for(int i=2;i<=n;i++){
            in_degree[parent[i]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=2;i<=n;i++){
            if(in_degree[i]==0){
                queue.add(i);
            }
        }
       int[] dp = new int[n+1];

        while (!queue.isEmpty()){
            int emp = queue.poll();
            if(parent[emp]==-1) break;
            dp[parent[emp]] += dp[emp]+1;
            in_degree[parent[emp]]--;
            if(in_degree[parent[emp]]==0){
                queue.add(parent[emp]);
            }
        }
        for(int i=1;i<=n;i++){
            out.print(dp[i]+" ");
            if(i%1000==0){
                out.flush();
            }
        }
        out.flush();
        out.close();
    }

}