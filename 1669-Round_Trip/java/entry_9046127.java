/*
░█████╗░██╗░██████╗██╗░░██╗░██╗░░░░░░░██╗░█████╗░██████╗░██╗░░░██╗
██╔══██╗██║██╔════╝██║░░██║░██║░░██╗░░██║██╔══██╗██╔══██╗╚██╗░██╔╝
███████║██║╚█████╗░███████║░╚██╗████╗██╔╝███████║██████╔╝░╚████╔╝░
██╔══██║██║░╚═══██╗██╔══██║░░████╔═████║░██╔══██║██╔══██╗░░╚██╔╝░░
██║░░██║██║██████╔╝██║░░██║░░╚██╔╝░╚██╔╝░██║░░██║██║░░██║░░░██║░░░
╚═╝░░╚═╝╚═╝╚═════╝░╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░
*/
import java.util.*;
import java.io.*;import java.math.BigInteger;
public class entry_9046127 {
    static int M=(int)(1e9+7);
    // static int M=998244353;
    static FastReader in  = new FastReader();
    static FastWriter out = new FastWriter();
    static double PI=3.1415926535897932384626433832795;
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
    static ArrayList<ArrayList<Edge>> g1;
    static ArrayList<ArrayList<Edge>> g2;
    static boolean visited[];  
    static int parent[];
    static Scanner sc=new Scanner(System.in);
    @SuppressWarnings("unchecked")
    public static void solve()throws Exception
    {
        int n=in.nextInt();
        int m=in.nextInt();
        graph=new ArrayList<>();
        parent=new int [n];
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        for(int i=0;i<m;i++)
        {
            int a=in.nextInt();
            int b=in.nextInt();
            a--;b--;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        visited=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                if(dfs(i,-1))
                {
                    ArrayList<Integer> al=new ArrayList<>();
                    int ss=start;
                    while(start!=end)
                    {
                        al.add(start+1);
                        start=parent[start];
                    }
                    al.add(end+1);
                    al.add(ss+1);
                    out.println(al.size());
                    for(int x:al)out.print(x+" ");
                    endl();
                    return;
                }
            }
        }
        out.println("IMPOSSIBLE");
    }
    static int start=0;
    static int end=0;
    public static boolean dfs(int u,int p)
    {
        visited[u]=true;
        parent[u]=p;
        for(int child:graph.get(u))
        {
            if(!visited[child])
            {
                if(dfs(child,u))return true;
            }
            else if(visited[child] && child!=p)
            {

                start=u;
                end=child;
                return true;
            }
        }
        return false;
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

    public static void inputGraph(int V,int n)//Zero based indexing
    {
        graph=new ArrayList<ArrayList<Integer>>();
        visited=new boolean[V];
        for(int i=0;i<=V;i++)graph.add(new ArrayList<>());// = for one based indexing
        for(int i=0;i<n;i++)
        {
            int x=in.nextInt();
            int y=in.nextInt();
            // x--;
            // y--;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

    }



    public static void reverseArray(Integer a[])
    {
        int n=a.length;
        for(int i=0;i<a.length/2;i++)
        {
            a[i]=a[n-i-1]^a[i];

            a[n-i-1]=a[n-i-1]^a[i];
            a[i]=a[n-i-1]^a[i];
        }

    }

    public static void printArrayList(ArrayList<Object> al)throws Exception
    {
        for(Object o:al)out.print(al+" ");
        endl();
    }

    public static long min(long a,long b)
    {
        return Math.min(a,b);
    }

    public static long max(long a,long b)
    {
        return Math.max(a,b);
    }

    public static int min(int a,int b)
    {
        return Math.min(a,b);
    }

    public static int max(int a,int b)
    {
        return Math.max(a,b);
    }

    public static boolean isSorted(long ar[])
    {
        int n=ar.length;
        for(int i=0;i<n-1;i++)
        {
            if(ar[i]>ar[i+1])return false;
        }
        return true;
    }


    public static int maxIntArray(ArrayList<Integer> ar)
    {
        int max=ar.get(0);
        for(int i=0;i<ar.size();i++)max=Math.max(max,ar.get(i));
        return max;
    }
    private static int countDigits(long l) 
    {
        if (l >= 1000000000000000000L) return 19;
        if (l >= 100000000000000000L) return 18;
        if (l >= 10000000000000000L) return 17;
        if (l >= 1000000000000000L) return 16;
        if (l >= 100000000000000L) return 15;
        if (l >= 10000000000000L) return 14;
        if (l >= 1000000000000L) return 13;
        if (l >= 100000000000L) return 12;
        if (l >= 10000000000L) return 11;
        if (l >= 1000000000L) return 10;
        if (l >= 100000000L) return 9;
        if (l >= 10000000L) return 8;
        if (l >= 1000000L) return 7;
        if (l >= 100000L) return 6;
        if (l >= 10000L) return 5;
        if (l >= 1000L) return 4;
        if (l >= 100L) return 3;
        if (l >= 10L) return 2;
        return 1;
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

    // public static void addMap(TreeMap<Integer,Integer> map,Integer element)
    // {
    //     if(map.containsKey(element))
    //     map.put(element,map.get(element)+1);
    //     else map.put(element,1);
    // }
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

    public static void removeMap(HashMap<String,Integer> map,String element)
    {
        if(map.get(element)==1)map.remove(element);
        else map.put(element,map.get(element)-1);
    }
    // public static void addMap(TreeMap<Object,Integer> map,Integer element)
    // {
    //     if(map.containsKey(element))
    //     map.put(element,map.get(element)+1);
    //     else map.put(element,1);
    // }

    public static void addMap(TreeMap<Integer,Integer> map,Integer element)
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

class Edge 
{
    int a,b;long weight;
    Edge(int a,int b,long weight)
    {
        this.a=a;
        this.b=b;
        this.weight=weight;
    }
    Edge(int a,long weight)
    {
        this.a=a;
        this.weight=weight;
    }
}

class compareEdge implements Comparator<Edge>
{
    public int compare(Edge p1,Edge p2)
    {
        return Long.compare(p1.weight, p2.weight);
    }
}

class Pair
{
    int a,b;
    int c;
    int d;
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

    Pair (int a,int b,int c,int d)
    {
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
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
        // return p2.a-p1.a;//decreasing
        // return p1.c-p2.c;
        // if(p1.a!=p2.a)
        // return p1.a-p2.a;//increasing
        // if(p1.a==p2.b)return p1.b-p2.b;

        return p1.b-p2.b;

        // return p2.c-p1.c;
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

    public boolean equals(Pair p1,Pair p2)
    {
        return p1.a==p2.a && p2.b==p1.b;
    }
}

class FenwickTree {
    private int[] tree;

    public FenwickTree(int size) {
        tree = new int[size + 1]; // Increase size by 1 to handle 1-based indexing
    }

    public void update(int i, int delta) {
        i++; // Convert to 1-based indexing
        while (i < tree.length) {
            tree[i] += delta;
            i += (i & -i); // Move to next node
        }
    }

    public int query(int i) {
        int sum = 0;
        i++; // Convert to 1-based indexing
        while (i > 0) {
            sum += tree[i];
            i -= (i & -i); // Move to previous node
        }
        return sum;
    }

    public int rangeQuery(int left, int right) {
        return query(right) - query(left - 1);
    }

    public static FenwickTree build(int[] nums) {
        FenwickTree ft = new FenwickTree(nums.length);
        for (int i = 0; i < nums.length; i++) {
            ft.update(i, nums[i]);
        }
        return ft;
    }

    public int[] display() {
        int[] result = new int[tree.length - 1]; // Exclude the extra element used for 1-based indexing
        for (int i = 1; i < tree.length; i++) {
            result[i - 1] = query(i) - query(i - 1);
        }
        return result;
    }
}

// // Example usage
// public class entry_9046127 {
//     public static void main(String[] args) {
//         int[] nums = {1, 3, 5, 7, 9, 11};
//         FenwickTree ft = FenwickTree.build(nums);

//         // Update element at index 2 to 10
//         ft.update(2, 10);

//         // Display the current array
//         System.out.println("Current array: " + Arrays.toString(ft.display()));

//         // Get prefix sum up to index 3
//         System.out.println("Prefi