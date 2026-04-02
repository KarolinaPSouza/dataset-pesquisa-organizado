import java.io.*;
import java.util.*;

public class entry_9415195 {
    static BufferedReader ins = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer in = new StreamTokenizer(ins);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static List<Integer> ans = new ArrayList<>();
    static Map<Integer, Set<Integer>> friends = new HashMap<>();

    public static void main(String[] args) throws IOException{
        in.nextToken();
        int n = (int)in.nval;
        in.nextToken();
        int m = (int)in.nval;
        for (int i = 0; i < n; i++) {
            ans.add(0);
            friends.put(i, new HashSet<>());
        }

        for (int i = 0; i < m; i++) {
            in.nextToken();
            int a = (int)in.nval;
            in.nextToken();
            int b = (int)in.nval;

            friends.get(a-1).add(b-1);
            friends.get(b-1).add(a-1);
        }


        outerLoop: for (int i = 0; i < n; i++) {
            if (ans.get(i) == 0) {
                Queue<Integer> queue = new LinkedList<>();
                ans.set(i, 1);
                queue.add(i);

                while (!queue.isEmpty()) {
                    Queue<Integer> tmpQueue = new LinkedList<>();
                    while (!queue.isEmpty()) {
                        int p = queue.poll();

                        int t = ans.get(p);
                        for (Integer e : friends.get(p)) {
                            if (ans.get(e) == t) {
                                ans.set(e, 0);
                                break outerLoop;
                            } else if (ans.get(e) == 0) {
                                ans.set(e, t == 1 ? 2 :1);
                                tmpQueue.add(e);
                            }
                        }
                    }
                    queue = tmpQueue;
                }
            }
        }

        if (!ans.contains(0)) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < n; i++) {
                s.append(ans.get(i)).append(" ");
            }
            s.setLength(s.length() - 1);
            out.print(s);
        } else {
            out.print("IMPOSSIBLE");
        }

        out.flush();
        out.close();
        ins.close();
    }
}