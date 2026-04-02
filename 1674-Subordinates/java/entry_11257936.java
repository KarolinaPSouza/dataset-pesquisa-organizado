import java.io.*;
import java.util.*;

public class entry_11257936 {
    public static void entry_11257936(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));

        int n = Integer.parseInt(reader.readLine());
        List<List<Integer>> tree = new ArrayList<>(n + 1);
        int[] subordinates = new int[n + 1];
        boolean[] visited = new boolean[n + 1]; // 記錄是否已訪問過的節點

        // 初始化鄰接表
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        // 讀取輸入並構建樹
        String[] input = reader.readLine().split(" ");
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(input[i - 2]);
            tree.get(boss).add(i);
        }

        // 使用顯式堆疊模擬 DFS
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> postOrder = new Stack<>(); // 後序順序棧

        // 初始化堆疊，從節點 1 開始
        stack.push(1);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            postOrder.push(current); // 將節點加入後序棧
            for (int child : tree.get(current)) {
                stack.push(child); // 將子節點加入堆疊
            }
        }

        // 反向處理後序順序棧，計算下屬數量
        while (!postOrder.isEmpty()) {
            int current = postOrder.pop();
            for (int child : tree.get(current)) {
                subordinates[current] += 1 + subordinates[child];
            }
        }

        // 輸出結果
        for (int i = 1; i <= n; i++) {
            writer.print(subordinates[i] + " ");
        }
        writer.flush();
        writer.close();
    }
}