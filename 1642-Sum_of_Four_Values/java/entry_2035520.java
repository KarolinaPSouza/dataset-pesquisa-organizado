import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")
public class entry_2035520 {
    public static ArrayList<Pair> list = new ArrayList();
    public static void main(String args[]) {
        FastReader input = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        try {
        int n = input.nextInt();
        int x = input.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++) arr[i] = input.nextInt();
        Map<Integer, ArrayList<Integer>> map = new HashMap();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(arr[i])) {
                ArrayList<Integer> list = map.get(arr[i]);
                list.add(i);
                map.put(arr[i], list);
            }else {
                ArrayList<Integer> list = new ArrayList();
                list.add(i);
                map.put(arr[i], list);
            }
        }   
        // out.println(map);
        Arrays.sort(arr);
        boolean flag = false;
        for(int i = 0; i < n - 3; i++) {
            for(int j = i + 1; j < n - 2; j++) {
                int l = j + 1;
                int r = n - 1;
                long sum = 0;
                while(l < r) {
                    sum = arr[i] + arr[j] + arr[l] + arr[r];
                    if(sum == x) {
                        int num1, num2, num3, num4;
                        num1 = num2 = num3 = num4 = -1;
                        if(map.get(arr[i]).size() > 0){
                            num1 = map.get(arr[i]).get(0);
                            map.get(arr[i]).remove(0);
                        }
                        if(map.get(arr[j]).size() > 0){
                            num4 = map.get(arr[j]).get(0);
                            map.get(arr[j]).remove(0);
                        }
                        if(map.get(arr[l]).size() > 0){
                            num2 = map.get(arr[l]).get(0);
                            map.get(arr[l]).remove(0);
                        }
                        if(map.get(arr[r]).size() > 0){
                            num3 = map.get(arr[r]).get(0);
                            map.get(arr[r]).remove(0);
                        }
                        out.print((num1+1)+" "+(num2+1)+" "+(num3+1)+" "+(num4+1));
                        flag = true;
                        break;
                    }
                    if(sum > x) {
                        r--;
                    }else {
                        l++;
                    }
                }
            if(flag) break;

            }
            if(flag) break;

        }
        if(flag == false) out.println("IMPOSSIBLE");
        }catch(Exception e) {out.println(e); out.flush();}
        out.flush();
    }
}

class Pair implements Comparable<Pair> {    
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int first() {
        return x;
    }
    public int second() {
        return y;
    }

    public int compareTo(Pair p) {
        if(this.second() == p.second()) {
            return 0;
        }else if(this.second() > p.second()) {
            return 1;
        }else {
            return -1;
        }
    } 
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    public String next() {
        while(st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }catch(Exception e) {
                System.out.println(e);
            }
        }     
        return st.nextToken();
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public String getString() {
        return next();
    }
}