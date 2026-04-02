import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;
public class entry_14318362 {
    public static void main (String[] args) throws java.lang.Exception {
        FastReader input=new FastReader();
        FastWriter output=new FastWriter();
//        int testcases=input.nextInt();
        int testcases=1;
        while (testcases>0){
            int n=input.nextInt();
            int x=input.nextInt();
            TreeSet<Integer> set=new TreeSet<>();
            Integer[]arr=new Integer[n];
            for (int i=0;i<n;i++){
                int a=input.nextInt();
                arr[i]=a;
                set.add(a);
            }
            Arrays.sort(arr);
            int[] dp=new int[x+1];
            for (int i=0;i<=x;i++){
                dp[i]=Integer.MAX_VALUE;
            }
            for (int i=1;i<=x;i++){
                if (binarySearch(arr,0,n-1,i)!=-1){
                    dp[i]=1;
                }
                else {
                    for (Integer j:arr){
                        if (j<i && dp[i-j]!=Integer.MAX_VALUE){
                            dp[i]=Math.min(dp[i],1+dp[i-j]);
                        }
                        if (j>i){
                            break;
                        }
                    }
                }
            }

            if (dp[x]==Integer.MAX_VALUE){
                System.out.println(-1);
            }
            else {
                System.out.println(dp[x]);
            }
            testcases--;
        }
    }
    private static HashMap sortValues(HashMap map)
    {
        List list = new LinkedList(map.entrySet());
//Custom Comparator
        Collections.sort(list, new Comparator()
        {
            public int compare(Object o1, Object o2)
            {
                return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
            }
        });
//copying the sorted list in HashMap to preserve the iteration order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();)
        {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
    static int lower_bound(int array[], int key) {
        int low = 0, high = array.length;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (key <= array[mid]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        if (low < array.length && array[low] < key) {
            low++;
        }
        return low;
    }
    static int upper_bound(int arr[], int key) {
        int mid, N = arr.length;
        int low = 0;
        int high = N;
        while (low < high && low != N) {
            mid = low + (high - low) / 2;
            if (key >= arr[mid]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        if (low == N ) {
            return -1;
        }
        return low;
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] visited=new int[n][m];
        int count=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]>=1){
                    count=BFS(grid,visited,i,j,0);
                }
                max=Math.max(count,max);
            }
        }
        return max;
    }
    public static int binarySearch(Integer[] arr, int l, int r, int x)
    {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == x)
                return m;
            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }
    public static int BFS(int[][]grid,int[][]visited,int i,int j,int count){
        visited[i][j]=1;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(i, j));

        count+=grid[i][j];
        int n=grid.length;
        int m=grid[0].length;

        int[] delRow={-1,1,0,0};
        int[] delCol={0,0,-1,1};
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.poll();

            for(int k=0;k<4;k++){
                int nrow=row+delRow[k];
                int ncol=col+delCol[k];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]>=1){
                    count+=grid[nrow][ncol];
                    visited[nrow][ncol]=1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
        return count;
    }
    static class Pair{
        int first;
        int second;
        Pair(int fst,int scnd){
            this.first=fst;
            this.second=scnd;
        }
    }
    static boolean dp(int n,int m){
        if (m==n){
            return true;
        }
        else if(m>n || n%3!=0){
            return false;
        }
        return dp(n/3,m) || dp(2*(n/3),m);
    }
    static boolean isPowerOfTwo(int n)
    {
        return (int)(Math.ceil((Math.log(n) / Math.log(2))))
                == (int)(Math.floor(((Math.log(n) / Math.log(2)))));
    }
    static boolean isPowerOfThree(int n)
    {
        return (int)(Math.ceil((Math.log(n) / Math.log(3))))
                == (int)(Math.floor(((Math.log(n) / Math.log(3)))));
    }

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // Function to find gcd of array of
    // numbers
    static int findGCD(int arr[], int n)
    {
        int result = arr[0];
        for (int element: arr){
            result = gcd(result, element);

            if(result == 1)
            {
                return 1;
            }
        }

        return result;
    }



    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
}