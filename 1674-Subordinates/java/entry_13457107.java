import java.io.*;

public class entry_13457107 {

    static int[] size, parent, firstChild, nextSibling;
    static int n;

    static void dfs(int node) {
        size[node] = 1;
        for (int child = firstChild[node]; child != -1; child = nextSibling[child]) {
            dfs(child);
            size[node] += size[child];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        size = new int[n];
        parent = new int[n];
        firstChild = new int[n];
        nextSibling = new int[n];

        // Initialize arrays
        for (int i = 0; i < n; i++) {
            firstChild[i] = nextSibling[i] = -1;
        }

        // Build tree using linked-list representation
        String[] tokens = br.readLine().split(" ");
        for (int i = 1; i < n; i++) {
            int p = Integer.parseInt(tokens[i - 1]) - 1;
            parent[i] = p;
            nextSibling[i] = firstChild[p];
            firstChild[p] = i;
        }

        dfs(0);

        // Ultra-fast output using char array
        char[] output = new char[n * 8]; // generous buffer
        int pos = 0;

        for (int i = 0; i < n; i++) {
            int val = size[i] - 1;

            // Convert integer to chars manually (faster than append)
            if (val == 0) {
                output[pos++] = '0';
            } else {
                int start = pos;
                while (val > 0) {
                    output[pos++] = (char)('0' + val % 10);
                    val /= 10;
                }
                // Reverse the digits
                for (int j = start, k = pos - 1; j < k; j++, k--) {
                    char temp = output[j];
                    output[j] = output[k];
                    output[k] = temp;
                }
            }

            if (i < n - 1) output[pos++] = ' ';
        }

        System.out.print(new String(output, 0, pos));
        System.out.println();
    }
}