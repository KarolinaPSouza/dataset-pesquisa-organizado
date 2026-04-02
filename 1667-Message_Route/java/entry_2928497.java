// package contest;

import java.io.*;
import java.util.*;

public class entry_2928497 {
  // static int mod = 1000000007;

  public static void main(String[] args) throws Exception {
    try {
      FastReader in = new FastReader();
      PrintWriter out = new PrintWriter(System.out);
      int n = in.nextInt();
      int m = in.nextInt();

      List<List<Integer>> graph = new ArrayList<>();

      for(int i=0;i<n+1;i++){
        graph.add(new ArrayList<>());
      }

      for(int i=0;i<m;i++){
        int u = in.nextInt();
        int v = in.nextInt();

        graph.get(u).add(v);
        graph.get(v).add(u);
      }

      LinkedList<Integer> q = new LinkedList<>();
      int par[] = new int[n+1];
      Arrays.fill(par, Integer.MAX_VALUE);
      par[1] = -1;
      q.addLast(1);

      while(q.size() > 0){
        int s = q.size();

        while(s-- > 0){
          int rm = q.removeFirst();
          if(rm == n) break;

          for(int nbr : graph.get(rm)){
            if(par[nbr] == Integer.MAX_VALUE){
              par[nbr] = rm;
              q.addLast(nbr);
            }
          }
        }
      }

      if(par[n] != Integer.MAX_VALUE){
        Stack<Integer> st = new Stack<>();
        int p = n;
        while(p != -1){
          st.push(p);
          p = par[p];
        }

        out.println(st.size());
        while(st.isEmpty() == false){
          out.print(st.pop()+" ");
        }
      }else{
        out.println("IMPOSSIBLE");
      }


      out.close();
    } catch (Exception e) {
      System.out.println(e);
      return;
    }
  }

  private static void solve(int i, List<List<Integer>> graph, boolean[] vis) {
    if(vis[i]) return;
    vis[i] = true;
    for(int nbr : graph.get(i)){
      solve(nbr, graph, vis);
    }
  }

  public static class FastReader {
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

    public int nextInt() {
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

    String[] strArray() {
      String str[] = nextLine().split(" ");

      return str;
    }

    int[] intArray(int n) {
      String[] str = strArray();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(str[i]);
      }
      return arr;
    }

    long[] longArray(int n) {
      String[] str = strArray();
      long[] arr = new long[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Long.parseLong(str[i]);
      }
      return arr;
    }

    int[][] two_d_Array(int n, int m){
      int arr[][] = new int[n][m];
      for(int i=0;i<n;i++){
        String[] str = strArray();
        for(int j=0;j<m;j++){
          arr[i][j] = Integer.parseInt(str[j]);
        }

      }
      return arr;
    }

    Integer[] IntArray(int n) {
      String[] str = strArray();
      Integer[] arr = new Integer[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(str[i]);
      }
      return arr;
    }
    void swap (int arr[], int a, int b){
      int temp = arr[a];
      arr[a] = arr[b];
      arr[b] = temp;
    }
  }

  static class SparseMatrix {
    private int[] arr;
    private int m;
    private int[][] minSparse;
    private int[][] minIndex;
    private int[][] maxSparse;
    private int[][] maxIndex;
    private int n;
    public SparseMatrix(int[] arr) {
        this.arr = arr;
        this.m=arr.length;
        this.n=Integer.toBinaryString(m).length();
        minSparse=new int[n][m];
        minIndex=new int[n][m];

        maxSparse=new int[n][m];
        maxIndex=new int[n][m];
 //        for(int i=0;i<n;i++)
 //        {
 //            Arrays.fill(minSparse[i],-1);
 //        }
 //        for(int i=0;i<n;i++)
 //        {
 //            Arrays.fill(minIndex[i],-1);
 //        }

        createMinSparse();
        createMaxSparse();
    }
    private void createMaxSparse()
    {
        for(int j=0;j<m;j++)
        {
            maxSparse[0][j]=arr[j];
            maxIndex[0][j]=j;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j+(1<<(i-1))<m;j++)
            {
                int left=maxSparse[i-1][j];
                int right=maxSparse[i-1][j+(1<<(i-1))];
                maxSparse[i][j]=Math.max(left,right);

                if(left>=right)
                {
                    maxIndex[i][j]=maxIndex[i-1][j];
                }
                else
                {
                    maxIndex[i][j]=maxIndex[i-1][j+(1<<(i-1))];
                }
            }
        }
    }
    private void createMinSparse()
    {
        //filling the first row of sparse matrix with the values of the input array
        for(int j=0;j<m;j++)
        {
            minSparse[0][j]=arr[j];
            minIndex[0][j]=j;
        }
        //filling other rows of the sparse matrix
        for(int i=1;i<n;i++)
        {
            for(int j=0;j+(1<<(i-1))<m;j++)
            {

                int left=minSparse[i-1][j];
                int right=minSparse[i-1][j+(1<<(i-1))];

                //change to min-> max to create MaxSparseMatrix
                minSparse[i][j]=Math.min(left,right);

                //filling index
                if(left<=right)
                {
                    minIndex[i][j]=minIndex[i-1][j];
                }
                else {
                    minIndex[i][j]=minIndex[i-1][j+(1<<(i-1))];
                }

            }
        }
    }

    //get minimum value in range l->r inclusive
 /*
    for any range [l, r] we can find the two values and
    find their minimum. These values are defined below:
     len: length of the required range, i.e., r-l+1
     p: maximum power of 2 that can fit in len. E.g, [1,11] , len=11, thus p=3
     k: 2^p
     find the minimum between sparse[p][l] and sparse[p][r-k+1]
 */
    public int getMin(int l,int r)
    {
        int len=r-l+1;
        int p=Integer.toBinaryString(len).length()-1;
        int k=1<<p;

        int left=minSparse[p][l];
        int right=minSparse[p][r-k+1];
        return Math.min(right,left);
    }

    public int getMinIndex(int l,int r)
    {
        int len=r-l+1;
        int p=Integer.toBinaryString(len).length()-1;
        int k=1<<p;

        int left=minSparse[p][l];
        int right=minSparse[p][r-k+1];
        if (left <= right) {
            return minIndex[p][l];
        } else {
            return minIndex[p][r - k + 1];
        }
    }


    public int getMax(int l,int r)
    {
        int len=r-l+1;
        int p=Integer.toBinaryString(len).length()-1;
        int k=1<<p;

        int left=maxSparse[p][l];
        int right=maxSparse[p][r-k+1];
        return Math.max(right,left);
    }

    public int getMaxIndex(int l,int r)
    {
        int len=r-l+1;
        int p=Integer.toBinaryString(len).length()-1;
        int k=1<<p;
        int left=maxSparse[p][l];
        int right=maxSparse[p][r-k+1];
        if(left>=right)
        {
            return maxIndex[p][l];

        }
        return maxIndex[p][r-k+1];
    }
    void print()
    {
        for(int i=0;i<minSparse.length;i++)
        {
            for(int j=0;j<minSparse[i].length;j++)
            {
                System.out.print(minSparse[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(minIndex[i][j]+" ");
            }
            System.out.println();
        }
    }
 }

}