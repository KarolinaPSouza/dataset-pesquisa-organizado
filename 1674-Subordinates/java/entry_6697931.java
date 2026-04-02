import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class entry_6697931 {

    public static void main(String[] args) throws IOException {
        var inputStreamReader = new InputStreamReader(System.in);
        var bufferedReader = new BufferedReader(inputStreamReader);
        var n = Integer.parseInt(bufferedReader.readLine());
        var edges = new ArrayList<ArrayList<Integer>>(Collections.nCopies(n + 1, new ArrayList<Integer>())).stream()
                .map(l -> new ArrayList<Integer>())
                .collect(Collectors.toList());
        var res = new int[n + 1];
        var vis = new int[n + 1];
        Arrays.fill(res, 0);
        Arrays.fill(vis, 0);

        var e = bufferedReader.readLine().split(" ");
        for (int i = 0; i < e.length; i++) {
            edges.get(Integer.parseInt(e[i])).add(i + 2);
        }
        inputStreamReader.close();
        bufferedReader.close();

        var stack = new Stack<Integer>();
        stack.add(1);

        while (!stack.isEmpty()) {
            var head = stack.pop();
            var nodes = edges.get(head);
            if (vis[head] == 0) {
                stack.add(head);
                for (int i = 0; i < nodes.size(); i++) {
                    stack.add(nodes.get(i));
                }
                vis[head]++;
            } else {
                for (int i = 0; i < nodes.size(); i++) {
                    res[head] += 1 + res[nodes.get(i)];
                }
            }
        }

        var sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(res[i] + " ");
        }

        System.out.println(sb.toString());
    }
}