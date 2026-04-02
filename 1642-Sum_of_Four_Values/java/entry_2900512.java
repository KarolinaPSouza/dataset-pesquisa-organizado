import java.io.*;
import java.util.*;

public class entry_2900512 {
    private static StreamTokenizer in;
    private static PrintWriter out;
    static int mod = (int) 1e9 + 7;

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }

    public static void main(String[] args) throws IOException {
//        in = new StreamTokenizer(new BufferedReader(new FileReader("C:\\Users\\admin\\IdeaProjects\\problems\\src\\main\\resources\\test_input.txt")));
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = nextInt();
        int k = nextInt();
        int[] arr = new int[n];
        int[] idxs = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
            idxs[i] = i;
        }

        Collections.sort(new AbstractList<Integer>() {
            @Override
            public int size() {
                return n;
            }

            @Override
            public Integer get(int index) {
                return idxs[index];
            }

            @Override
            public Integer set(int index, Integer element) {
                int prev = idxs[index];
                idxs[index] = element;
                return prev;
            }
        }, Comparator.comparingInt(x -> arr[x]));


        for (int i = 0; i < n - 2; i++) {
            for (int j = i+1; j < n; j++) {
                int l = j + 1;
                int r = n - 1;
                int target = k - arr[idxs[i]] - arr[idxs[j]];
                while (l < r) {
                    int sum = arr[idxs[l]] + arr[idxs[r]];
                    if (sum == target) {
                        out.println((idxs[i] + 1) + " " + (idxs[j] + 1) + " " + (idxs[l] + 1) + " " + (idxs[r] + 1));
                        out.flush();
                        return;
                    }
                    if (sum > target) r--;
                    else l++;
                }
            }
        }

        out.println("IMPOSSIBLE");
        out.flush();
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static int[][] shuffle(int[][] customers) {
        int n = customers.length;
        Random r = new Random(System.currentTimeMillis());
        int next;
        int[] tmp = new int[customers[0].length];
        for (int i = 0; i < n / 4; i++) {
            next = r.nextInt(n);
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = customers[i][j];
            }

            for (int j = 0; j < tmp.length; j++) {
                customers[i][j] = customers[next][j];
            }
            for (int j = 0; j < tmp.length; j++) {
                customers[next][j] = tmp[j];
            }
        }
        return customers;
    }

    private static int parent(int[] parent, int i) {
        if (i < 0) return -1;
        if (parent[i] == i) return i;
        return parent[i] = parent(parent, parent[i]);
    }

    private static int[] shuffle(int[] apps) {
        int n = apps.length;
        Random r = new Random(System.currentTimeMillis());
        int tmp, next;
        for (int i = 0; i < n / 10; i++) {
            next = r.nextInt(n);
            tmp = apps[i];
            apps[i] = apps[next];
            apps[next] = tmp;
        }
        return apps;
    }


}