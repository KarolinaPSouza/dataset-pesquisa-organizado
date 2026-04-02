import java.util.*;
import java.io.*;

public class entry_8422761 {

    static class Node {
        ArrayList<Node> friends;
        int val;

        Node (int val) {
            this.val = val;
            this.friends = new ArrayList<>();
        }

        Node (int val, ArrayList<Node> friends) {
            this.val = val;
            this.friends = friends;
        }

        @Override
        public String toString () {
            return String.valueOf(this.val);
        }

    }

    static BufferedReader io;
    static PrintWriter pw;
    static StringTokenizer st;
    static int [] colors;

    public static void main(String[] args) throws IOException {

        io = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(io.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node [] pupils = new Node[n];
        colors = new int[n];

        for (int i = 0; i < n; i++) {
            pupils[i] = new Node(i);
            colors[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(io.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pupils[a - 1].friends.add(pupils[b - 1]);
            pupils[b - 1].friends.add(pupils[a - 1]);
        }

        boolean possible = true;
        for (int i = 0; i < n; i++) {
            if (colors[pupils[i].val] == -1) {
                possible = dfs(pupils[i], 1);
            }
            if (!possible) {
                break;
            }
        }

        if (!possible) {
            pw.println("IMPOSSIBLE");
        } else {
            for (int i = 0; i < n; i++) {
                pw.print(colors[i] + " ");
            }
        }

        io.close();
        pw.close();
    }

    static boolean dfs (Node node, int color) {
        colors[node.val] = color;
        for (int i = 0; i < node.friends.size(); i++) {
            if (colors[node.friends.get(i).val] == -1) {
                if (!dfs(node.friends.get(i), 3-color)) {
                    return false;
                }
            } else {
                if (colors[node.friends.get(i).val] == colors[node.val]) {
                    return false;
                }
            }
        }
        return true;
    }

}