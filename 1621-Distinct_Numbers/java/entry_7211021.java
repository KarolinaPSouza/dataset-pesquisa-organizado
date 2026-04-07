import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class entry_7211021 {
    public static void main(String[] args) throws IOException {
        MiscReader in = new MiscReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();

        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            s.add(in.nextInt());
        }

        out.println(s.size());
        out.flush();
    }
}

class MiscReader {
    StringTokenizer st = new StringTokenizer("");
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public String readLine() {
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int nextInt() {
        if (!st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(in.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return Integer.parseInt(st.nextToken());
    }
}