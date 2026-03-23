import java.io.*;
import java.util.*;

class Solution {
    private static StreamTokenizer in;
    private static StreamTokenizer in2;
    private static PrintWriter out;

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static long nextInt2() throws IOException {
        in2.nextToken();
        return (long) in2.nval;
    }

    public static String next() throws IOException {
        in.nextToken();
        while (in.sval == null) in.nextToken();
        return in.sval;
    }

    public static void main(String[] args) throws IOException {

//        Scanner in = new Scanner(new BufferedInputStream(System.in));
//        Scanner in = new Scanner(new FileInputStream("src\\main\\resources\\test_input.txt"));
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//        in = new StreamTokenizer(new BufferedReader(new FileReader("src\\main\\resources\\test_input.txt")));
//        in2 = new StreamTokenizer(new BufferedReader(new FileReader("src\\main\\resources\\test_output.txt")));
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = nextInt();
        if (n == 1) {
            out.print(0);
            out.flush();
            return;
        }
        Map<Integer, ArrayList<Integer>> tree = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt() - 1;
            int b = nextInt() - 1;
            tree.compute(a, (ignore, set) -> set == null ? new ArrayList<>() : set).add(b);
            tree.compute(b, (ignore, set) -> set == null ? new ArrayList<>() : set).add(a);
        }

        int[] toLeaf = new int[n];
        int maxD = 0;
        boolean[] visited = new boolean[n];
        boolean[] finished = new boolean[n];
        int size = 0;
        int[] stack = new int[n];

        while (size >=0) {
            int val = stack[size];
            if (!visited[val]) {
                visited[val] = true;

                for(int next : tree.get(val)) {
                    if (!visited[next]) {
                        stack[++size] = next;
                    }
                }
            } else {
                int max = 0;
                int a= 0;
                int b= 0;
                for(int next : tree.get(val)) {
                    if (!finished[next]) continue;
                    max = Math.max(max, toLeaf[next] + 1);
                    if (1+toLeaf[next] >= a) {
                        b= a;
                        a = 1 + toLeaf[next];
                    } else {
                        b = Math.max(b, 1 + toLeaf[next]);
                    }
                }
                toLeaf[val] = max;
                maxD = Math.max(maxD, a + b);
                finished[val] = true;
                size--;
            }
        }

        out.print(maxD);
        out.flush();

    }


}
