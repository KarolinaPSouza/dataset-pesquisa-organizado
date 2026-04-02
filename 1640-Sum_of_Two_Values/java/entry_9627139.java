import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_9627139 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        String x = reader.readLine();
        String[] a = x.split(" ");
        int k = Integer.parseInt(a[1]);
        int[] b = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(n->Integer.parseInt(n))
                .toArray();
        ArrayList<List<Integer>> c = new ArrayList();
        for (int i = 0; i < b.length; ++i){
            c.add(List.of(b[i], i));
        }
        Collections.sort(c, (q,w) -> q.get(0) - w.get(0));
        int l = 0;
        int r = c.size() - 1;
        while (l < r){
            int sum = c.get(l).get(0) + c.get(r).get(0);
            if (sum == k){
                writer.println((c.get(l).get(1)+1) + " " + (c.get(r).get(1)+1));
                writer.flush();
                System.exit(0);
            }
            else{
                if (sum > k){
                    --r;
                }
                else{
                    ++l;
                }
            }
        }
        writer.println("IMPOSSIBLE");
        writer.flush();
    }
}