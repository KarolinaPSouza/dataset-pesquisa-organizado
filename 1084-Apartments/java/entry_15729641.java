//package HMSSS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_15729641 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] ins=br.readLine().split(" ");
        int n=Integer.parseInt(ins[0]);
        int m=Integer.parseInt(ins[1]);
        int k=Integer.parseInt(ins[2]);
        int[] arr=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] deps=new int[m];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            deps[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Arrays.sort(deps);
        int prev=0;
        int cnt=0;
        for (int i = 0; i < n; i++) {
//            if(prev)
            int idx=bs(prev,m-1,deps,k,arr[i]);
            if(idx==-1){
                continue;
            }
                prev=idx+1;
                cnt++;

        }
        System.out.println(cnt);
    }
    public static int bs(int s,int e,int[] deps,int k,int desired){
        long l=desired-k;
        long r=desired+k;
        int ans=-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(l<=deps[m] && deps[m]<=r){
                e=m-1;
                ans=m;
            }else if(deps[m]<l){
                s=m+1;
            }else{
                e=m-1;
            }
        }
        return ans;
    }
}