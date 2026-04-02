/*
ID: epicpla1
LANG: JAVA
TASK: sumtwo
*/

import java.util.*;
import java.io.*;

public class entry_9659377 {
    public void run() throws Exception {
        //FastScannersumTwo f = new FastScannersumTwo("entry_9659377".toLowerCase() + ".in");
        FastScannersumTwo f = new FastScannersumTwo();

        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("entry_9659377".toLowerCase() + ".out")));
        PrintWriter out = new PrintWriter(System.out);

        HashMap<Integer, Integer> map = new HashMap<>();
        int N = f.nextInt();
        int X = f.nextInt();

        for (int i = 1; i <= N; i++){
            int check = f.nextInt();
            if (map.containsKey(X-check)){
                out.println(map.get(X-check)+" "+i);
                out.flush();
                return;
            }
            else{
                map.put(check, i);
            }
        }
        out.println("IMPOSSIBLE");
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new entry_9659377().run();
    }
}

class FastScannersumTwo {
    BufferedReader br;
    StringTokenizer st;

    public FastScannersumTwo() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastScannersumTwo(String fileName) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(fileName));
    }

    String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return (Integer.parseInt(next()));
    }

    long nextLong() {
        return (Long.parseLong(next()));
    }

    double nextDouble() {
        return (Double.parseDouble(next()));
    }

    String nextLine() {
        String str = "";
        try {
            if (st != null && st.hasMoreTokens()) {
                str = st.nextToken("\n");
            } else {
                str = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
//Property of the One and Only KoKoa_Bean