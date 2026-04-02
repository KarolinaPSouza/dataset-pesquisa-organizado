import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class entry_6464644 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ttl=sc.nextInt();
        int[] arr=new int[n];
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        int rem=0,n1=-1,n2=-1,n3=-1,n4=-1;
        int st,en;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            List<Integer> temp;
            if(hm.containsKey(arr[i])){
                temp=hm.get(arr[i]);
                temp.add(i+1);
            }
            else{
                hm.put(arr[i],new ArrayList<Integer>(Arrays.asList(i+1)));
            }
        }
        Arrays.sort(arr);
        first:for(int i=0;i<n;i++){
            if(i>0&&arr[i]==arr[i-1])
                continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1&&arr[j]==arr[j-1])
                    continue;
                rem=ttl-arr[i];
                rem=rem-arr[j];
                st=j+1;
                en=n-1;
                while(st<en){
                    if(arr[st]+arr[en]<rem){
                        st++;
                        while(st<en&&arr[st]==arr[st-1])
                            st++;
                    }
                    else if(arr[st]+arr[en]==rem){
                        n1=arr[i];
                        n2=arr[st];
                        n3=arr[en];
                        n4=arr[j];
                        break first;
                    }
                    else{
                        en--;
                        while(en>st&&arr[en]==arr[en+1])
                            en--;
                    }
                }
            }
        }
        if(n1==-1||n2==-1||n3==-1||n4==-1){
            System.out.print("IMPOSSIBLE");
        }
        else{
            List<Integer> temp=hm.get(n1);
            sb.append(temp.get(0)+" ");
            temp.remove(0);
            temp=hm.get(n2);
            sb.append(temp.get(0)+" ");
            temp.remove(0);
            temp=hm.get(n3);
            sb.append(temp.get(0)+" ");
            temp.remove(0);
            temp=hm.get(n4);
            sb.append(temp.get(0)+" ");
            temp.remove(0);
            System.out.print(sb.toString());
        }
    }

}