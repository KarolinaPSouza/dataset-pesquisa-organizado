import java.io.*;
import java.util.*;

public class entry_11328467 {

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    static int n, t;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));

//        br = new BufferedReader(new FileReader("/Users/kshitiz/IdeaProjects/Java-Templates-Algorithms/Algorithms/AaaaaInput.txt"));
//        out = new PrintWriter(new FileWriter("/Users/kshitiz/IdeaProjects/Java-Templates-Algorithms/Algorithms/Aaaaaout.txt"));

        int n = readInt();
        int arr[] = new int[n];
        Set<Integer> set = new HashSet();
        for(int x=0;x<n;x++) 
         set.add(readInt());

        out.println(set.size());

        out.close();

    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }
}