/*
    /$$$$$  /$$$$$$  /$$    /$$  /$$$$$$
   |__  $$ /$$__  $$| $$   | $$ /$$__  $$
      | $$| $$  \ $$| $$   | $$| $$  \ $$
      | $$| $$$$$$$$|  $$ / $$/| $$$$$$$$
 /$$  | $$| $$__  $$ \  $$ $$/ | $$__  $$
| $$  | $$| $$  | $$  \  $$$/  | $$  | $$
|  $$$$$$/| $$  | $$   \  $/   | $$  | $$
 \______/ |__/  |__/    \_/    |__/  |__/
 /$$$$$$$  /$$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$$   /$$$$$$  /$$      /$$ /$$      /$$ /$$$$$$$$ /$$$$$$$
| $$__  $$| $$__  $$ /$$__  $$ /$$__  $$| $$__  $$ /$$__  $$| $$$    /$$$| $$$    /$$$| $$_____/| $$__  $$
| $$  \ $$| $$  \ $$| $$  \ $$| $$  \__/| $$  \ $$| $$  \ $$| $$$$  /$$$$| $$$$  /$$$$| $$      | $$  \ $$
| $$$$$$$/| $$$$$$$/| $$  | $$| $$ /$$$$| $$$$$$$/| $$$$$$$$| $$ $$/$$ $$| $$ $$/$$ $$| $$$$$   | $$$$$$$/
| $$____/ | $$__  $$| $$  | $$| $$|_  $$| $$__  $$| $$__  $$| $$  $$$| $$| $$  $$$| $$| $$__/   | $$__  $$
| $$      | $$  \ $$| $$  | $$| $$  \ $$| $$  \ $$| $$  | $$| $$\  $ | $$| $$\  $ | $$| $$      | $$  \ $$
| $$      | $$  | $$|  $$$$$$/|  $$$$$$/| $$  | $$| $$  | $$| $$ \/  | $$| $$ \/  | $$| $$$$$$$$| $$  | $$
|__/      |__/  |__/ \______/  \______/ |__/  |__/|__/  |__/|__/     |__/|__/     |__/|________/|__/  |__/
*/
import java.io.*;
import java.security.KeyPair;
import java.util.*;
import java.lang.*;
import java.math.*;
public class entry_6308614 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
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
                if (st.hasMoreTokens()) {
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

    static long gcd(long a, long b) { // return gcd of 2 numbers
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static long lcm(long a, long b) { //return lcm of 2 numbers
        return (a / gcd(a, b)) * b;
    }
    static int searchlower(int a[], long b,int s)   //To search element in an array using binary search
    {
        int start = s, end = a.length-1,f=-1;
        while (start <= end)
        {
            int mid = start + ((end - start) / 2);
            if (a[mid] == b) {f=mid;start=mid+1;}
            else if (a[mid] > b) end = mid - 1;
            else if (a[mid] < b) {f=mid;start = mid + 1;}
        }
        return f;
    }
    static int searchhigher(int a[], long b)   //To search element in an array using binary search
    {
        int start = 0, end = a.length-1,f=-1;
        while (start <= end)
        {
            int mid = start + ((end - start) / 2);
            if (a[mid] == b) {f=mid;start=mid+1;}
            else if (a[mid] > b) {f=mid;end = mid - 1;}
            else if (a[mid] < b) start = mid + 1;
        }
        return f;
    }
    static int search(long a[], long b)   //To search element in an array using binary search
    {
        int start = 0, end = a.length - 1;
        while (start <= end)
        {
            int mid = start + ((end - start) / 2);
            if (a[mid] == b) return mid;
            else if (a[mid] > b) end = mid - 1;
            else if (a[mid] < b) start = mid + 1;
        }
        return -1;
    }
    static int[] sortArray(int[] a)
    {
        final Random random = new Random();
        int n = a.length;
        for (int i = 0; i < n; i++)
        {
            int oi = random.nextInt(n), temp = (int) a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
        return a;
    }
    static void sortbyColumn(int arr[][], int col)
    {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[col],b[col]));
    }
    static boolean[] prime(int n) //to pre calculate prime number using sieve
    {
        boolean primecheck[] = new boolean[n+1];
        Arrays.fill(primecheck, true);
        primecheck[0] = false;
        primecheck[1] = false;
        for (int i=2;i*i<n+1;i++)
        {
            if (primecheck[i])
            {
                for (int j=i*2;j<n+1;j+=i) primecheck[j] = false;
            }
        }
        return primecheck;
    }
    static int[] factor(int n) // to pre calculate prime factors using sieve
    {
        int prime[] = new int[n+1];
        for (int i=2;i<n+1;i++)
        {
            if (prime[i]==0)
            {
                for (int j=i;j<n+1;j+=i)
                {
                    if(prime[j]==0) prime[j]=i;
                }
            }
        }
        return prime;
    }
    static long power(long a, long b)
    {
        long res=1;
        while(b>0)
        {
            if(b%2==0) {a*=a;b/=2;}
            else {res*=a;b--;}
        }
        return res;
    }
    static void dijkstra(LinkedList<Integer> node[],int start,int distance[],int backtrack[])
    {
        distance[start]=1;
        PriorityQueue<Pair1> q = new PriorityQueue<>((x,y)->x.a-y.a);
        q.add(new Pair1(1,1));
        while(!q.isEmpty())
        {
            int t1 = q.peek().a,t2 = q.peek().b;
            q.remove();
            for(int e:node[t2]){
                if(distance[e]>(1+t1)){
                    distance[e]=1+t1;
                    backtrack[e]=t2;
                    q.add(new Pair1(distance[e],e));
                }
            }
        }
    }
    static void disjoint_rankunion(int rank[],int parent[],int t1,int t2)
    {
        int parentt1 = disjoint_findparent(parent,t1),parentt2 = disjoint_findparent(parent,t2);
        int rankt1 = rank[parentt1],rankt2 = rank[parentt2];
        if(parentt1==parentt2) return;
        if(rankt1>rankt2) parent[parentt2] = parentt1;
        else if(rankt2>rankt1) parent[parentt1] = parentt2;
        else {parent[parentt2]=parentt1;rank[parentt1]++;}
    }
    static boolean dfs(LinkedList<Integer> node[],int visited[],int index,int colour[],int color)
    {
        visited[index]=1;
        colour[index]=color;
        for(int e:node[index])
        {
            if(visited[e]==0) {
                if(!dfs(node,visited,e,colour,(color==1?2:1))) return false;
            }
            else{
                if(colour[e]==colour[index]) return false;
            }
        }
        return true;
    }
    static int disjoint_findparent(int parent[],int t1)
    {
        if(parent[t1]==t1) return t1;
        else parent[t1] = disjoint_findparent(parent,parent[t1]);
        return parent[t1];
    }
    public static void main(String[] args) throws IOException
    {
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        FastReader sc = new FastReader();
        int n = sc.nextInt(),m = sc.nextInt(),visited[] = new int[n+1],count=0,colour[] = new int[n+1];
        LinkedList<Integer> node[] = new LinkedList[n+1];
        boolean p = true;
        for(int j=0;j<=n;j++)
            node[j] = new LinkedList<>();
        for(int j=0;j<m;j++)
        {
            int t1 = sc.nextInt(),t2 = sc.nextInt();
            node[t1].add(t2);
            node[t2].add(t1);
        }
        for(int j=1;j<=n;j++)
        {
            if(visited[j]==0) {
                p=dfs(node,visited,j,colour,1);
                if(!p) break;
            }
        }
        if(!p) out.println("IMPOSSIBLE");
        else{
            for(int j=1;j<=n;j++) out.print(colour[j]+" ");
        }
        out.close();
    }
}
class Pair
{

    int a,b,c;
    Pair(int a1,int b1,int c1)
    {
        this.a=a1;
        this.b=b1;
        this.c=c1;
    }
}
class Pair1
{
    int a,b;
    Pair1(int a1,int b1)
    {
        this.a=a1;
        this.b=b1;
    }
}
class Pair3
{
    String a;
    int b;
    Pair3(String a1,int b1)
    {
        this.a=a1;
        this.b=b1;
    }
}