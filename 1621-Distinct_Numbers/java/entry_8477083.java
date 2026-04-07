import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class entry_8477083 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        final int a = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        HashSet<Integer> map = new HashSet<Integer>();
        for (int i = 0; i< a;i++){
            map.add(Integer.parseInt(st.nextToken()));
        }
        out.print(map.size());
        out.close();
    }
}