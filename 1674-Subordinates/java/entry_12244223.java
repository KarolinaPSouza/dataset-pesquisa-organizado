
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_12244223 {
    static QuickReader fs = new QuickReader();
    static PrintWriter out = new PrintWriter(System.out);

    static void output() {
        int n = fs.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        int[] arr = new int[n-1];
        for(int i=0;i<n-1;i++){
            arr[i] = fs.nextInt()-1;
            set.add(i);
        }
        set.add(n-1);
        int[] ans = new int[n];
        int[] edgeCount = new int[n];
        for(int val: arr){
            edgeCount[val]++;
            set.remove(val);
        }
        while(!set.isEmpty()){
            int x = set.pollFirst();
            int manager = arr[x-1];
            edgeCount[manager]--;
            ans[manager] += ans[x] + 1;
            if(edgeCount[manager] == 0 && manager != 0){
                set.add(manager);
            }
        }

        printArray(ans);
    }

    public static void main(String[] args) {
        int T = 1;
        //T = fs.nextInt();
        for (int tt = 0; tt < T; tt++) {
            output();
            out.flush();
        }
    }

    static void printArray(int[] a) {
        for (int i : a) out.print(i + " ");
        out.println();
    }

    static void printlnArray(int[] a) {
        for (int i : a) out.println(i);
    }

    static void printMatrix(int[][] a) {
        for (int[] i : a)
            printArray(i);
    }

    static void sortA(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }

    static void sortD(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l, (i, j) -> j - i);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }

    static class QuickReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}