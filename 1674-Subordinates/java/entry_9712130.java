// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// public class entry_9712130 {


//     static void dfs(int employee, List<List<Integer>> adj, long[] subordinates){
//         int count =1;
//         for(int sub : adj.get(employee)){
//             dfs(sub, adj, subordinates);
//             count+=  subordinates[sub];
//         }
//         subordinates[employee] = count;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n =sc.nextInt();
//         List<List<Integer>> adj = new ArrayList<>();
//         for(int i =0; i<=n; i++){
//             adj.add(new ArrayList<>());

//         }

//         for(int i =2; i<=n;i++){
//             int boss = sc.nextInt();
//             adj.get(boss).add(i);
//         }
//         long subordinates[] = new long[n+1];
//         dfs(1, adj, subordinates);

//         for( int i =1; i<=n; i++){
//             System.out.print(subordinates[i]-1+ " ");
//         }


//     }
// }

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class entry_9712130 {

    static void dfs(int employee, List<List<Integer>> adj, long[] subordinates) {
        Stack<Integer> stack = new Stack<>();
        Stack<Boolean> finished = new Stack<>();
        stack.push(employee);
        finished.push(false);

        while (!stack.isEmpty()) {
            int current = stack.peek();
            boolean isFinished = finished.pop();

            if (isFinished) {
                stack.pop();
                int count = 1; // including the current node itself
                for (int sub : adj.get(current)) {
                    count += subordinates[sub];
                }
                subordinates[current] = count;
            } else {
                finished.push(true);
                for (int sub : adj.get(current)) {
                    stack.push(sub);
                    finished.push(false);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        String[] bosses = br.readLine().split(" ");
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(bosses[i - 2]);
            adj.get(boss).add(i);
        }

        long[] subordinates = new long[n + 1];
        dfs(1, adj, subordinates);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(subordinates[i] - 1).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
