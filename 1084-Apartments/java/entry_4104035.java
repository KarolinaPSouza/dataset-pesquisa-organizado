import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class entry_4104035 {
 public static void main(String[] args)throws Exception 
 { 
  //importing io functions
  BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
  PrintWriter out = new PrintWriter(System.out);
  StringTokenizer st= new StringTokenizer(br.readLine());
  //this is number of test cases


  int n=Integer.parseInt(st.nextToken());
  int m=Integer.parseInt(st.nextToken());
  int k=Integer.parseInt(st.nextToken());

  int a[]=new int[n];
  String s[]=br.readLine().split(" ");
  for (int i = 0; i < n; i++) {
   a[i]=Integer.parseInt(s[i]);
  }
  int b[]=new int[m];
  s=br.readLine().split(" ");
  for (int i = 0; i < m; i++) {
   b[i]=Integer.parseInt(s[i]);
  }
  sort(a,0,a.length-1);
  sort(b,0,b.length-1);
  int p=0;
  int q=0;
  int count = 0;
  while ( ( p < a.length ) &&  ( q < b.length ) )
  {
   if (  ( b[q] >= a[p]-k )  && (b[q] <=a[p]+k ))
   {
    count++;
    p++;
    q++;
   }
   else
   {
    if(b[q]>a[p])
     p++;
    else
     q++;
   }

  }
  out.println(count);

  out.flush();
 }
 static int gcd(int a, int b)
 {
  if (b == 0)
   return a;
  return gcd(b, a % b);
 }

 static void merge(int arr[], int l, int m, int r)
 {
  // Find sizes of two subarrays to be merged
  int n1 = m - l + 1;
  int n2 = r - m;

  /* Create temp arrays */
  int L[] = new int[n1];
  int R[] = new int[n2];

  /*Copy data to temp arrays*/
  for (int i = 0; i < n1; ++i)
   L[i] = arr[l + i];
  for (int j = 0; j < n2; ++j)
   R[j] = arr[m + 1 + j];

  /* Merge the temp arrays */

  // Initial indexes of first and second subarrays
  int i = 0, j = 0;

  // Initial index of merged subarray array
  int k = l;
  while (i < n1 && j < n2) {
   if (L[i] <= R[j]) {
    arr[k] = L[i];
    i++;
   }
   else {
    arr[k] = R[j];
    j++;
   }
   k++;
  }

  /* Copy remaining elements of L[] if any */
  while (i < n1) {
   arr[k] = L[i];
   i++;
   k++;
  }

  /* Copy remaining elements of R[] if any */
  while (j < n2) {
   arr[k] = R[j];
   j++;
   k++;
  }
 }

 // Main function that sorts arr[l..r] using
 // merge()
 static void sort(int arr[], int l, int r)
 {
  if (l < r) {
   // Find the middle point
   int m =l+ (r-l)/2;

   // Sort first and second halves
   sort(arr, l, m);
   sort(arr, m + 1, r);

   // Merge the sorted halves
   merge(arr, l, m, r);
  }
 }
}