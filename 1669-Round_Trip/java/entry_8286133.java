/*
░█████╗░██╗░██████╗██╗░░██╗░██╗░░░░░░░██╗░█████╗░██████╗░██╗░░░██╗
██╔══██╗██║██╔════╝██║░░██║░██║░░██╗░░██║██╔══██╗██╔══██╗╚██╗░██╔╝
███████║██║╚█████╗░███████║░╚██╗████╗██╔╝███████║██████╔╝░╚████╔╝░
██╔══██║██║░╚═══██╗██╔══██║░░████╔═████║░██╔══██║██╔══██╗░░╚██╔╝░░
██║░░██║██║██████╔╝██║░░██║░░╚██╔╝░╚██╔╝░██║░░██║██║░░██║░░░██║░░░
╚═╝░░╚═╝╚═╝╚═════╝░╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░
*/
import java.util.*;
import java.io.*;
 public class entry_8286133 {
    static int M=(int)(1e9+7);
    // static int M=998244353;
    static FastReader in  = new FastReader();
    static FastWriter out = new FastWriter();

    @SuppressWarnings("unchecked")

    // हर हर महादेव
    // हरे कृष्णा 

    // Yesterday was history
    // Tomorrow will be a mystery
    // but today is a gift
    // That is why it is called the present


    /* stuff you should look for
 * int overflow, array bounds
 * special cases (n=1?)
 * do smth instead of nothing and stay organized
 * WRITE STUFF DOWN
 * DON'T GET STUCK ON ONE APPROACH
    */
    public static void main(String[] args)throws Exception
    {
        int testcases=1;
        // testcases=in.nextInt();
        outer:
        while(testcases-->0)
        {
            // YES(solve());
            // Yes(solve());
            solve();
        }
        out.close();
    } 

    static ArrayList<ArrayList<Integer>> graph;
    static boolean visited[];
    static boolean flag=false;
    static int end=-1;
    @SuppressWarnings("unchecked")
    public static void solve()throws Exception
    {
        int n=in.nextInt();
        int m=in.nextInt();
        inputGraph(n,m);
        parent=new int[n];;
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            dfx(i,-1);
            if(flag)
            {

                break;
            }
        }
        if(flag)
        {
            ArrayList<Integer> al=new ArrayList<>();
            // out.println(start);
            // out.println(end);
            int cur=end;
            while(cur!=start)
            {
                al.add(cur+1);
                cur=parent[cur];
            }
            al.add(start+1);
            al.add(end+1);
            out.println(al.size());
            for(int i:al)out.print(i+" ");endl();
        }
        else 
        {
            out.println("IMPOSSIBLE");
        }
    }
    static int start=0;
    static int parent[];

    public static void dfx(int u,int p)
    {
        visited[u]=true;
        parent[u]=p;
        for(int child:graph.get(u))
        {
            if(!visited[child])
            {
                dfx(child,u);
            }
            else if(child!=p)
            {
                end=child;
                start=u;
                flag=true;
            }
        }
    }

    public static void inputGraph(int V,int n)//Zero based indexing
    {
        graph=new ArrayList<ArrayList<Integer>>();
        visited=new boolean[V];
        for(int i=0;i<V;i++)graph.add(new ArrayList<>());
        for(int i=0;i<n;i++)
        {
            int x=in.nextInt();
            int y=in.nextInt();
            x--;
            y--;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

    }

    public static int maxIntArray(ArrayList<Integer> ar)
    {
        int max=ar.get(0);
        for(int i=0;i<ar.size();i++)max=Math.max(max,ar.get(i));
        return max;
    }

    public static int minIntArray(ArrayList<Integer> ar)
    {

        int n=ar.size();
        int max=ar.get(0);
        for(int i=0;i<n;i++)max=Math.min(max,ar.get(i));
        return max;
    }
    public static int maxIntArray(int ar[])
    {
        int max=ar[0];
        for(int i=0;i<ar.length;i++)max=Math.max(max,ar[i]);
        return max;
    }

    public static int minIntArray(int ar[])
    {

        int max=ar[0];
        for(int i=0;i<ar.length;i++)max=Math.min(max,ar[i]);
        return max;
    }



    public static int lower(int ar[],int x)//smallest index such that ar[ind]>=x
    {
        int min=0;
        int max=ar.length-1;
        int ans=ar.length;;
        while(max>=min)
        {
            int mid=(max+min)>>1;
            if(ar[mid]>=x)
            {
                ans=mid;
                max=mid-1;
            }
            else min=mid+1;
        }
        return ans;
    }

    public static int upper(int ar[],int x)//smallest index such that ar[ind]>x
    {
        int min=0;
        int max=ar.length-1;
        int ans=ar.length;
        while(max>=min)
        {
            int mid=(max+min)>>1;
            if(ar[mid]>x)
            {
                ans=mid;
                max=mid-1;
            }
            else min=mid+1;
        }
        return ans;
    }
    public static boolean isSorted(int ar[])
    {
        int n=ar.length;
        if(n==1)return true;
        int min=ar[1]-ar[0];
        for(int i=1;i<n;i++)min=Math.min(min,ar[i]-ar[i-1]);
        if(min>=0)return true;
        else return false;
    }
    public static long pow(long a,long n)
    {
        long  ans=1;
        while(n!=0)
        {
            if((n&1)==1)
            {
                ans=(ans%M*a%M)%M;
            }
            a=((a%M)*(a%M))%M;
            n=n/2;
        }
        return ans;
    }

    public static long sqrT(long n)
    {
        long min=0;
        long max=(int)(2e9);//important (3e9) can also be used
        long ans=0;
        while(max>=min)
        {
            long mid=min+(max-min)/2;
            if(mid*mid<=n)
            {
                ans=mid;
                min=mid+1;
            }
            else max=mid-1;
        }
        return ans;
    }
    public static boolean isSorted(int ar[],int n)
    {
        if(n==1)return true;
        int diff=ar[1]-ar[0];
        for(int i=1;i<n;i++)
        {
            diff=Math.min(diff,ar[i]-ar[i-1]);
        }
        if(diff<0)return false;
        return true;
    }
    public static boolean isSorted(Integer ar[],int n)

    {
        if(n==1)return true;
        int diff=ar[1]-ar[0];
        for(int i=1;i<n;i++)
        {
            diff=Math.min(diff,ar[i]-ar[i-1]);
        }
        if(diff<0)return false;
        return true;
    }
    public static void minusOne()throws Exception
    {
        out.print(-1);endl();
    }
    public static void endl()throws Exception
    {
        out.println();
    }
    public static void zero()throws Exception
    {
        out.println(0);
    }
    public static void one()throws Exception
    {
        out.println(1);
    }
    public static void two()throws Exception
    {
        out.println(2);
    }
    public static long gcd(long a,long b)//Note a>b
    {  
      if(b==0)return a;
      return gcd(b,a%b);
    }
    public static long lcm(long a,long b)
    {
        return a*b/gcd(a,b);
    }
    public static int lower(Integer ar[],int num)
    {
        int min=0;
        int max=ar.length-1;
        int ans=max+1;
        while(max>=min)
        {
            int mid=(min+max)/2;
            if(ar[mid]>=num)
            {
                ans=mid;
                max=mid-1;
            }
            else min=mid+1;
        }
        //if(ar[ans]!=num)ans++;
        return ans;
    }
    public static int lower(ArrayList<Long> ar,long num)
    {
        int min=0;
        int max=ar.size()-1;
        int ans=max+1;
        while(max>=min)
        {
            int mid=(min+max)/2;
            if(ar.get(mid)>=num)
            {
                ans=mid;
                max=mid-1;
            }
            else min=mid+1;
        }
        //if(ar[ans]!=num)ans++;
        return ans;
    }
    public static int upper(Integer ar[],int num)
    {
        int min=0;
        int max=ar.length-1;
        int ans=max;
        while(max>=min)
        {
            int mid=(max+min)/2;
            if(ar[mid]>num)
            {
                ans=mid;
                max=mid-1;
            }
            else min=mid+1;
        }
        return ans;
    }
    public static int upper(ArrayList<Integer> ar,int num)
    {
        int min=0;
        int max=ar.size()-1;
        int ans=max;
        while(max>=min)
        {
            int mid=(max+min)/2;
            if(ar.get(mid)>num)
            {
                ans=mid;
                max=mid-1;
            }
            else min=mid+1;
        }
        return ans;
    }
    public static long productOfDigit(int n)
    {
        long ans=1;
        while(n!=0)
        {
            ans*=n%10;
            n=n/10;
        }
        return ans;
    }

    public static void addMap(TreeMap<Integer,Integer> map,int element)
    {
        if(map.containsKey(element))
        map.put(element,map.get(element)+1);
        else map.put(element,1);
    }
    public static void removeMap(TreeMap<Integer,Integer> map,int element)
    {
        if(map.get(element)==1)map.remove(element);
        else map.put(element,map.get(element)-1);
    }
    public static void removeMap(TreeMap<Long,Integer> map,long element)
    {
        if(!map.containsKey(element))return;
        if(map.get(element)==1)map.remove(element);
        else map.put(element,map.get(element)-1);
    }
    public static void removeMap(HashMap<Integer,Integer> map,int element)
    {
        if(map.get(element)==1)map.remove(element);
        else map.put(element,map.get(element)-1);
    }
    public static void addMap(TreeMap<Object,Integer> map,Integer element)
    {
        if(map.containsKey(element))
        map.put(element,map.get(element)+1);
        else map.put(element,1);
    }

    public static void addMap(TreeMap<String,Integer> map,String element)
    {
        if(map.containsKey(element))
        map.put(element,map.get(element)+1);
        else map.put(element,1);
    }

    public static void addMap(TreeMap<Long,Integer> map,long element)
    {
        if(map.containsKey(element))
        map.put(element,map.get(element)+1);
        else map.put(element,1);
    }
    public static void addMap(HashMap<Integer,Integer> map,int element)
    {
        if(map.containsKey(element))
        map.put(element,map.get(element)+1);
        else map.put(element,1);
    }
    public static void addMap(HashMap<Long,Long> map,long element)
    {
        if(map.containsKey(element))
        map.put(element,map.get(element)+1);
        else map.put(element,1L);
    }
    public static void addMap(HashMap<Object,Integer> map,Integer element)
    {
        if(map.containsKey(element))
        map.put(element,map.get(element)+1);
        else map.put(element,1);
    }
    public static void addMap(HashMap<Long,Integer> map,Long element)
    {
        if(map.containsKey(element))
        map.put(element,map.get(element)+1);
        else map.put(element,1);
    }
    public static void addMap(HashMap<String,Integer> map,String element)
    {
        if(map.containsKey(element))
        map.put(element,map.get(element)+1);
        else map.put(element,1);
    }



    public static int[] nextIntArray(int n)throws Exception
    {
        int ar[]=new int[n];
        for(int i=0;i<n;i++)ar[i]=in.nextInt();
        return ar;
    }
    public static long[] nextlongArray(int n)throws Exception//For long
    {
        long ar[]=new long[n];
        for(int i=0;i<n;i++)ar[i]=in.nextLong();
        return ar;
    }
    public static Integer[] nextIntegerArray(int n)throws Exception
    {
        Integer ar[]=new Integer[n];
        for(int i=0;i<n;i++)ar[i]=in.nextInt();
        return ar;
    }
    public static Long[] nextLongArray(int n)//For Long array
    {
        Long ar[]=new Long[n];
        for(int i=0;i<n;i++)ar[i]=in.nextLong();
        return ar;
    }
    public static String[] nextStringArray(int n)
    {
        String ar[]=new String[n];
        for(int i=0;i<n;i++)ar[i]=in.next();
        return ar;
    }

    public static void Yes(boolean flag)throws Exception
    {
        if(flag)out.println("Yes");
        else  out.println("No");
    }
    public static void YES(boolean flag)throws Exception
    {
        if(flag)out.println("YES");
        else  out.println("NO");
    }
    public static void YES()throws Exception
    {
        out.println("YES");
    }
    public static void NO()throws Exception
    {
        out.println("NO");
    }
    public static void Yes()throws Exception
    {
        out.println("Yes");
    }
    public static void No()throws Exception
    {
        out.println("No");
    }

    public static void printArrayListPair(ArrayList<Pair> al)throws Exception
    {
        for(int i=0;i<al.size();i++)
        {
            out.println(al.get(i).a+" "+al.get(i).b);
        }
    }

    public static void printArray(boolean ar[])throws Exception{
        for(boolean x:ar)out.print(x+" ");
        out.println();
    }

    public static void printArray(int ar[])throws Exception
    {
        for(int x:ar)out.print(x+" ");
        out.println();
    }  
    public static void printArray(Object ar[])throws Exception
    {
        for(Object x:ar)out.print(x+" ");
        out.println();
    }   
    public static void printArray(long ar[])throws Exception
    {
        for(long x:ar)out.print(x+" ");
        out.println();
    }    
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
    public FastReader()
        {
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next()
        {
            while(st==null || !st.hasMoreTokens())
            {
                try 
                {
                    st=new StringTokenizer(br.readLine());
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt()
        {
            return Integer.parseInt(next());
        }
        long nextLong()
        {
            return Long.parseLong(next());
        }
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
        int[] nextIntArray(int n)
        {
            int ar[]=new int[n];
            for(int i=0;i<n;i++)ar[i]=Integer.parseInt(next());
            return ar;
        }
        long[] nextlongArray(int n)
        {
            long ar[]=new long[n];
            for(int i=0;i<n;i++)ar[i]=Long.parseLong(next());
            return ar;
        }
        String nextLine()
        {
            String str="";
            try 
            {
                str=br.readLine().trim();
            } catch (Exception e) 
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter 
    {
        private final BufferedWriter bw;

    public FastWriter() 
        {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

    public void print(Object object) throws IOException 
        {
            bw.append("" + object);
        }
    public void println(Object object) throws IOException 
        {
            print(object);
            bw.append("\n");
        }
    public void println() throws IOException
        {
            bw.append("\n");
        }
    public void close() throws IOException 
        {
            bw.close();
        }
    }
}
class Pair
{
    int a,b,c;
    boolean flag;
    Pair(int a,int b,boolean flag)
    {
        this.a=a;
        this.b=b;
        this.flag=flag;
    }
    Pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
    Pair (int a,int b,int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }


    public String toString()
    {
        return  a+" "+b;
        // return a+" "+b+" "+c;
    }
}

class compare1 implements Comparator<Pair>
{
    public int compare(Pair p1,Pair p2)
    {
        // if(p1.a==p2.a && p2.b==p1.b)return 0;
        return p2.a-p1.a;//decreasing
        // if(p1.a!=p2.a)
        // return p1.a-p2.a;//increasing
        // else 
        // return p1.b-p2.b;
        // if(p1.a==p2.a)
        // {
        //     return p2.b-p1.b;
        // }
        // else return +p1.a-p2.a;
        // if(p1.a!=p2.a)
        //     return p1.a-p2.a;
        // else 
        //     return p2.b-p1.b;
    }
}



// import java.util.Arrays;

 class LongSegmentTree {
    private long[] tree;
    private long[] lazy;
    private long[] arr;

    public LongSegmentTree(long[] input) {
        int n = input.length;
        int treeSize = 4 * n; // A safe estimate for the tree size

        tree = new long[treeSize];
        lazy = new long[treeSize];
        arr = input;

        build(1, 0, n - 1);
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    public void update(int index, long value) {
        update(1, 0, arr.length - 1, index, value);
    }

    private void update(int node, int start, int end, int index, long value) {
        if (start == end) {
            arr[index] = value;
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;
        if (start <= index && index <= mid) {
            update(2 * node, start, mid, index, value);
        } else {
            update(2 * node + 1, mid + 1, end, index, value);
        }

        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    public long query(int left, int right) {
        return query(1, 0, arr.length - 1, left, right);
    }

    private long query(int node, int start, int end, int left, int right) {
        if (right < start || left > end) {
            return 0; // Out of range
        }

        if (left <= start && right >= end) {
            return tree[node]; // Current segment is fully within the query range
        }

        int mid = (start + end) / 2;
        long leftSum = query(2 * node, start, mid, left, right);
        long rightSum = query(2 * node + 1, mid + 1, end, left, right);

        return leftSum + rightSum;
    }

 }