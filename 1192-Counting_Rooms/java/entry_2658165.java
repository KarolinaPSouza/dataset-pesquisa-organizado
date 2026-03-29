import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class entry_2658165 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] lines = new char[n][];
        for(int i=0; i<n; i++) {
            lines[i] = sc.next().toCharArray();
        }

        int count = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (visit(lines, i, j, n, m) > 0) count++;
            }
        }

        System.out.println(count);
        sc.close();
    }

    private static int visit(char[][] lines, int i, int j, int n, int m) {
        if (i>=n || j>=m || i<0 || j<0) {
            return 0;
        }
        int size = 0;

        Queue<Pair> queue = new LinkedList<>();

        if (lines[i][j] == '.') {
            queue.add(new Pair(i, j));
            while (!queue.isEmpty()) {
                Pair points = queue.poll();
                if (points.x < n && points.y < m && points.x >= 0 && points.y >= 0
                        && lines[points.x][points.y] == '.') {
                    size++;
                    lines[points.x][points.y] = '*';
                    queue.add(new Pair(points.x - 1, points.y));
                    queue.add(new Pair(points.x + 1, points.y));
                    queue.add(new Pair(points.x, points.y - 1));
                    queue.add(new Pair(points.x, points.y + 1));
                }
            }
        }

        return size;
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}