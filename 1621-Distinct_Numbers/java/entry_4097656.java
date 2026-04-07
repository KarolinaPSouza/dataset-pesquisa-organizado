import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */


public class entry_4097656 {


 public static void main (String[] args) throws java.lang.Exception
 {

  //Reader r = new Reader();
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  Set<Integer> set = new HashSet<>();
  /*while(t-->0){
     solve(r);
  } */ 
  for(int i = 0; i < n; i++){
   set.add(sc.nextInt());
  }
  System.out.println(set.size());

 }

 /*public static int solve(int ar[]) throws Exception{
        long sum = 0;
    for(int i : ar){
   sum += i;
    }
    if(sum%2==0)return 0;
    else return 1;
  } 
   public static class Graph{
    ArrayList<Integer>[] graph;
    int nodeCount;
    int edgesCount;
    int[] nodeValue;
    //boolean[] visited = new boolean[n+1];
    public Graph(int n){
       nodeCount = n;
       graph = new ArrayList[n+1];
       initGraph();
    }
        public void setNodeValue(int[] arr){
       nodeValue = new int[nodeCount+1];
       for(int i = 1; i<=nodeCount; i++){
          nodeValue[i] = arr[i-1];
       }
    }
     private void initGraph(){
       for(int i = 0; i<=nodeCount; i++){
          graph[i] = new ArrayList<>();
       }
    }
        public void addOrientedEdge(int u, int v){
       graph[u].add(v);
    }
        public void addEdge(int u, int v){
       graph[u].add(v);
       graph[v].add(u);
    }
         }
  public static class myArray{
    public static void swap(int[] arr, int i, int j){
       int temp = arr[i] ;
       arr[i] = arr[j];
       arr[j] = temp;
    }
            public static void reverseArr(int[] arr){
       int  i = 0;
       int j = arr.length-1;
       while(i<j){
          swap(arr,i,j);
          i++;
          j--;
       }
    }
 }
  public static class SegmentTree{
    int[] tree;
    int count;
        public SegmentTree(int[] arr){
       count = arr.length;
       tree = new int[4*count];
       build(arr,0,count-1,1);
    }
        public SegmentTree(int n){
       count = n;
       int[] arr = new int[n];
       tree = new int[n*4];
       build(arr,0,count-1,1);
    }
        public void build(int[] arr, int s, int e, int node){
       if(s==e){
          tree[node] = arr[s];
          return;
       }
       int mid = s+(e-s)/2;
       build(arr,s,mid,node*2);
       build(arr,mid+1,e,node*2+1);
       tree[node]= tree[node*2]+tree[node*2+1];
    }
    void update(int pos ,int val){
       update(1,0,count-1,pos,val);
    }
    private void update(int node, int s , int e , int pos, int val){
       if(e<pos||s>pos) return;
       if(s==e && e==pos){
         // System.out.println("Updating "+ s + " to " + e + " : " + val);
          tree[node] = val;
          return;
       }
       int mid = s+(e-s)/2;
       update(node*2,s,mid,pos,val);
       update(node*2+1,mid+1,e,pos,val);
       tree[node]= tree[node*2]+tree[node*2+1];
       //System.out.println("Updating "+ s + " to " + e + " : " + tree[node]);
    }
    int get(int l , int r){
       return get(1,0,count-1,l,r);
    }
   private int get(int node , int s , int e, int l , int r){
      if(e<l||s>r) return 0;
            if(s==e ||(s>=l && e<=r)){
         //System.out.println("returning sum from " + s + " to " +e " : " + tree[node]);
         return tree[node];
      }
      int mid = s + (e-s)/2;
      int left = get(node*2,s,mid,l,r);
      int right = get(node*2+1,mid+1,e,l,r);
      return left + right;
   }
     }
  public static class Pair{
    int val;
    int sval;
    public Pair(int v , int i){
       this.val = v;
       this.sval = i;
    }
 }*/

 public static class Reader {
      BufferedReader br;

      public Reader(){
         br = new BufferedReader(new InputStreamReader(System.in));
      }

      public int tN() throws Exception {
         return Integer.parseInt(takeString());
      }
      public long tL() throws Exception {
         return Long.parseLong(takeString());
      }
      public int[] tIA() throws Exception {
         String[] arr = tSA();
         int[] vals = convertStringIntoArray(arr);
         return vals;
      }

      public long[] tLA() throws Exception{

         String[] arr = br.readLine().split(" ");
         long[] res = new long[arr.length];
         for(int i = 0; i<arr.length; i++){
            res[i] = Long.parseLong(arr[i]);
         }
         return res;
      }
      public String takeString() throws Exception{
         return br.readLine();
      }

      public String[] tSA() throws Exception{
         return takeString().split(" ");
      }

      public static int[] convertStringIntoArray(String[] nums){
       int[] arr = new int[nums.length];
       for(int i =0; i<nums.length; i++){
          arr[i] = Integer.parseInt(nums[i]);
       }
       return arr;
    }

   }


}