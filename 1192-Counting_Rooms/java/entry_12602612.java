import java.io.*;

public class entry_12602612 {

    static int n, m;
    static char[][] g;

    public static void main(String args[]) throws IOException {
        // File ip = new File("test_input.txt");
        // File op = new File("output.txt");
        // BufferedReader br = new BufferedReader(new FileReader(inputFile));
        // BufferedWriter log = new BufferedWriter(new FileWriter(outputFile));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        // Scanner sc = new Scanner(System.in);

        String nm[] = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        // n = sc.nextInt();
        // m = sc.nextInt();
        // sc.nextLine();
        g = new char[n][m];
        for (int i = 0; i < n; i++) {
            g[i] = br.readLine().toCharArray();
            // g[i] = sc.nextLine().toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '.') {
                    // g[i][j] = '#';
                    ans++;
                    dfs(i, j);
                }
            }
        }
        // int ans = 0;
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         if (g[i][j] == '.') {
        //             ans++;
        //             Queue<int[]> q = new LinkedList<>();
        //             q.offer(new int[]{i, j});
        //             g[i][j] = '-';
        //             while (!q.isEmpty()) {
        //                 int temp[] = q.poll();
        //                 for (int k = 0; k < 4; k++) {
        //                     int x = temp[0] + dx[k], y = temp[1] + dy[k];
        //                     if (isValid(x, y) && g[x][y] == '.') {
        //                         g[x][y] = '-';
        //                         q.offer(new int[]{x, y});
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }
        System.out.println(ans);
        // log.write(ans + "\n");
        // br.close();
        // log.flush();
    }

    static void dfs(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m || g[i][j] != '.') {
            return;
        }

        g[i][j] = '#';

        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}