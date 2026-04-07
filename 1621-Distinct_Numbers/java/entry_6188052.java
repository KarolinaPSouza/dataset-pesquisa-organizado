
import java.util.Scanner;

public class entry_6188052 {
 static Scanner scanner=new Scanner(System.in);
 static StringBuilder builder=new StringBuilder();

 static int ti(String s) {
  return Integer.parseInt(s);
 }

 static void heap(int[] a,int n,int i) {
  int l=2*i+1;
  int r=2*i+2;
  int mi=i;

  if(l<n && a[mi]<a[l])
   mi=l;
  if(r<n && a[mi]<a[r])
   mi=r;

  if(mi!=i) {
   int tmp=a[mi];
   a[mi]=a[i];
   a[i]=tmp;
   heap(a,n,mi);
  }
 }

 static void hs(int[] a,int n) {
  for(int i=n/2-1;i>=0;--i)
   heap(a,n,i);
  for(int i=n-1;i>0;--i) {
   int tmp=a[0];
   a[0]=a[i];
   a[i]=tmp;
   heap(a,i,0);
  }
 }

 static void exec() {
  int n=ti(scanner.next());
  int[] a=new int[n];

  for(int i=0;i<n;++i)
   a[i]=ti(scanner.next());

  hs(a,n);

  int cnt=1;
  for(int i=1;i<n;++i)
   if(a[i]!=a[i-1]) ++cnt;

  System.out.println(cnt);
 }

 public static void main(String[] args) {
//  int t=Integer.parseInt(scanner.nextLine());
//  
//  while(t-->0)
   exec();

//  System.out.print(builder);

  scanner.close();
 }
}