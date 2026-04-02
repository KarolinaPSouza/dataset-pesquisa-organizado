import java.io.*;
import java.util.*;

public class entry_16105689 {
  static int n,m;
  static long[] s,p;
  static void pull(int i){
    s[i]=s[2*i]+s[2*i+1];
    p[i]=Math.max(p[2*i],s[2*i]+p[2*i+1]);
  }
  static void upd(int i,long v){
    for(s[i+=m]=v,p[i]=Math.max(0,v),i/=2;i>0;i/=2)pull(i);
  }
  static long qry(int l,int r){
    long ls=0,lp=0,rs=0,rp=0;
    for(l+=m,r+=m;l<=r;l/=2,r/=2){
      if(l%2==1){lp=Math.max(lp,ls+p[l]);ls+=s[l++];}
      if(r%2==0){rp=Math.max(p[r],s[r]+rp);rs+=s[r--];}
    }
    return Math.max(lp,ls+rp);
  }
  public static void main(String[] args)throws Exception{
    Fast r=new Fast(System.in);PrintWriter out=new PrintWriter(System.out);
    n=r.nextInt();int q=r.nextInt();m=1;while(m<n)m*=2;
    s=new long[2*m];p=new long[2*m];
    for(int i=0;i<n;i++){long v=r.nextLong();s[m+i]=v;p[m+i]=Math.max(0,v);}
    for(int i=m-1;i>0;i--)pull(i);
    while(q-->0){
      if(r.nextInt()==1)upd(r.nextInt()-1,r.nextLong());
      else out.println(qry(r.nextInt()-1,r.nextInt()-1));
    }
    out.close();
  }
  static class Fast{
    InputStream in;byte[] b=new byte[1<<16];int p=0,s=0;
    Fast(InputStream i){in=i;}
    byte rd()throws Exception{if(p==s)s=in.read(b,p=0,b.length);return s==-1?-1:b[p++];}
    int nextInt()throws Exception{
      int r=0;byte c=rd();while(c<=' ')c=rd();boolean n=(c=='-');
      if(n)c=rd();do{r=r*10+c-'0';}while((c=rd())>='0'&&c<='9');return n?-r:r;
    }
    long nextLong()throws Exception{
      long r=0;byte c=rd();while(c<=' ')c=rd();boolean n=(c=='-');
      if(n)c=rd();do{r=r*10+c-'0';}while((c=rd())>='0'&&c<='9');return n?-r:r;
    }
  }
}