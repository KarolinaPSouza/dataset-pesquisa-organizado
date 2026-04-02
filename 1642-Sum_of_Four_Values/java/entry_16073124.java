import java.io.*;
import java.util.*;
public class entry_16073124 {
static class P
{
long v;int i;
P(long val,int idx)
{
    v=val;i=idx;
}
}
public static void main(String[] a)throws Exception
{
BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
StringTokenizer t=new StringTokenizer(b.readLine());
int n=Integer.parseInt(t.nextToken());
long x=Long.parseLong(t.nextToken());
P[] p=new P[n];
t=new StringTokenizer(b.readLine());
for(int i=0;i<n;i++)
p[i]=new P(Long.parseLong(t.nextToken()),i+1);
Arrays.sort(p,(x1,x2)->Long.compare(x1.v,x2.v));
for(int i=0;i<n;i++)
{
for(int j=i+1;j<n;j++)
{
int l=j+1,r=n-1;
while(l<r)
{
long s=p[i].v+p[j].v+p[l].v+p[r].v;
if(s==x)
{
System.out.println(p[i].i+" "+p[j].i+" "+p[l].i+" "+p[r].i);
return;
}
else if(s<x)
l++;
else 
r--;
}
}
}
System.out.println("IMPOSSIBLE");
}
}