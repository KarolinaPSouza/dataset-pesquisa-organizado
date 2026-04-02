import java.io.*;
import java.util.*;
public class entry_14504682{
    public static void main(String[]args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long n=Long.parseLong(st.nextToken()),k=Long.parseLong(st.nextToken());
        long[]a=new long[(int)k];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++)a[i]=Long.parseLong(st.nextToken());
        long ans=0;
        for(int i=0;i<(1L<<k);i++){
            long prod=1;int cnt=0;boolean ok=true;
            for(int j=0;j<k;j++)if((i&(1<<j))!=0){
                cnt++;
                if(prod>n/a[j]){ok=false;break;}
                prod*=a[j];
            }
            if(!ok)continue;
            if(cnt%2==0)ans-=n/prod;else ans+=n/prod;
        }
        ans+=n;
        System.out.print(ans);
    }
}
