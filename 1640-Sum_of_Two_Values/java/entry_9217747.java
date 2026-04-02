//package SortingAndSearching;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class entry_9217747 {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = sc.nextInt();
        int x = sc.nextInt();

        int arr[] = new int[n];

        Map<Integer,Integer> hmap = new HashMap<>();

        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        int i;
        for(i = 0;i<n;i++)
        {
            if(hmap.containsKey(arr[i]))
            {
                System.out.println((hmap.get(arr[i])+1)+" "+(i+1));
                break;
            }
            hmap.put(x - arr[i],i);
        }

        if(i == n) System.out.println("IMPOSSIBLE");
//        out.println("something to print");
        out.close();
    }

    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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