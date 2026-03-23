import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;

public class entry_9573265 {
    static int mod;
    static long dp[][];

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        while (t-- > 0) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long temp = Math.max(x, y) - 1;
            long num = (long) (temp * (temp + 1)) + 1;
            long cal = (long) Math.abs(x - y);

            if (Math.max(x, y) % 2 == 0) { // smaller to greater
                if (x > y) {
                    num += cal;
                } else if(y > x){
                    num -= cal;
                }
            } else { // bigger to smaller
                if (x > y) {
                    num -= cal;
                } else if(y > x){
                    num += cal;
                }
            }
            out.println(num);
        }
        out.close();
    }

    public static long solve(int index, int[] arr, int x) {
        if (x < 0) return 0;
        if (x == 0) return 1;

        if (dp[index][x] != -1) return dp[index][x];

        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += solve(i, arr, x - arr[i]);
        }
        return dp[index][x] = ans;
    }
    public static int getSum(int num,int n){
        int sum = 0;
        for(int i = num ; i <= n; i+= num){
            sum += i;
        }
        return sum;
    }

    public static int getLcm(int a, int b) {
        return (a * b / getGcd(a, b));
    }

    public static int dfs(int r,int c,int[][] visited,char[][] arr)
    {
        int n = arr.length;
        int m = arr[0].length;
        visited[r][c] = 1;

        int di[] = {1,-1,0,0};
        int dj[] = {0,0,1,-1};
        int temp = 0, ans = 0;

        for(int k = 0; k < 4; k++)
        {
            int ni = r + di[k];
            int nj = c + dj[k];
            if(ni >= 0 && nj >= 0 && ni < n && nj < m && arr[ni][nj] == '#')
            {
                return 0;
            }
        }

        for(int k = 0; k < 4; k++)
        {
            int ni = r + di[k];
            int nj = c + dj[k];
            if(ni >= 0 && nj >= 0 && ni < arr.length && nj < arr[0].length && arr[ni][nj] == '.' && visited[ni][nj] == 0) {
                temp = 1 + dfs(ni, nj, visited, arr);
                ans += temp;
            }
        }
        return ans;
    }
    public static boolean isVowel(char c)
    {
        if(c == 'a' || c=='A' || c=='e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c=='O' || c == 'u' || c == 'U' || c == 'y' || c=='Y') return true;
        return false;
    }
    public static void swap(int i,int j,int arr[])
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static int solve(int[] arr,int n,int k){
        if(k == 0) return 0;

        int sum = 0, count = 0;
        Arrays.sort(arr);
        for(int i = n - 1; i >= 0; i--){
            if(sum >= k) break;
            count++;
            sum += arr[i];
        }
        return count;
    }

//    public static boolean isPrime(long n){
//        if(n == 1) return false;
//
//        if(n == 2 || n == 3) return true;
//
//        if(n % 2 == 0 || n % 3 == 0) return false;
//
//        boolean flag = false;
//
//        for(long i = 5; i * i <= n; i++){
//            if(n % i == 0){
//                return false;
//            }
//        }
//        return true;
//    }

    public static boolean isPal(long n)
    {
        long temp = n;
        long sum = 0;
        while(temp != 0)
        {
            long rem = temp % 10;
            sum = sum * 10 + rem;
            temp /= 10;
        }
        return (sum == n);
    }
    public static boolean[] seive()
    {
        boolean ans[]= new boolean[1000000 + 1];
        ans[0] = ans[1] = true;
        for(int i = 2; i <= 1000000; i++)
        {
            if(ans[i] == true) continue;
            for(int j = 2 * i; j <= 1000000; j += i)
            {
                ans[j] = true;
            }
        }
        return ans;
    }
    public static int getGcd(int a,int b)
    {
        if(a == 0)
            return b;
        return getGcd(b % a, a);
    }


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

        String nextLine(){
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